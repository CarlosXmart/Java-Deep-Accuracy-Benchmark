package io.xguardian.javabench.cases.level5;

import jakarta.servlet.http.HttpServletRequest;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;

public class Case000398 {
    public Object run(InputStream input) throws Exception {
        ObjectInputStream stream = new ObjectInputStream(input);
        ObjectInputFilter filter = ObjectInputFilter.Config.createFilter("java.base/java.lang.String;!*");
        stream.setObjectInputFilter(filter);
        return stream.readObject();
    }
}
