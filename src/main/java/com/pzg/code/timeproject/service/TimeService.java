package com.pzg.code.timeproject.service;

import com.pzg.code.timeproject.utils.ResultInfo;

/**
 * @ClassName :  TimeService
 * @Author : PZG
 * @Date : 2019-07-03   14:22
 * @Description :
 */
public interface TimeService {

    Integer useCount();


    /**
     * Description : 设置任务执行内容(测试)
     *
     * @param tab
     * @return : com.hiynn.base.commons.base.ResultInfo
     * @author : PZG
     */
    ResultInfo doTaskTest(Integer tab);

    /**
     * Description : 设置任务的触发时间(测试)
     *
     * @return : com.hiynn.base.commons.base.ResultInfo
     * @author : PZG
     */
    ResultInfo doByTimeTest();
}
