package com.gemini.user.domain;

import java.io.Serializable;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.user.domain
 * @classname: User
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/23 18:01
 */
public class User implements Serializable {

    private static final long serialVersionUID = -8430046134123112554L;
    private long id;
    private String name;

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
}
