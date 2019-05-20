package org.luck.pakchoi.beans.factory;

import org.junit.Test;
import org.luck.pakchoi.HelloService;
import org.luck.pakchoi.beans.BeanDefinition;
import org.luck.pakchoi.beans.io.ResourceLoader;
import org.luck.pakchoi.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author liukai
 * @date 2019-05-05
 */
public class BeanFactoryTest {

    @Test
    public void getBeanTest() throws Exception {

        // 1. 初始化 bean factory
        BeanFactory beanFactory = new BeanFactory();

        // 2. 读取配置，生成 BeanDefinition 对象
        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlReader.loadBeanDefinitions("ioc.xml");

        // 3. 注册 bean
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 4. 获取 bean
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.hello();

    }
}