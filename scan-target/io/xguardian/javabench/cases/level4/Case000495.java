package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Case000495 {
    public Object run(Document document, HttpServletRequest request) throws Exception {
        String value = request.getParameter("query");
        XPath xpath = XPathFactory.newInstance().newXPath();
        String expression = String.format("/users/user[@id='%s']", value);
        return xpath.evaluate(expression, document, XPathConstants.NODESET);
    }
}
