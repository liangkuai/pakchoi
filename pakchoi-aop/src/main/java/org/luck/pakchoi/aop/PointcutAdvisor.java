package org.luck.pakchoi.aop;

/**
 * @author liukai
 * @date 2019-05-22
 */
public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();
}
