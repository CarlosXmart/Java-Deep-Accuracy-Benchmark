package org.javadeep.benchmark.cases.level5;

import jakarta.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.function.Supplier;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;

public class Case000457 {
    public Object run(InputStream input) throws Exception {
        Supplier<DocumentBuilderFactory> supplier = DocumentBuilderFactory::newInstance;
        DocumentBuilderFactory factory = supplier.get();
        return factory.newDocumentBuilder().parse(input);
    }
}
