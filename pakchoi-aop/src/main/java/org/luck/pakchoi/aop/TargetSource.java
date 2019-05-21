package org.luck.pakchoi.aop;

/**
 * 被代理对象
 *
 * @author liukai
 * @date 2019-05-21
 */
public class TargetSource {

    private Class targetClass;

    private Object target;


    public TargetSource(Object target, Class<?> targetClass) {
        this.target = target;
        this.targetClass = targetClass;
    }


    public Class getTargetClass() {
        return targetClass;
    }

    public Object getTarget() {
        return target;
    }
}
