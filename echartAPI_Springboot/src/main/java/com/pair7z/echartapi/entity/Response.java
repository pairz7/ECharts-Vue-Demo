package com.pair7z.echartapi.entity;

public class Response {
    private String msg;
    private int code;
    Object result;

    public Response(String msg, int code, Object result) {
        this.msg = msg;
        this.code = code;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Response{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", result=" + result +
                '}';
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Response(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }
}
