package org.luck.pakchoi.beans;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liukai
 * @date 2019-05-05
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();


    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }


    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        beanDefinition.setBean(bean);

        beanDefinitionMap.put(name, beanDefinition);
    }
}
