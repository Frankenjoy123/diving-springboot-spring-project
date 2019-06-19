package com.joey.analyze.event.log.client.bean;

/**
 * Created by xiaowu.zhou on 2019/6/18.
 */
public class EventConfiguration {

    private String appCode;

    private boolean debug = false;


    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }
}
