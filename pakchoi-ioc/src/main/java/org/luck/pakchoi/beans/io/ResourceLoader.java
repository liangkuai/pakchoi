package org.luck.pakchoi.beans.io;

import java.net.URL;

/**
 * @author liukai
 * @date 2019-05-20
 */
public class ResourceLoader {

    public Resource getResource(String location){
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
