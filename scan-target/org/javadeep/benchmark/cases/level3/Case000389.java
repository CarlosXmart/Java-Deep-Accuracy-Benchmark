package org.javadeep.benchmark.cases.level3;

import jakarta.servlet.http.HttpServletRequest;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;

public class Case000389 {
    public Object run(InputStream input) throws Exception {
        return deserialize(input);
    }

    private Object deserialize(InputStream input) throws Exception {
        ObjectInputStream stream = new ObjectInputStream(input);
        return stream.readObject();
    }
}
