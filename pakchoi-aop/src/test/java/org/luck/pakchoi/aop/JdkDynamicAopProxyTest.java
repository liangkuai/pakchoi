package org.luck.pakchoi.aop;

import org.junit.Test;
import org.luck.pakchoi.HelloService;
import org.luck.pakchoi.beans.BeanDefinition;
import org.luck.pakchoi.beans.factory.BeanFactory;
import org.luck.pakchoi.beans.io.ResourceLoader;
import org.luck.pakchoi.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author liukai
 * @date 2019-05-21
 */
public class JdkDynamicAopProxyTest {


    @Test
    public void getProxyTest() throws Exception {
        // 1. 初始化 bean factory
        BeanFactory beanFactory = new BeanFactory();

        // 2. 读取配置，生成 BeanDefinition 对象
        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlReader.loadBeanDefinitions("ioc.xml");

        // 3. 注册 bean
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 4. 获取 bean，延迟初始化（懒加载）
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");

        // 设置被代理对象
        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(helloService, HelloService.class);
        advisedSupport.setTargetSource(targetSource);

        // 设置拦截器（advice）
        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advisedSupport.setMethodInterceptor(timerInterceptor);

        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
        HelloService helloServiceProxy = (HelloService) jdkDynamicAopProxy.getProxy();

        helloServiceProxy.hello();
    }
}