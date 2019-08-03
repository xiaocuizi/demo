package com.gemini.interiew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiaocuzi
 * @package com.gemini.interiew
 * @classname: ListGroupDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/10 8:46
 * @since 1.0.0
 */
public class ListGroupDemo {

    static class Product {
        private long id; // 商品Id
        private String name;// 商品名称
        private byte type;// 商品类型

        public Product(long id, String name, byte type) {
            this.id = id;
            this.name = name;
            this.type = type;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public byte getType() {
            return type;
        }

        public void setType(byte type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", type=" + type +
                    '}';
        }
    }

    public static void main(String[] args) {
        Product product1 = new Product(1001L, "Java", (byte) 10);
        Product product2 = new Product(1002L, "Python", (byte) 20);
        Product product3 = new Product(1002L, "Python", (byte) 20);
        Product product4 = new Product(1003L, "Netty", (byte) 30);
        Product product5 = new Product(1003L, "Netty", (byte) 30);
        Product product6 = new Product(1003L, "Netty", (byte) 30);
        Product product7 = new Product(1002L, "Python", (byte) 20);
        Product product8 = new Product(1004L, "Tomcat", (byte) 40);
        List<Product> products = Arrays.asList(new Product[]{product1, product2, product3, product4, product5, product6, product7, product8});


        // 进行分组
        Map<Long, List<Product>> map = new ConcurrentHashMap<>();
        for (int i = 0; i < products.size(); i++) {
            List<Product> productsTemp = map.get(products.get(i).getId());
            if (productsTemp == null) {
                productsTemp = new ArrayList<>();
                productsTemp.add(products.get(i));
                map.put(products.get(i).getId(), productsTemp);
            } else {
                productsTemp.add(products.get(i));
            }
        }
        for (Long id : map.keySet()) {
            System.out.println(map.get(id));
        }
    }
}
