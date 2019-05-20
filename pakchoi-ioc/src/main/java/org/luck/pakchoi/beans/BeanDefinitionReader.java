package org.luck.pakchoi.beans;

/**
 * 读取配置，生成 BeanDefinition 对象
 *
 * @author liukai
 * @date 2019-05-20
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;

}
