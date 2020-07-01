package org.luck.pakchoi.beans.factory;

/**
 * bean factory
 *
 * @author liukai
 * @date 2019-05-23
 */
public interface BeanFactory {

    /**
     * 获取 bean 实例
     */
    Object getBean(String name) throws Exception;
}
