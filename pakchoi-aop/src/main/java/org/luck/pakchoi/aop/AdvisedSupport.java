package org.luck.pakchoi.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * @author liukai
 * @date 2019-05-21
 */
public class AdvisedSupport {

    private TargetSource targetSource;

    /**
     * Advice 逻辑
     */
    private MethodInterceptor methodInterceptor;


    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }
}
