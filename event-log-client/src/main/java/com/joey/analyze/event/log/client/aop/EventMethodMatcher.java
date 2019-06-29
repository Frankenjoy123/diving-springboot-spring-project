package com.joey.analyze.event.log.client.aop;

import com.joey.analyze.event.log.client.annotation.EventAction;
import org.springframework.aop.support.StaticMethodMatcher;
import org.springframework.util.ClassUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by xiaowu.zhou on 2019/6/20.
 */
public class EventMethodMatcher extends StaticMethodMatcher {


    @Override
    public boolean matches(Method method, Class<?> targetClass) {


        Class<?> realClass =  ClassUtils.getUserClass(targetClass);
        Method realMethod = ClassUtils.getMostSpecificMethod(method,realClass);

        Annotation[] annotations =  realMethod.getAnnotations();
        if (annotations != null && annotations.length >0 ){
            for (Annotation annotation : annotations){

                if (annotation.annotationType() == EventAction.class){
                    return true;
                }

            }
        }

        return false;
    }
}
