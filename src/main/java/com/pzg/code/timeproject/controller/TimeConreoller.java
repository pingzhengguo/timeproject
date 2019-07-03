package com.pzg.code.timeproject.controller;

import com.pzg.code.timeproject.service.TimeService;
import com.pzg.code.timeproject.utils.ResultInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName :  TimeConreoller
 * @Author : PZG
 * @Date : 2019-07-03   14:20
 * @Description :
 */
@Api(tags = {"OverTimeConreoller"})
@RestController
@RequestMapping("/overTimeConreoller")
public class TimeConreoller {
    @Autowired
    private TimeService timeService;

    @ApiOperation(value = "doByTimeTest", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/doByTimeTest", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo doByTimeTest() {
        ResultInfo tasksByUser = null;
        try {
            Integer integer = timeService.useCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasksByUser;
    }
}
