package org.luck.pakchoi.aop;

import org.aopalliance.aop.Advice;

/**
 * @author liukai
 * @date 2019-05-22
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

    private Advice advice;


    public void setExpression(String expression) {
        this.pointcut.setExpression(expression);
    }


    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
