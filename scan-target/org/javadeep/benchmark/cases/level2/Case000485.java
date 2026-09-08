package org.javadeep.benchmark.cases.level2;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Case000485 {
    public Object run(Document document, String input) throws Exception {
        String value = input == null ? "" : input.trim();
        XPath xpath = XPathFactory.newInstance().newXPath();
        String expression = "/users/user[name='" + value + "']";
        return xpath.evaluate(expression, document, XPathConstants.NODESET);
    }
}
