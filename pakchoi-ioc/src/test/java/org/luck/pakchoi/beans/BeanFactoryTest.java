package org.luck.pakchoi.beans;

import org.junit.Test;
import org.luck.pakchoi.HelloService;

/**
 * @author liukai
 * @date 2019-05-05
 */
public class BeanFactoryTest {

    @Test
    public void getBeanTest() {

        // 1. 初始化 bean factory
        BeanFactory beanFactory = new BeanFactory();

        // 2. 注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(new HelloService());
        beanFactory.registerBeanDefinition("helloService", beanDefinition);

        // 3. 获取 bean
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.hello();

    }
}