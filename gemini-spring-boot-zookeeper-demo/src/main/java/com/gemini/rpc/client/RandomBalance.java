package com.gemini.rpc.client;

import java.util.List;
import java.util.Random;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.rpc.client
 * @classname: RandomBalance
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/22 15:57
 */
public class RandomBalance extends AbstractBalance {
    @Override
    public String doSelete(List<String> stringList) {
        if(stringList ==null || stringList.size() ==-0){
            return "";
        }
        int len = stringList.size();
        if (len==1){
            return stringList.get(0);
        }

        Random random = new Random();
        int nextInt = random.nextInt(len);
        return stringList.get(nextInt);
    }
}


