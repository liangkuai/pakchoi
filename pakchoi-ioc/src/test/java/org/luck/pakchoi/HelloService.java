package org.luck.pakchoi;

/**
 * @author liukai
 * @date 2019-05-05
 */
public class HelloService {

    private String text;

    private OutputService outputService;


    public void hello(){
        outputService.output(text);
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }

}
