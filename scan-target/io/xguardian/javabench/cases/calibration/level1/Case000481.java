package io.xguardian.javabench.cases.calibration.level1;

public final class Case000481{
  private Case000481(){}

  public static Object run(org.w3c.dom.Document document,String input)throws Exception{
    var value=input;
    // region:start
    javax.xml.xpath.XPath xpath=javax.xml.xpath.XPathFactory.newInstance().newXPath();
    javax.xml.xpath.XPathExpression expr=xpath.compile("//user[@name='"+value+"']");
    return expr.evaluate(document);
    // region:end
  }
}
