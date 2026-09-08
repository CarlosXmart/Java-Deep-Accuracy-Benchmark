package io.xguardian.javabench.cases.level1;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Case000483 {
    public Object run(Document document, String input) throws Exception {
        XPath xpath = XPathFactory.newInstance().newXPath();
        String expression = String.format("/users/user[@id='%s']", input);
        return xpath.evaluate(expression, document, XPathConstants.NODESET);
    }
}
