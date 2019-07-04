package com.gemini.web.springv2.webmvc.servlet;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.web.springv2.webmvc.servlet
 * @classname: GMViewResolver
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/21 15:57
 */
public class GMViewResolver {

    private String viewName;
    private File templateFile;
    private static final  String REG_EX_BEFORE = "#\\{";
    private static final  String REG_EX = "#\\{\\w*\\}";
    private static final  String REG_EX_AFTER = "}";

    public GMViewResolver(String viewName, File templateFile) {
        this.viewName = viewName;
        this.templateFile = templateFile;
    }

    public GMViewResolver(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }


    /**
     *
     * @param modelAndView
     * @return
     */
    public String viewResolver(GMModelAndView modelAndView) throws IOException {
        StringBuffer sb = new StringBuffer();
        RandomAccessFile ra = new RandomAccessFile(this.templateFile, "r");
        String line = "";
        String temp = "";
        while (null != (line = ra.readLine())) {
            //么有匹配上，是字符集原因？
            line = new String(line.getBytes("ISO-8859-1"), "utf-8");
            Matcher matcher = matcher(line);
            while (matcher.find()) {
                System.out.println("============matcher.find() start================");
                /*for (int i = 0; i < matcher.groupCount(); i++) {*/
                    System.out.println("============================");
                    //String paramName = matcher.group(i);
                    String paramName = matcher.group();
                    temp = paramName.replaceAll(REG_EX_BEFORE,"").replaceAll(REG_EX_AFTER,"");
                    Object paramValue = modelAndView.getModel().get(temp);
                    System.out.println("paramName="+paramName+",paramValue="+paramValue+",count="+matcher.groupCount());
                    System.out.println("============================");
                    if (paramValue == null) {
                        continue;
                    }
                    line = line.replaceAll(REG_EX_BEFORE + temp + REG_EX_AFTER, paramValue.toString());
                    System.out.println("line="+line);
                    System.out.println("============================");
                    //line = new String(line.getBytes("utf-8"), "ISO-8859-1");
                /*}*/
                System.out.println("============matcher.find() end================");
            }
            line = new String(line.getBytes("utf-8"), "ISO-8859-1");
            sb.append(line);
        }
        return sb.toString();
    }

    private static Matcher matcher(String string){
        Pattern pattern = Pattern.compile(REG_EX,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
        return matcher;
    }

    /*public static void main(String[] args) {
         String REG_EX = "#\\{\\w*\\}";
        String str = "<h1>大家好，我是#{name}</h1><h1>大家好，我学的课程是#{spring}</h1>";
        try {
            str = new String(str.getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Pattern pattern = Pattern.compile(REG_EX);
        Matcher matcher = pattern.matcher(str);
        System.out.println("========================>");
        System.out.println(matcher.matches());
        while (matcher.find()){
            System.out.println("------------"+matcher.group());
        }
    }*/
}
