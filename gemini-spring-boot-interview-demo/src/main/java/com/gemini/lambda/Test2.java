package com.gemini.lambda;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xiaocuzi
 * @package com.gemini.lambda
 * @classname: Test2
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/7/28 11:28
 * @since 1.0.0
 */
public class Test2 {


    public static void main(String[] args) {
       // System.out.println(getPriceByTypeId(1));
    }

    private static Map<Integer, Coin> toCoinMap() {
        ArrayList<Coin> coinList = Lists.newArrayList();
        coinList.add(new Coin(1, 10, "玛瑙", 1));
        coinList.add(new Coin(2, 20, "玄铁", 1));
        coinList.add(new Coin(3, 30, "天命", 2));
        // 这个通过type获取符合条件的类型集合
        return coinList.stream().collect(Collectors.toMap(Coin::getId, coin -> coin));
    }

    public static class Coin{
        /** id */
        private int id;
        /** 价格 */
        private int price;
        /** 名称*/
        private String name;

        private int type;

        public Coin(int id, int price, String name, int type) {
            this.id = id;
            this.price = price;
            this.name = name;
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
