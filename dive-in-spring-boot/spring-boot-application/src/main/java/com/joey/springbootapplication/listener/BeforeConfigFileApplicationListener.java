package com.joey.springbootapplication.listener;

import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;

/**
 * before {@link ConfigFileApplicationListener}
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/5.
 */
public class BeforeConfigFileApplicationListener implements SmartApplicationListener, Ordered  {

    /**
     * 优先级必须在 {@link ConfigFileApplicationListener} 之后，才能获取到配置文件
     */
    @Override
    public int getOrder() {
        return ConfigFileApplicationListener.DEFAULT_ORDER +1;
    }

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType)
                || ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }

    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return true;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {

            ApplicationEnvironmentPreparedEvent environmentPreparedEvent = (ApplicationEnvironmentPreparedEvent) event;
            System.out.println("environment.getProperty(\"name\") : " +
                    environmentPreparedEvent.getEnvironment().getProperty("name"));

        }
        if (event instanceof ApplicationPreparedEvent) {

        }
    }
}
