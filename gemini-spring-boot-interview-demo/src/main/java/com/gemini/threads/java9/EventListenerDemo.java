package com.gemini.threads.java9;

import java.beans.PropertyChangeSupport;

/**
 * @author xiaocuzi
 * @package com.gemini.threads.java9
 * @classname: EventListenerDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/27 17:43
 * @since 1.0.0
 */
public class EventListenerDemo {
    public static void main(String[] args) {
        Person person = new Person();
        PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(person);

        //事件的注册
        propertyChangeSupport.addPropertyChangeListener("name",event->{
            Person bean = (Person) event.getSource();
            System.out.printf("Person %s,Old=%s,new=%s",bean,event.getOldValue(),event.getNewValue());
        });

        //触发事件

        propertyChangeSupport.firePropertyChange("name",null,"TOM");
    }

    private static class Person{
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
