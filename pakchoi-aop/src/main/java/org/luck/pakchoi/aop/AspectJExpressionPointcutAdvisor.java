package org.luck.pakchoi.aop;

import org.aopalliance.aop.Advice;

/**
 * @author liukai
 * @date 2019-05-22
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut;

    private Advice advice;


    public void setExpression(String expression) {
        this.pointcut.setExpression(expression);
    }


    @Override
    public Pointcut getPointcut() {
        return null;
    }

    @Override
    public Advice getAdvice() {
        return null;
    }
}
