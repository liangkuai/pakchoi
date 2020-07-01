package org.luck.pakchoi.beans.factory;

import org.luck.pakchoi.beans.BeanDefinition;
import org.luck.pakchoi.beans.BeanReference;
import org.luck.pakchoi.beans.PropertyValue;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liukai
 * @date 2019-05-05
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private final List<String> beanDefinitionNames = new ArrayList<String>();


    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
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
            // 1. 实例化 bean
            Object bean = beanDefinition.getBeanClass().newInstance();

            // 2. 把 bean 设置到 bean definition 中
            beanDefinition.setBean(bean);

            // 3. 设置 bean 的属性
            for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getName());
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



    public void preInstantiateSingletons() throws Exception {
        for (Iterator it = this.beanDefinitionNames.iterator(); it.hasNext();) {
            String beanName = (String) it.next();
            getBean(beanName);
        }
    }
}
