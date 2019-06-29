package com.joey.analyze.event.log.client.threadlocal;

import com.google.common.collect.Lists;
import com.joey.analyze.event.log.client.annotation.EventAction;
import com.joey.analyze.event.log.client.annotation.EventParam;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

/**
 * Created by xiaowu.zhou on 2019/6/21.
 */
public class MyEventAnnotationMethod {

    private Method method;

    private EventAction eventAction;

    private EventParam[] eventParams;

    public MyEventAnnotationMethod(Method method) {
        this.method = method;

        this.eventAction = method.getAnnotation(EventAction.class);

        Parameter[] parameters = method.getParameters();

        List<EventParam> eventParamList = Lists.newArrayList();

        if (ArrayUtils.isNotEmpty(parameters)) {

            for (int i=0 ; i<parameters.length ; i++){

                EventParam eventParam = parameters[i].getAnnotation(EventParam.class);
                eventParamList.add(eventParam);
            }
        }

        this.eventParams = eventParamList.toArray(new EventParam[eventParamList.size()]);

    }


    public Method getMethod() {
        return method;
    }

    public EventAction getEventAction() {
        return eventAction;
    }

    public EventParam[] getEventParams() {
        return eventParams;
    }
}
