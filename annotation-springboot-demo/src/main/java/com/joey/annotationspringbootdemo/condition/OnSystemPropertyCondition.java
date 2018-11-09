package com.joey.annotationspringbootdemo.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/3.
 */
public class OnSystemPropertyCondition implements Condition{

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String,Object>  attributes=
                metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());

        String systemPropertyKey = (String) attributes.get("name");

        String systemPropertyValue = (String) attributes.get("value");

        String sysValue = System.getProperty(systemPropertyKey);


        if (systemPropertyValue.equals(sysValue)){
            return true;
        }

        return false;
    }
}
