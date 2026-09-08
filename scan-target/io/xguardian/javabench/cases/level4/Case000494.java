package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Case000494 {
    public Object run(Document document, String input) throws Exception {
        XPath xpath = XPathFactory.newInstance().newXPath();
        NodeList nodes = (NodeList) xpath.evaluate("/users/user", document, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            if (input != null && input.equals(nodes.item(i).getTextContent())) return nodes.item(i);
        }
        return null;
    }
}
