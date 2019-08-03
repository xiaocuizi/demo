package com.gemini.joinstr;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

/**
 * @author xiaocuzi
 * @package com.gemini.joinstr
 * @classname: JoinStr
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/7/28 10:41
 * @since 1.0.0
 */
public class JoinStr {

    public static void main(String[] args) {
        ArrayList<Integer> integerList = Lists.newArrayList(1, 9, 4, 5, 3, 6, 7, 8);
        StringBuffer stringBuffer = new StringBuffer();
        for (Integer e : integerList) {
            stringBuffer.append(e).append(",");
        }
        String str = stringBuffer.toString();
        str = str.substring(0, str.length() - 1);
        System.out.printf("str=%s", str);
        /*String result = StringUtils.join(integers, ",");
        System.out.println("result=" + result);*/
        joinStringUtils();
    }
  /*  public static void join(){
        ArrayList<Integer> integerList = Lists.newArrayList(1, 9, 4, 5, 3, 6, 7, 8);
        StringBuffer stringBuffer = new StringBuffer();
        for (Integer e : integerList) {
            stringBuffer.append(e).append(",");
        }
        String str = stringBuffer.toString();
        str = str.substring(0, str.length() - 1);
        System.out.printf("str=%s", str);
    }*/

    public static void joinStringUtils() {
        ArrayList<Integer> integerList = Lists.newArrayList(1, 9, 4, 5, 3, 6, 7, 8);
        String result = StringUtils.join(integerList, ",");
        System.out.printf("result=%s", result);
    }
}
