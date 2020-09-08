/*
 * All rights Reserved, Designed By Nemo
 * 2020/9/8 10:22
 */
package com.nemo.sharding.key;

import com.google.common.collect.Maps;
import io.shardingjdbc.core.keygen.KeyGenerator;

import java.util.Map;

/**
 * 自增ID生成器
 * @author: Nemo
 * @date: 2020/9/8.
 */
public abstract class BaseKeyGenerator implements KeyGenerator {

    /**
     * DEMO级别，用来临时存储当前最新ID序列值
     */
    private static final Map<String,Long> MAP = Maps.newHashMap();

    @Override
    public final synchronized Number generateKey() {
        //TODO 某表的主键策略，DEMO级别，待实现，考虑基于redis或者db，用以生成自增ID
        return getId(tableName());
    }

    /**
     * 基于内存的实现，每次重启自增ID即重置
     * @param tableName
     * @return
     */
    private Long getId(String tableName){
        Long number = BaseKeyGenerator.MAP.get(tableName);
        if(number == null){
            number = 0L;
        }

        number ++;
        BaseKeyGenerator.MAP.put(tableName,number);

        return number;
    }

    /**
     * 需生成ID的表名
     * @return
     */
    protected abstract String tableName();

}
