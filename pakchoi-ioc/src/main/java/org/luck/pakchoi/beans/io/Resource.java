package org.luck.pakchoi.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Spring 中定位资源的接口
 *
 * @author liukai
 * @date 2019-05-20
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
