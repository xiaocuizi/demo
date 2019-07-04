package com.gemini.web.ormframwork.common;

import java.util.List;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.web.ormframwork.common
 * @classname: Page
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/24 21:24
 */
public class Page<T> {
    private static int DEFAULT_PAGE_SIZE = 20;
    private int pageSize = DEFAULT_PAGE_SIZE;
    private long start;

    private List<T> rows;

    private long total;
}
