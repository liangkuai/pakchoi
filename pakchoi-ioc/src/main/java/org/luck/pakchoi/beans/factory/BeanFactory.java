package org.luck.pakchoi.beans.factory;

import org.luck.pakchoi.beans.BeanDefinition;
import org.luck.pakchoi.beans.PropertyValue;

import java.lang.reflect.Field;
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
        Object bean = createBean(beanDefinition);
        beanDefinition.setBean(bean);

        beanDefinitionMap.put(name, beanDefinition);
    }


    private Object createBean(BeanDefinition beanDefinition) {
        try {
            Object bean = beanDefinition.getBeanClass().newInstance();

            for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                declaredField.set(bean, propertyValue.getValue());
            }

            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}
