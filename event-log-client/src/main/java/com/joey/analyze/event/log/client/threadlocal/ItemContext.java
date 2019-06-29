package com.joey.analyze.event.log.client.threadlocal;

/**
 * Created by xiaowu.zhou on 2019/6/21.
 */
public class ItemContext {

    private MyEvent myEvent;

    public ItemContext(MyEvent myEvent) {
        this.myEvent = myEvent;
    }

    public MyEvent getMyEvent() {
        return myEvent;
    }

    public void setMyEvent(MyEvent myEvent) {
        this.myEvent = myEvent;
    }
}
