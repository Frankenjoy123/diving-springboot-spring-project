package com.joey.analyze.event.log.client.config;

import com.google.common.base.CaseFormat;
import com.joey.analyze.event.log.client.bean.EventConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.lang.Nullable;
import org.w3c.dom.Element;

/**
 * Created by xiaowu.zhou on 2019/6/18.
 */
public class EventConfigBeanDefinitionParser extends AbstractSingleBeanDefinitionParser{

    public static final String DEFAULT_BEAN_NAME = "eventConfiguration";

    private static final String APP_CODE = "app-code";
    private static final String DEBUG = "debug";

    @Override
    protected String resolveId(Element element, AbstractBeanDefinition definition, ParserContext parserContext) throws BeanDefinitionStoreException {
        String id = super.resolveId(element, definition, parserContext);

        if (StringUtils.isBlank(id)){
            id = DEFAULT_BEAN_NAME;
        }

        return id;
    }

    @Nullable
    @Override
    protected Class<?> getBeanClass(Element element) {
        return EventConfiguration.class;
    }

    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {

        String appCode = element.getAttribute(APP_CODE);
        if (StringUtils.isNotEmpty(appCode)){
            builder.addPropertyValue(CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL,APP_CODE) , appCode);
        }

        String debug = element.getAttribute(DEBUG);
        if (StringUtils.isNotEmpty(debug)) {
            builder.addPropertyValue(DEBUG,Boolean.parseBoolean(debug));
        }

    }

}
