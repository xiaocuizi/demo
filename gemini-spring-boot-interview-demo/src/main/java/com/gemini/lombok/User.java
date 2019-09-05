package com.gemini.lombok;

import lombok.Builder;
import lombok.Data;

/**
 * @author xiaocuzi
 * @package com.gemini.lombok
 * @classname: User
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/9/4 21:48
 * @since 1.0.0
 */
@Data
@Builder(toBuilder = true)
public class User {

    private String name;
    private Integer id;
    private Integer sex;

    public static void main(String[] args) {
        User user = new User.UserBuilder().id(1).name("王大锤").sex(1).build();
        System.out.println(user);
    }
}
