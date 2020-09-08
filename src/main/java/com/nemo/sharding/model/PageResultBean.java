/*
 * All rights Reserved, Designed By Nemo
 * 2020/9/3 14:03
 */
package com.nemo.sharding.model;

import java.util.List;

/**
 * 分页响应Bean
 * @author: Nemo
 * @date: 2020/9/3.
 */
public class PageResultBean<T> extends BaseQueryBean {

    private Long count;

    private List<T> data;

    public PageResultBean(BaseQueryBean queryBean,Long count, List<T> data) {
        this.count = count;
        this.data = data;
        super.setPageNo(queryBean.getPageNo());
        super.setPageSize(queryBean.getPageSize());
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
