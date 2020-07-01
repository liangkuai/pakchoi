package org.luck.pakchoi.beans.factory;

import org.junit.Test;
import org.luck.pakchoi.HelloService;
import org.luck.pakchoi.beans.BeanDefinition;
import org.luck.pakchoi.beans.PropertyValue;
import org.luck.pakchoi.beans.PropertyValues;

/**
 * @author liukai
 * @date 2019-05-05
 */
public class BeanFactoryTest {

    @Test
    public void getBeanTest() {

        // 1. 初始化 bean factory
        BeanFactory beanFactory = new BeanFactory();

        // 2. 初始化 bean definition
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("org.luck.pakchoi.HelloService");

        // 3.设置 bean 的属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("text", "Hello world"));
        beanDefinition.setPropertyValues(propertyValues);

        // 4. 注册 bean
        beanFactory.registerBeanDefinition("helloService", beanDefinition);

        // 5. 获取 bean
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.hello();

    }
}