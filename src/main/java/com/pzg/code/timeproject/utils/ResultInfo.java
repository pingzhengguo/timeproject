package com.pzg.code.timeproject.utils;

public class ResultInfo {
    //返回信息代码 是否成功的标识（1 成功  0 失败）
    private Integer code;
    //返回接口调用消息提示，成功返回success，失败返回对应的失败信息
    private String msg;
    //返回的执行结果集
    private Object result;

    public static ResultInfo success() {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(1);
        resultInfo.setMsg("success");
        return resultInfo;
    }

    public static ResultInfo failure(String msg) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(0);
        resultInfo.setMsg(msg);
        return resultInfo;
    }

    public static ResultInfo failure() {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(0);
        resultInfo.setMsg("failure");
        return resultInfo;
    }

    public ResultInfo build(Object result) {
        if (null != result) {
            this.result = result;
        } else {
            this.result = null;
        }
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {

        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}
