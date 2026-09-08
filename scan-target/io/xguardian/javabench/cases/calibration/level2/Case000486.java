package io.xguardian.javabench.cases.calibration.level2;

public final class Case000486{
  private Case000486(){}

  public static Object run(org.w3c.dom.Document document,String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    javax.xml.xpath.XPath xpath=javax.xml.xpath.XPathFactory.newInstance().newXPath();
    xpath.setXPathVariableResolver(name->"name".equals(name.getLocalPart())?value:null);
    javax.xml.xpath.XPathExpression expr=xpath.compile("//user[@name=$name]");
    return expr.evaluate(document);
    // region:end
  }
}
