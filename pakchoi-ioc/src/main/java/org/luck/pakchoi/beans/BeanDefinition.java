package org.luck.pakchoi.beans;

/**
 * 存储 bean 的实例和元数据，对 bean 做了一层包装
 *
 * @author liukai
 * @date 2019-05-05
 */
public class BeanDefinition {

    private Object bean;

    private String beanClassName;

    private Class beanClass;

    /**
     * bean 的属性和值
     */
    private PropertyValues propertyValues = new PropertyValues();


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
