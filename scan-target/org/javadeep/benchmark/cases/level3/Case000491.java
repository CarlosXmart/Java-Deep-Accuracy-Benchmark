package org.javadeep.benchmark.cases.level3;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Case000491 {
    public Object run(Document document, String input) throws Exception {
        String value = relay(input);
        XPath xpath = XPathFactory.newInstance().newXPath();
        String expression = String.format("/users/user[@id='%s']", value);
        return xpath.evaluate(expression, document, XPathConstants.NODESET);
    }

    private String relay(String value) {
        return value;
    }
}
