package com.joey.segmentment.starter.autoconfigure;

import com.joey.segmentment.starter.domain.Person;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/9/13.
 */
@Configuration
@ConditionalOnProperty(prefix = "person",name = "enable",
        havingValue = "true",matchIfMissing = true)
@EnableConfigurationProperties()
public class PersonAutoConfigure {

    @Bean
    @ConfigurationProperties(prefix = "person")
    public Person person(){
        return new Person();
    }

}
