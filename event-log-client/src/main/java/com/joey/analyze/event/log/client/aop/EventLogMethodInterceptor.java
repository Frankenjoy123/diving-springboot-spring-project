package com.joey.analyze.event.log.client.aop;

import com.alibaba.fastjson.JSON;
import com.joey.analyze.event.log.client.threadlocal.EventLogContext;
import com.joey.analyze.event.log.client.threadlocal.ItemContext;
import com.joey.analyze.event.log.client.threadlocal.MyEvent;
import com.joey.analyze.event.log.client.threadlocal.MyEventAnnotationMethod;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Method;

/**
 * Created by xiaowu.zhou on 2019/6/21.
 */
public class EventLogMethodInterceptor implements MethodInterceptor , ApplicationContextAware{

    private ApplicationContext context;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {


        String methodName = invocation.getMethod().getName();
        System.out.println("method run : " + methodName);

        MyEvent myEvent = parseEvent(invocation);
        EventLogContext.setItemContext(new ItemContext(myEvent));

        try {
            return invocation.proceed();
        } catch (Throwable throwable) {
            throw throwable;

        } finally {

            //处理事件日志
            processEvent();

            //清理上下文
            clearContext();
        }

    }

    private void clearContext() {
        EventLogContext.removeItemContext();
    }

    private void processEvent() {
        MyEvent myEvent = EventLogContext.getItemContext().getMyEvent();
        System.out.println(JSON.toJSONString(myEvent));
    }

    private MyEvent parseEvent(MethodInvocation invocation) {

        Object obj = invocation.getThis();
        Object[] args =  invocation.getArguments();

        MyEvent myEvent = new MyEvent();

        Method method = invocation.getMethod();
        MyEventAnnotationMethod myEventAnnotationMethod = new MyEventAnnotationMethod(method);
        myEvent.setActionName(myEventAnnotationMethod.getEventAction().value());

        String param = myEventAnnotationMethod.getEventParams()[0].value();
        String paramValue = (String) args[0];
        myEvent.setParam(param);
        myEvent.setParamValue(paramValue);


        return myEvent;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
