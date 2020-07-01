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

        // 1. 创建 IoC 容器 BeanFactory 对象
        BeanFactory beanFactory = new BeanFactory();

        // 2. 创建 XmlBeanDefinitionReader 对象
        // 读取 xlm 配置文件，解析并生成 BeanDefinition 对象
        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlReader.loadBeanDefinitions("ioc.xml");

        // 3. 将 Reader 中的 BeanDefinition 对象注册到 IoC 容器中
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 4. 获取 bean，延迟初始化（懒加载）
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.hello();

    }
}