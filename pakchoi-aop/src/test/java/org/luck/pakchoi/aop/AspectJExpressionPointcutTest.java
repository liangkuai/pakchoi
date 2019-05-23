package org.luck.pakchoi.aop;

import org.junit.Assert;
import org.junit.Test;
import org.luck.pakchoi.HelloService;

/**
 * @author liukai
 * @date 2019-05-23
 */
public class AspectJExpressionPointcutTest {

    @Test
    public void getClassFilterTest() throws Exception {
        String expression = "execution(* org.luck.pakchoi.*.*(..))";
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(expression);
        boolean match = pointcut.getClassFilter().matches(HelloService.class);
        Assert.assertTrue(match);
    }

    @Test
    public void getMethodMatcherTest() throws Exception {
        String expression = "execution(* org.luck.pakchoi.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getMethodMatcher()
                .matches(HelloService.class.getDeclaredMethod("hello"), HelloService.class);
        Assert.assertTrue(matches);
    }
}