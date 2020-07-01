package org.luck.pakchoi.beans.factory;

import org.luck.pakchoi.beans.BeanDefinition;
import org.luck.pakchoi.beans.BeanReference;
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


    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }


    public Object getBean(String name) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = createBean(beanDefinition);
        }
        return bean;
    }

    private Object createBean(BeanDefinition beanDefinition) {
        try {
            // 1. 实例化 Bean
            Object bean = beanDefinition.getBeanClass().newInstance();

            // 2. 把 bean 对象设置到 beanDefinition 中
            beanDefinition.setBean(bean);

            // 3. 设置 bean 的属性
            for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    value = getBean(((BeanReference) value).getName());
                }
                declaredField.set(bean, value);
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
