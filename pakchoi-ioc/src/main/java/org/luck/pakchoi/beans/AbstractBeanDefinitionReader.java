package org.luck.pakchoi.beans;

import org.luck.pakchoi.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liukai
 * @date 2019-05-20
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private Map<String, BeanDefinition> registry;

    private ResourceLoader resourceLoader;


    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }


    public Map<String, BeanDefinition> getRegistry() {
        return this.registry;
    }

    public ResourceLoader getResourceLoader() {
        return this.resourceLoader;
    }
}
