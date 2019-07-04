package com.gemini.springboot.web.common.page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangzhenjia
 * @Description: 分页信息类
 * @date 2014年8月26日
 * @time 下午4:27:14
 */
public class Paging {

    private static final Integer MAX_PER_PAGE = 300;

    private Integer page; // 当前页
    private Integer perPage; // 每页个数
    private Integer skipIndex; // 跳过个数
    private List<String> sortFieldNames = new ArrayList<String>(); // 排序字段
    private List<String> sortOrders = new ArrayList<String>(); // 排序方向

    private Long totalCount; // 总数

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage == null ? 0 : Math.min(perPage, MAX_PER_PAGE);
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getSkipIndex() {
        return skipIndex;
    }

    public void setSkipIndex(Integer skipIndex) {
        this.skipIndex = skipIndex;
    }

    public Long getTotalCount() {
        return totalCount == null ? 0 : totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public int getStartIndex() {
        return skipIndex == null ? 0 : skipIndex;
    }

    public List<String> getSortFieldNames() {
        return sortFieldNames;
    }

    public void setSortFieldNames(List<String> sortFieldNames) {
        this.sortFieldNames = sortFieldNames;
    }

    public List<String> getSortOrders() {
        return sortOrders;
    }

    public void setSortOrders(List<String> sortOrders) {
        this.sortOrders = sortOrders;
    }

    public Paging() {

    }

    public Paging(Integer perPage, Integer skipIndex) {
        this.perPage = perPage;
        this.skipIndex = skipIndex;
    }
}
