package com.gemini.optional;

import java.util.Optional;

/**
 * @author xiaocuzi
 * @package com.gemini.optional
 * @classname: Optional
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/12/7 17:57
 *
 * https://www.jianshu.com/p/82ed16613072
 * @since 1.0.0
 */
public class Optional2 {
    public static void main(String[] args) {

       /* Integer value1 = null;
        Integer value2 = new Integer(10);

        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(value1);

        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(value2);
        User user = getUserById(1);
        if (user != null) {
            String username = user.getName();
            System.out.println("Username is: " + username); // 使用 username
        }

        Optional<User> user2 = Optional.ofNullable(getUserById(1));
        user2.ifPresent(u -> System.out.println("Username2 is: " + u.getName()));


        User user3 = Optional
                .ofNullable(getUserById(1))
                .orElse(new User(0, "Unknown"));

        System.out.println("Username3 is: " + user3.getName());*/

    }

    private static User getUserById(Integer id){
      //  return new User(1,"xiaocui") ;
        return null;
    }
}
