package com.joey.analyze.event.log.client.config;

import com.joey.analyze.event.log.client.bean.EventMonitor;
import com.sun.org.apache.xerces.internal.dom.DeepNodeListImpl;
import com.sun.org.apache.xerces.internal.dom.DeferredElementNSImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.lang.Nullable;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaowu.zhou on 2019/6/20.
 */
public class MonitorBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    private static final String DEFAULT_BEAN_NAME = "eventMonitor";

    @Nullable
    @Override
    protected Class<?> getBeanClass(Element element) {
        return EventMonitor.class;
    }

    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {

        String monitorName = element.getAttribute("monitor-name");
        builder.addPropertyValue("monitorName",monitorName);

        List<String> itempropList = new ArrayList<>();

//        NodeList itemList = element.getChildNodes();
        NodeList itemList = element.getElementsByTagName("event-client:monitor-item");

        if (itemList != null && itemList.getLength() > 0) {

            DeepNodeListImpl deepNodeList = (DeepNodeListImpl) itemList;


            for (int i=0 ; i<deepNodeList.getLength();i++){

                Node node = deepNodeList.item(i);

                DeferredElementNSImpl nodeIml = (DeferredElementNSImpl) node;
                String follow = nodeIml.getAttribute("follow");
                itempropList.add(follow);
            }
        }

        builder.addPropertyValue("monitorItemList",itempropList);
    }


    @Override
    protected String resolveId(Element element, AbstractBeanDefinition definition, ParserContext parserContext) throws BeanDefinitionStoreException {
        String id = super.resolveId(element, definition, parserContext);

        if (StringUtils.isBlank(id)){
            id = DEFAULT_BEAN_NAME;
        }
        return id;
    }
}
