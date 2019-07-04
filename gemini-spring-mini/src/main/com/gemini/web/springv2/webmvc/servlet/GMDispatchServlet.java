package com.gemini.web.springv2.webmvc.servlet;

import com.gemini.web.springv2.annotation.GMRequestMapping;
import com.gemini.web.springv2.annotation.GMController;
import com.gemini.web.springv2.annotation.GMRequestParam;
import com.gemini.web.springv2.aop.GMAopProxyUtils;
import com.gemini.web.springv2.context.GMApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.web.springv2.webmvc.servlet
 * @classname: GMDispatchServlet
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/17 14:38
 */

/**
 * 作为 入口
 */
public class GMDispatchServlet extends HttpServlet {

    private final String[] locations  = {"application.properties"};

    //private Map<String, Method> handlerMapping = new HashMap<String, Method>();
    List<GMHandlerMapping>  handlerMappings = new ArrayList<GMHandlerMapping>();

    //private List<GMHandlerAdapter> handlerAdapters = new ArrayList<GMHandlerAdapter>();
    private Map<GMHandlerMapping,GMHandlerAdapter> handlerAdapters = new ConcurrentHashMap<GMHandlerMapping, GMHandlerAdapter>();

   private List<GMViewResolver> viewResolvers = new ArrayList<GMViewResolver>();
    public GMDispatchServlet() {
    }

    @Override
    public void init() throws ServletException {
        GMApplicationContext gmApplicationContext = new GMApplicationContext(locations);
        initStrategies(gmApplicationContext);

    }

    /**
     * 初始化操作
     * @param gmApplicationContext
     */
    private void initStrategies(GMApplicationContext gmApplicationContext) {
        //initMultipartResolver(context);
        //initLocaleResolver(context);
        //initThemeResolver(context);
        initHandlerMappings(gmApplicationContext);
        initHandlerAdapters(gmApplicationContext);
        //initHandlerExceptionResolvers(context);
        //initRequestToViewNameTranslator(context);
        initViewResolvers(gmApplicationContext);
        //initFlashMapManager(context);
    }

    /**
     * 用来保存Controller中配置的RequestMapping 和Method的一个对应关系
     * @param gmApplicationContext
     */
    private void initHandlerMappings(GMApplicationContext gmApplicationContext) {

        String[] beanNames = gmApplicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            //Object controller = null;
            Object proxy = null;
            try {
                //代理对象
                proxy = gmApplicationContext.getBean(beanName);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //使用的是使用代理对象，获取的时候取原始对象
            Object controller = GMAopProxyUtils.getTargetObject(proxy);
            //controller = Utils.createBeanWithReflection(controller.toString());
            Class<?> clazz = controller.getClass();
            if (!clazz.isAnnotationPresent(GMController.class)) {
                continue;
            }

            String baseUrl = "";
            if(clazz.isAnnotationPresent(GMRequestMapping.class)) {
                GMRequestMapping requestMapping = clazz.getAnnotation(GMRequestMapping.class);
                baseUrl = requestMapping.value();
            }
            //扫描所有的public方法
            Method[] methods = clazz.getMethods();
            for (Method m : methods) {
                if (!m.isAnnotationPresent(GMRequestMapping.class)) {
                    continue;
                }
                GMRequestMapping requestMappingTemp = m.getAnnotation(GMRequestMapping.class);
                if (baseUrl.contains("/")) {
                    baseUrl = baseUrl.replace("/", "");
                }
                String regex = "/" + baseUrl + requestMappingTemp.value().replaceAll("/+", "/");
                Pattern pattern = Pattern.compile(regex);
                this.handlerMappings.add(new GMHandlerMapping(pattern, controller, m));
            }
        }
        System.out.println("handlerMappings 初始化完成。。。。。。");
    }

    /**
     * 通过apapter用来匹配method的参数，包括类转换
     * @param gmApplicationContext
     */
    private void initHandlerAdapters(GMApplicationContext gmApplicationContext) {
        //在初始化阶段，我们能做的就是，将这些参数的名字或者类按照一定的顺序保存下来
        //应为后面可用反射调用的时候，传递的形参是一个数组
        //可硬通过记录这些参数的位置index，挨个从数组中填写值，这样的话，就是和参数的顺序无关了
        for (GMHandlerMapping handlerMapping : this.handlerMappings) {
            Map<String, Integer> paramMapping = new HashMap<String, Integer>();
            Annotation[][] pa = handlerMapping.getMethod().getParameterAnnotations();
            for (int i = 0; i < pa.length; i++) {
                for (Annotation a : pa[i]) {
                    if (a instanceof GMRequestParam) {
                        String paramName = ((GMRequestParam) a).value();
                        if (!"".equals(paramName)) {
                            paramMapping.put(paramName, i);
                        }
                    }

                }
            }
            //处理非命名参数
            Class<?>[] paramTypes = handlerMapping.getMethod().getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                Class<?> type = paramTypes[i];
                if (type == HttpServletRequest.class || type == HttpServletResponse.class) {
                    paramMapping.put(type.getName(), i);
                }else {
                    //paramMapping
                    Parameter[] parameters = handlerMapping.getMethod().getParameters();
                    System.out.println(Arrays.toString(parameters));
                    System.out.println(parameters[0]);
                }
            }
            this.handlerAdapters.put(handlerMapping,new GMHandlerAdapter(paramMapping));
        }
        System.out.println("initHandlerAdapters 初始化完成。。。。。。");
    }

    /**
     * 通过viewResolver解析逻辑视图到具体视图实现
     * @param gmApplicationContext
     */
    private void initViewResolvers(GMApplicationContext gmApplicationContext) {
        //https://localhost/first.html
        //解决一个页面名字和模板文件关联的问题
       String templateRoot =  gmApplicationContext.getConfig().getProperty("templateRoot");
        String url =  this.getClass().getClassLoader().getResource(templateRoot).getFile();
        File templateRootFile = new File(url);
        for (File template:templateRootFile.listFiles()) {
            //
            this.viewResolvers.add(new GMViewResolver(template.getName(),template));
        }
        System.out.println("initViewResolvers 初始化完成。。。。。。");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //
      /* String url =req.getRequestURI();
       String context  = req.getContextPath();
       url = url.replace(context,"").replaceAll("/+","");
       Method method  = handlerMapping.get(url);*/
        // handlerMappings
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("<h1>500 Exception</h1><br/>Details:<br/><hr/>" + Arrays.toString(e.getStackTrace()).replaceAll("\\[|\\]","")
                    .replaceAll("\\s","\r\n") +  "<br/><hr/>@GMMVC 2018-2019");
        }
    }


    /**
     *
     * @param req
     * @param resp
     */
    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        GMHandlerMapping handler = getHandler(req);
        if (handler == null) {
            resp.getWriter().write("<h1>404 Not Found</h1> <hr/> @GMMVC 2018-2019");
            return;
        }
        GMHandlerAdapter ha = getHandlerAdapter(handler);
        //得到返回值
        GMModelAndView mv = ha.handle(req, resp, handler);
        //真正的输出
        processDispatchResult(resp, mv);
    }


    /**
     *
     * @param resp
     * @param mv
     */
    private void processDispatchResult(HttpServletResponse resp, GMModelAndView mv) throws IOException {
        //调用viewResolver,解析mv
        if(mv ==null){
            return;
        }
        if(this.viewResolvers.isEmpty()){
            return;
        }

        for (GMViewResolver viewResolver : viewResolvers) {
            //
            if (!mv.getViewName().equals(viewResolver.getViewName())) {
                continue;
            }
            String out = viewResolver.viewResolver(mv);
            if (out != null) {
                resp.getWriter().write(out);
            }
        }
    }


    /**
     *
     * @param handler
     * @return
     */
    private GMHandlerAdapter getHandlerAdapter(GMHandlerMapping handler) {
        if(this.handlerAdapters.isEmpty()){
            return null;
        }
        return this.handlerAdapters.get(handler);
    }


    /**
     *
     * @param req
     * @return
     */
    private GMHandlerMapping getHandler(HttpServletRequest req) {
        if (this.handlerMappings.isEmpty()) {
            return null;
        }
        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();
        //TODO
        //uri = uri.replace(contextPath, "").replaceAll("/+", "");
        for (GMHandlerMapping handler : handlerMappings) {
            Matcher matcher = handler.getUrl().matcher(uri);
            if (!matcher.matches()) {
                continue;
            }
            return handler;
        }
        return null;
    }
}
