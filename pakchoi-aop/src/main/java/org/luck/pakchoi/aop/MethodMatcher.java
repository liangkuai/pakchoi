package org.luck.pakchoi.aop;

import java.lang.reflect.Method;

/**
 * @author liukai
 * @date 2019-05-22
 */
public interface MethodMatcher {

    boolean matches(Method method, Class targetClass);
}
