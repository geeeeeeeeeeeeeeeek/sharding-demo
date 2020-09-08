/*
 * All rights Reserved, Designed By Nemo
 * 2020/9/3 13:40
 */
package com.nemo.sharding.service;

import com.nemo.sharding.model.PageResultBean;
import com.nemo.sharding.model.SysUser;
import com.nemo.sharding.model.BaseQueryBean;

/**
 * 用户相关业务
 * @author: Nemo
 * @date: 2020/9/3.
 */
public interface UserService {

    /**
     * 新增
     * @param sysUser
     */
    void insert(SysUser sysUser);

    /**
     * 更新
     * @param sysUser
     */
    void update(SysUser sysUser);

    /**
     * 根据ID删除
     * @param id
     */
    void deleteByPrimaryKey(Integer id);

    /**
     * 根据ID获取
     * @param id
     * @return
     */
    SysUser selectByPrimaryKey(Integer id);

    /**
     * 分页获取
     * @param queryBean
     * @return
     */
    PageResultBean<SysUser> page(BaseQueryBean queryBean);

    /**
     * 批量新增测试
     * @param size
     * @return
     */
    int batchInsert(Integer size);
}
