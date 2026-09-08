package io.xguardian.javabench.cases.calibration.level1;

public final class Case000482{
  private Case000482(){}

  public static Object run(org.w3c.dom.Document document,String input)throws Exception{
    var value=input;
    // region:start
    javax.xml.xpath.XPath xpath=javax.xml.xpath.XPathFactory.newInstance().newXPath();
    xpath.setXPathVariableResolver(name->"name".equals(name.getLocalPart())?value:null);
    javax.xml.xpath.XPathExpression expr=xpath.compile("//user[@name=$name]");
    return expr.evaluate(document);
    // region:end
  }
}
