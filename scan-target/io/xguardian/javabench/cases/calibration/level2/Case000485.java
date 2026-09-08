package io.xguardian.javabench.cases.calibration.level2;

public final class Case000485{
  private Case000485(){}

  public static Object run(org.w3c.dom.Document document,String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    javax.xml.xpath.XPath xpath=javax.xml.xpath.XPathFactory.newInstance().newXPath();
    javax.xml.xpath.XPathExpression expr=xpath.compile("//user[@name='"+value+"']");
    return expr.evaluate(document);
    // region:end
  }
}
