package org.javadeep.benchmark.cases.level5;

import jakarta.servlet.http.HttpServletRequest;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;

public class Case000397 {
    public Object run(InputStream input) throws Exception {
        BufferedInputStream buffered = new BufferedInputStream(input);
        ObjectInputStream stream = new ObjectInputStream(buffered);
        return stream.readObject();
    }
}
