package com.gemini.cache;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NotNull(message = "参数不能为空")
public class User implements Serializable {

    @NotNull(message = "userId不能为空")
    private Integer userId;


    /**
     * {@link <a href="https://www.jianshu.com/p/2e6fd6d625cd"/>}
     */
    @NotNull(message = "姓名不能为空")
    @Size(min=2, max=30,message = "请检查名字的长度是否有问题")
    private String userName;

    private transient String userPassword;

    public User(int userId, String userName, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }
}

