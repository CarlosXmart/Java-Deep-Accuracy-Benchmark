package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.function.Supplier;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;

public class Case000455 {
    public Object run(HttpServletRequest request) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        return factory.newDocumentBuilder().parse(request.getInputStream());
    }
}
