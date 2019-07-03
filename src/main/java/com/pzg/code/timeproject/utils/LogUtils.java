package com.pzg.code.timeproject.utils;

import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @ClassName :  TimeUtils
 * @Author : PZG
 * @Date : 2018-12-17   15:20
 * @Description :
 */
public class LogUtils {

    /**
     * Description : 创建日志分表
     *
     * @param jdbcTemplate
     * @return : void
     * @date : 2019-01-06   14:06
     * @author : PZG
     */
    public static void createLogTable(JdbcTemplate jdbcTemplate) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmm");
            String date = formatter.format(new Date());
            String tbName = "user" + "_" + date;
            String sql = "CREATE table if not EXISTS " + tbName + " like " + "user";
            jdbcTemplate.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
