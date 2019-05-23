package org.luck.pakchoi.beans.factory;

import org.luck.pakchoi.beans.BeanDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liukai
 * @date 2019-05-05
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    /**
     * 以 BeanDefinition 对象存储 bean
     */
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    /**
     * 所有 bean name
     */
    private final List<String> beanDefinitionNames = new ArrayList<>();


    @Override
    public Object getBean(String name) throws Exception {
        // 尝试获取 bean 实例
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = beanDefinition.getBean();

        // bean 实例不存在，创建 bean 实例
        if (bean == null) {
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }


    /**
     * 初始化 BeanDefinition 中的 bean
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;


    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }


    public void preInstantiateSingletons() throws Exception {
        for (Iterator it = this.beanDefinitionNames.iterator(); it.hasNext();) {
            String beanName = (String) it.next();
            getBean(beanName);
        }
    }
}
