package io.xguardian.javabench.cases.calibration.level3;

public final class Case000490{
  private Case000490(){}

  public static Object run(org.w3c.dom.Document document,String input)throws Exception{
    var value=relay(input);
    // region:start
    javax.xml.xpath.XPath xpath=javax.xml.xpath.XPathFactory.newInstance().newXPath();
    xpath.setXPathVariableResolver(name->"name".equals(name.getLocalPart())?value:null);
    javax.xml.xpath.XPathExpression expr=xpath.compile("//user[@name=$name]");
    return expr.evaluate(document);
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
