package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;

public class Case000396 {
    public Object run(HttpServletRequest request) throws Exception {
        InputStream input = request.getInputStream();
        byte[] bytes = input.readNBytes(4096);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
