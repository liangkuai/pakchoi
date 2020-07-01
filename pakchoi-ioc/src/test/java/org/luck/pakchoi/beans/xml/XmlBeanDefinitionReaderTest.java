package org.luck.pakchoi.beans.xml;

import org.junit.Assert;
import org.junit.Test;
import org.luck.pakchoi.beans.BeanDefinition;
import org.luck.pakchoi.beans.io.ResourceLoader;

import java.util.Map;

/**
 * @author liukai
 * @date 2020-07-01
 */
public class XmlBeanDefinitionReaderTest {

    @Test
    public void loadBeanDefinitionsTest() throws Exception {
        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlReader.loadBeanDefinitions("ioc.xml");
        Map<String, BeanDefinition> registry = xmlReader.getRegistry();
        Assert.assertTrue(registry.size() > 0);
    }

}