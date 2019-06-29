package com.joey.analyze.event.log.client.threadlocal;

import java.io.Serializable;

/**
 * Created by xiaowu.zhou on 2019/6/21.
 */
public class MyEvent implements Serializable{

    private String methodName;

    private String param;

    private String paramValue;


    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    private String actionName;

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
