package org.luck.pakchoi.beans;

/**
 * @author liukai
 * @date 2019-05-05
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
