package com.pzg.code.timeproject.service.impl;

import com.pzg.code.timeproject.mapper.UserMapper;
import com.pzg.code.timeproject.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName :  TimeServiceImpl
 * @Author : PZG
 * @Date : 2019-07-03   14:22
 * @Description :
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
@EnableTransactionManagement
public class TimeServiceImpl implements TimeService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer useCount() {
        return userMapper.useCount();
    }
}
