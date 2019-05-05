package org.luck.pakchoi;

/**
 * @author liukai
 * @date 2019-05-05
 */
public class HelloService {

    private String text;

    public void hello(){
        System.out.println(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
