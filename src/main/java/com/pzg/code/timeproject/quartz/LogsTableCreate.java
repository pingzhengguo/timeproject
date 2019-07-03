package com.pzg.code.timeproject.quartz;

import com.pzg.code.timeproject.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @ClassName :  LogsTableCreate
 * @Author : PZG
 * @Date : 2018-11-08   9:18
 * @Description :
 */
@Configuration
@Component
@EnableScheduling
public class LogsTableCreate {
    public static final Logger LOGGER = LoggerFactory.getLogger(LogsTableCreate.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void logsTable() {
        LOGGER.info("=====表创建开始=====");
        try {
            LogUtils.createLogTable(jdbcTemplate);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("日志表创建异常");
        }
    }


}
