package org.luck.pakchoi.beans.factory;

import org.luck.pakchoi.beans.BeanDefinition;
import org.luck.pakchoi.beans.BeanReference;
import org.luck.pakchoi.beans.PropertyValue;

import java.lang.reflect.Field;

/**
 * 可自动装配内容的 BeanFactory
 *
 * @author liukai
 * @date 2019-05-23
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    /**
     * 初始化 BeanDefinition 中的 bean
     */
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        // 1. 创建 bean
        Object bean = createBeanInstance(beanDefinition);

        // 2. 将刚创建的 bean 设置到 BeanDefinition 中
        beanDefinition.setBean(bean);

        // 3. 设置 bean 的属性值
        applyPropertyValues(bean, beanDefinition);

        return bean;
    }

    /**
     * 创建 BeanDefinition 中的 bean
     */
    private Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    /**
     * 根据 BeanDefinition 中存储的属性设置 bean 的属性值
     */
    private void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            Object value = propertyValue.getValue();

            // 如果属性是引用其他 bean，尝试获取所引用的 bean
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getBeanName());
            }
            declaredField.set(bean, value);
        }
    }
}
