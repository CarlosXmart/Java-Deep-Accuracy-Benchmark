package org.javadeep.benchmark.cases.level3;

import jakarta.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.function.Supplier;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;

public class Case000451 {
    public Object run(InputStream input) throws Exception {
        DocumentBuilderFactory factory = factory();
        return factory.newDocumentBuilder().parse(input);
    }

    private DocumentBuilderFactory factory() {
        return DocumentBuilderFactory.newInstance();
    }
}
