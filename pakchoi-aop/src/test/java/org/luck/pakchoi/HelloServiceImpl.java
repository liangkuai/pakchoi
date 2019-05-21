package org.luck.pakchoi;

/**
 * @author yihua.huang@dianping.com
 */
public class HelloServiceImpl implements HelloService {

    private String text;

    private OutputService outputService;

    @Override
    public void hello(){
        outputService.output(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }
}
