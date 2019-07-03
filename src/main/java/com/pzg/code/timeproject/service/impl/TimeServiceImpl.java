package com.pzg.code.timeproject.service.impl;

import com.pzg.code.timeproject.mapper.UserMapper;
import com.pzg.code.timeproject.service.TimeService;
import com.pzg.code.timeproject.utils.RemindTask;
import com.pzg.code.timeproject.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    private TimeService timeService;


    @Override
    public Integer useCount() {
        return userMapper.useCount();
    }


    /**
     * Description : 设置任务执行内容(测试)
     *
     * @param tab
     * @return : com.hiynn.base.commons.base.ResultInfo
     * @date : 2019-01-11   15:33
     * @author : PZG
     */
    @Override
    public ResultInfo doTaskTest(Integer tab) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s = sdf.format(new Date());
            if (tab == 1) {
                System.out.println(s + "   发起3秒后 第一次执行  调接口");
            } else if (tab == 2) {
                System.out.println(s + "   发起8秒后 第二次执行  调接口");
                return ResultInfo.success();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultInfo.failure(e.toString());
        }
        return null;
    }

    /**
     * Description : 设置任务的触发时间(测试)
     *
     * @return : com.hiynn.base.commons.base.ResultInfo
     * @throws Exception
     * @date : 2019-01-11   15:32
     * @author : PZG
     */
    @Override
    public ResultInfo doByTimeTest() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s = sdf.format(new Date());
            System.out.println(s + "   发起");
            Timer timer = new Timer();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.SECOND, 3);
            Date time1 = calendar.getTime();
            //在设置时间time1触发相关任务
            timer.schedule(new RemindTask(timeService, 1), time1);
            calendar = Calendar.getInstance();
            calendar.setTime(time1);
            calendar.add(Calendar.SECOND, 5);
            Date halfTime2 = calendar.getTime();
            timer.schedule(new RemindTask(timeService, 2), halfTime2);
            return ResultInfo.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultInfo.failure(e.toString());
        }
    }
}
