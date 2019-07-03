package com.pzg.code.timeproject.utils;


import com.pzg.code.timeproject.service.TimeService;

import java.util.List;
import java.util.TimerTask;

/**
 * @ClassName :  RemindTask
 * @Author : PZG
 * @Date : 2019-01-11   14:12
 * @Description : 计时器任务
 */
public class RemindTask extends TimerTask {
    private TimeService timeService;
    private Integer tab;


    public RemindTask(TimeService timeService, Integer tab) {
        this.timeService = timeService;
        this.tab = tab;
    }

    @Override
    public void run() {
        ResultInfo tasksByUser = timeService.doTaskTest(tab);
    }


}