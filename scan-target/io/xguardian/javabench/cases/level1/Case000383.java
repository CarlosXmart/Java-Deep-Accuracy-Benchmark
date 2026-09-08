package io.xguardian.javabench.cases.level1;

import jakarta.servlet.http.HttpServletRequest;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;

public class Case000383 {
    public Object run(InputStream input) throws Exception {
        XMLDecoder decoder = new XMLDecoder(input);
        return decoder.readObject();
    }
}
