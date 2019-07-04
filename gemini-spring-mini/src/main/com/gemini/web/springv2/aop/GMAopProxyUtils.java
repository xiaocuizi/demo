package com.gemini.web.springv2.aop;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.web.springv2.aop
 * @classname: GMAopProxyUtils
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/23 15:09
 */
public class GMAopProxyUtils {


    /**
     * 通过代理类获取最原始的类
     * @param proxy
     * @return
     */
    public static Object getTargetObject(Object proxy){
      if(!isAopProxy(proxy)){
          return proxy;
      }else {
          try {
              return getProxyTargetObject(proxy);
          } catch (NoSuchFieldException e) {
              e.printStackTrace();
          } catch (IllegalAccessException e) {
              e.printStackTrace();
          }
      }
      return null;
    }

    private static boolean isAopProxy(Object proxy){

        return Proxy.isProxyClass(proxy.getClass());

    }


    /**
     *
     * @param proxy
     * @return
     */
    private static Object getProxyTargetObject(Object proxy) throws NoSuchFieldException, IllegalAccessException {
        Field h = proxy.getClass().getSuperclass().getDeclaredField("h");
        h.setAccessible(true);
        GMAopProxy proxy1 = (GMAopProxy) h.get(proxy);
        Field target = proxy1.getClass().getDeclaredField("target");
        target.setAccessible(true);
        return target.get(proxy1);
    }
}
