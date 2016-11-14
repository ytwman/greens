/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/11/14 上午2:24
 * Description: 
 */
package com.ytwman.greens.commons.core.web;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Pagination {
    private int page;
    private int totalPage;
    private int total;
    private int rows;
    private int offset;

    private static final int defaultPageSize = 20;

    public Pagination() {
        this(0);
    }

    public Pagination(int total) {
        this(defaultPageSize, total);
    }

    public Pagination(int rows, int total) {
        this.rows = rows;
        this.total = total;
        this.totalPage = (total - 1) % rows + 1;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getOffset() {
        return (page <= 0 ? 0 : page - 1) * rows;
    }

    public int getLimit() {
        return this.getRows();
    }
}
