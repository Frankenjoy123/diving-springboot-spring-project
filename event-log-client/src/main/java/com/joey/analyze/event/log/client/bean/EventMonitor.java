package com.joey.analyze.event.log.client.bean;

import java.util.List;

/**
 * Created by xiaowu.zhou on 2019/6/20.
 */
public class EventMonitor {

    private String monitorName;

    private List<String> monitorItemList;

    public String getMonitorName() {
        return monitorName;
    }

    public void setMonitorName(String monitorName) {
        this.monitorName = monitorName;
    }

    public List<String> getMonitorItemList() {
        return monitorItemList;
    }

    public void setMonitorItemList(List<String> monitorItemList) {
        this.monitorItemList = monitorItemList;
    }
}
