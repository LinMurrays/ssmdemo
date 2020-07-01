package com.jt.common.vo;

/**
 * 借助此对象封装服务端控制层的返回结果
 *
 * @author Administrator
 */
public class JsonResult {
    //状态信息
    private int state = 1;//1 OK,0 错误
    //状态吗对应的具体信息
    private String message;
    //具体数据：例如查询的结果
    private Object data;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JsonResult(String message) {
        super();
        this.message = message;
    }

    public JsonResult(int state) {
        super();
        this.state = state;
    }

    public JsonResult(Object data) {
        super();
        this.data = data;
    }

    public JsonResult(Throwable e) {
        this.state = 0;
        this.message = e.getMessage();
    }

}




















