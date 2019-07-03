package com.pzg.code.timeproject.quartz;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;


@Configuration
public class QuartzConfiguration {
    @Bean(name = "firstJobDetail")
    public MethodInvokingJobDetailFactoryBean firstJobDetail(ScheduleTask task) {
        // ScheduleTask为需要执行的任务
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        // 是否并发执行
        jobDetail.setConcurrent(true);
        // 为需要执行的实体类对应的对象
        jobDetail.setTargetObject(task);
        // 设置任务方法
        jobDetail.setTargetMethod("schedule");
        return jobDetail;
    }

    @Bean(name = "firstTrigger")
    public SimpleTriggerFactoryBean firstTrigger(JobDetail firstJobDetail) {
        SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
        trigger.setJobDetail(firstJobDetail);
        // 设置任务启动延迟
        trigger.setStartDelay(0);
        // 每1*60*1秒执行一次(1分钟)
        trigger.setRepeatInterval(1000 * 60 * 1);
        return trigger;
    }

    @Bean(name = "secondJobDetail")
    public MethodInvokingJobDetailFactoryBean fourJobDetail(LogsTableCreate fourJob) {
        // ScheduleTask为需要执行的任务
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        // 是否并发执行
        jobDetail.setConcurrent(true);
        // 为需要执行的实体类对应的对象
        jobDetail.setTargetObject(fourJob);
        // 设置任务方法
        jobDetail.setTargetMethod("logsTable");
        return jobDetail;
    }

    @Bean(name = "secondTrigger")
    public CronTriggerFactoryBean fourTrigger(JobDetail secondJobDetail) {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(secondJobDetail);
        // cron表达式 每月1日0时0分触发
        trigger.setCronExpression("0 0 0 1 * ?");
        // cron表达式 每1分钟
//        trigger.setCronExpression("0 0/1 * * * ? *");
        return trigger;
    }

    /**
     * 配置Scheduler
     *
     * @param firstTrigger
     * @param secondTrigger
     * @return
     */
    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactory(Trigger firstTrigger, Trigger secondTrigger) {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        // 延时启动，应用启动3秒后
        bean.setStartupDelay(3);
        // 注册触发器
        bean.setTriggers(firstTrigger, secondTrigger);
        return bean;
    }
}
