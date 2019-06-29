package com.joey.analyze.event.log.client.threadlocal;

/**
 * Created by xiaowu.zhou on 2019/6/21.
 */
public class EventLogContext {

    private static final ThreadLocal<ItemContext> localItemContext = ThreadLocal.withInitial(() -> new ItemContext(new MyEvent()));



    public static ItemContext getItemContext(){
        return localItemContext.get();
    }

    public static void setItemContext(ItemContext itemContext){
        localItemContext.set(itemContext);
    }

    //清空当前线程的上下文
    public static void removeItemContext(){
        localItemContext.remove();
    }

//    public static

}
