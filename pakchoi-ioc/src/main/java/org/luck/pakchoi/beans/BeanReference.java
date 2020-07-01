package org.luck.pakchoi.beans;

/**
 * 对于 bean 中有属性引用其他 bean 的情况，
 * 使用 BeanReference 包装所引用的 bean name
 *
 * @author liukai
 * @date 2019-05-20
 */
public class BeanReference {

    private String beanName;


    public BeanReference(String beanName) {
        this.beanName = beanName;
    }


    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
