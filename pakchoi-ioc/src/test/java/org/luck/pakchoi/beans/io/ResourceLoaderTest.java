package org.luck.pakchoi.beans.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author liukai
 * @date 2019-05-20
 */
public class ResourceLoaderTest {

    @Test
    public void getResourceTest() throws Exception {
        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("ioc.xml");
        InputStream inputStream = resource.getInputStream();
        Assert.assertNotNull(inputStream);
    }
}