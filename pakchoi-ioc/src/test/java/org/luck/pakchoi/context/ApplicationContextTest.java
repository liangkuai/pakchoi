package org.luck.pakchoi.context;

import org.junit.Test;
import org.luck.pakchoi.HelloService;

/**
 * @author liukai
 * @date 2020-07-14
 */
public class ApplicationContextTest {

    @Test
    public void test() throws Exception {

        // 1. 创建 IoC 容器 ApplicationContext 对象
        ApplicationContext applicationContext = new ApplicationContext("ioc.xml");

        // 2. 获取 bean，延迟初始化（懒加载）
        HelloService helloService = (HelloService) applicationContext.getBean("helloService");
        helloService.hello();

    }

}