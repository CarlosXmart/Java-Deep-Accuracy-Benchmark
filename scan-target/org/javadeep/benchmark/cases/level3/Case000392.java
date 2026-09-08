package org.javadeep.benchmark.cases.level3;

import jakarta.servlet.http.HttpServletRequest;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;

public class Case000392 {
    public Object run(InputStream input) throws Exception {
        byte[] bytes = input.readNBytes(4096);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
