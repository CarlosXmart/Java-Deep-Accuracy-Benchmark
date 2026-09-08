package org.javadeep.benchmark.cases.level2;

import jakarta.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.function.Supplier;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;

public class Case000445 {
    public Object run(InputStream input) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        return factory.newDocumentBuilder().parse(input);
    }
}
