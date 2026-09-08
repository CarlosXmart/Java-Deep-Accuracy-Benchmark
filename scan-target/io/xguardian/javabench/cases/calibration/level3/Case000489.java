package io.xguardian.javabench.cases.calibration.level3;

public final class Case000489{
  private Case000489(){}

  public static Object run(org.w3c.dom.Document document,String input)throws Exception{
    var value=relay(input);
    // region:start
    javax.xml.xpath.XPath xpath=javax.xml.xpath.XPathFactory.newInstance().newXPath();
    javax.xml.xpath.XPathExpression expr=xpath.compile("//user[@name='"+value+"']");
    return expr.evaluate(document);
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
