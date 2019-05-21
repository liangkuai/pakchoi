package org.luck.pakchoi;

import org.junit.Assert;

/**
 * @author yihua.huang@dianping.com
 */
public class OutputService {

    private HelloService helloService;

    public void output(String text){
        Assert.assertNotNull(helloService);
        System.out.println(text);
    }

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }
}
