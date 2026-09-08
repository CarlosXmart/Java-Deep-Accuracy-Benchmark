package io.xguardian.javabench.cases.level5;

import java.util.function.Function;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Case000499 {
    public Object run(Document document, String input) throws Exception {
        Function<String, String> relay = value -> value;
        String value = relay.apply(input);
        XPath xpath = XPathFactory.newInstance().newXPath();
        String expression = String.format("/users/user[@id='%s']", value);
        return xpath.evaluate(expression, document, XPathConstants.NODESET);
    }
}
