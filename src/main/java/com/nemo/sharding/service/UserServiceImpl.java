/*
 * All rights Reserved, Designed By Nemo
 * 2020/9/3 13:41
 */
package com.nemo.sharding.service;

import com.nemo.sharding.dao.UserDao;
import com.nemo.sharding.model.BaseQueryBean;
import com.nemo.sharding.model.PageResultBean;
import com.nemo.sharding.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.*;

/**
 * 用户相关业务 实现
 * @author: Nemo
 * @date: 2020/9/3.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 新增
     * @param sysUser
     */
    @Override
    public void insert(SysUser sysUser) {
        userDao.insert(sysUser);
    }

    /**
     * 更新
     * @param sysUser
     */
    @Override
    public void update(SysUser sysUser) {
        userDao.update(sysUser);
    }

    /**
     * 根据ID删除
     * @param id
     */
    @Override
    public void deleteByPrimaryKey(Integer id) {
        userDao.deleteByPrimaryKey(id);
    }

    /**
     * 根据ID获取
     * @param id
     * @return
     */
    @Override
    public SysUser selectByPrimaryKey(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    /**
     * 分页获取
     * @param queryBean
     * @return
     */
    @Override
    public PageResultBean<SysUser> page(BaseQueryBean queryBean) {

        long count = userDao.countByExample(queryBean);
        List<SysUser> sysUsers = userDao.selectByExample(queryBean);

        return new PageResultBean<>(queryBean,count,sysUsers);
    }

    /**
     * 批量新增测试
     * @param size
     * @return
     */
    @Override
    public int batchInsert(Integer size) {
        if(size == null || size <= 0){
            return 0;
        }
        // 创建数组型缓冲等待队列
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10,
                30,
                50,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(30),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for(int i=0;i<size;i++){
            final int idx = i;
            threadPoolExecutor.submit(()->{
                SysUser sysUser = new SysUser();
                sysUser.setName("Test"+idx);
                userDao.insert(sysUser);
            });
        }
        return size;
    }
}
