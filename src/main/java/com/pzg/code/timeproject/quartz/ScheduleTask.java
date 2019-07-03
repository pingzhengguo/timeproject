package com.pzg.code.timeproject.quartz;

import com.pzg.code.timeproject.service.TimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@Component
@EnableScheduling
public class ScheduleTask {
    public static final Logger LOGGER = LoggerFactory.getLogger(ScheduleTask.class);
    @Autowired
    private TimeService timeService;

    public void schedule() {
        LOGGER.info("=====用户统计=====");
        try {
            Integer integer = timeService.useCount();
            System.out.println("时间为" + dateFormat().format(new Date()) + " 用户数量为" + integer);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("用户统计异常");
        }
    }


    private SimpleDateFormat dateFormat() {
        return new SimpleDateFormat("HH:mm:ss");
    }
}