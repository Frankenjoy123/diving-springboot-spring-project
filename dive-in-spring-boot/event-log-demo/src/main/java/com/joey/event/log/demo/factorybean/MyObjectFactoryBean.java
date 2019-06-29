package com.joey.event.log.demo.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by xiaowu.zhou on 2019/6/21.
 */
@Component("myObject")
public class MyObjectFactoryBean implements FactoryBean<MyObject> {
    @Nullable
    @Override
    public MyObject getObject() throws Exception {
        MyObject myObject = new MyObject();
        myObject.setName("小伍");
        myObject.setAge(18);
        return myObject;
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return MyObject.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
