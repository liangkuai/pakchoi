package org.luck.pakchoi.beans;

/**
 * @author liukai
 * @date 2019-05-05
 */
public class BeanDefinition {

    private Object bean;

    private String beanClassName;

    private Class beanClass;

    private PropertyValues propertyValues;


    public BeanDefinition() {
    }


    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;

        // 设置 bean 所属类的全限定名称，并设置 class 对象
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
