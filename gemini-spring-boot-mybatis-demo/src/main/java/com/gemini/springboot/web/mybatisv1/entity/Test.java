package com.gemini.springboot.web.mybatisv1.entity;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gupaoedu.mybatisv1.gp.entity
 * @classname: Test
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/8 17:52
 */
public class Test {
    private int id;
    private int nums;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", nums=" + nums +
                ", name='" + name + '\'' +
                '}';
    }
}
