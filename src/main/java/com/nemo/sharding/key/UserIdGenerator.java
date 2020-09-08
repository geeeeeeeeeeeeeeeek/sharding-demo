/*
 * All rights Reserved, Designed By Nemo
 * 2020/9/8 15:16
 */
package com.nemo.sharding.key;

/**
 * 用户表自增ID生成器
 * @author: Nemo
 * @date: 2020/9/8.
 */
public final class UserIdGenerator extends BaseKeyGenerator {

    /**
     * 表名
     * @return
     */
    @Override
    protected final String tableName() {
        return "sys_user";
    }
}
