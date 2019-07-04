package com.gemini.springboot.web.common.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.springboot.web.common.dto
 * @classname: PageDto
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/6 22:48
 */
public class PageDto<T> implements Serializable {
    private Integer count;
    private Integer pageNum;
    private Integer countEachPage;
    private List<T> pages;

    public PageDto() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getCountEachPage() {
        return countEachPage;
    }

    public void setCountEachPage(Integer countEachPage) {
        this.countEachPage = countEachPage;
    }

    public List<T> getPages() {
        return pages;
    }

    public void setPages(List<T> pages) {
        this.pages = pages;
    }
}
