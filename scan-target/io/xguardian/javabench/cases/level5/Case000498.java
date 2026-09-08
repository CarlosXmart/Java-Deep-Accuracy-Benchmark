package io.xguardian.javabench.cases.level5;

import java.util.function.Function;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Case000498 {
    public Object run(Document document, String input) throws Exception {
        Function<String, String> relay = value -> value;
        String value = relay.apply(input);
        XPath xpath = XPathFactory.newInstance().newXPath();
        NodeList nodes = (NodeList) xpath.evaluate("/users/user", document, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            if (value != null && value.equals(nodes.item(i).getTextContent())) return nodes.item(i);
        }
        return null;
    }
}
