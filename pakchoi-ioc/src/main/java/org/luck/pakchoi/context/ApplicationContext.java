package org.luck.pakchoi.context;

import org.luck.pakchoi.beans.BeanDefinition;
import org.luck.pakchoi.beans.factory.BeanFactory;
import org.luck.pakchoi.beans.io.ResourceLoader;
import org.luck.pakchoi.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author liukai
 * @date 2020-07-14
 */
public class ApplicationContext {

    private String configLocation;

    private BeanFactory beanFactory;

    public ApplicationContext(String configLocation) throws Exception {
        this.configLocation = configLocation;
        this.beanFactory = new BeanFactory();
        refresh();
    }

    public void refresh() throws Exception {

        // 1. 创建 XmlBeanDefinitionReader 对象
        // 读取 xlm 配置文件，解析并生成 BeanDefinition 对象
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);

        // 2. 将 Reader 中的 BeanDefinition 对象注册到 IoC 容器中
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

    }

    public Object getBean(String name) {
        return beanFactory.getBean(name);
    }

}
