package io.xguardian.javabench.cases.calibration.level1;

public final class Case000484{
  private Case000484(){}

  public static Object run(org.w3c.dom.Document document,String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=source0;
    // region:start
    javax.xml.xpath.XPath xpath=javax.xml.xpath.XPathFactory.newInstance().newXPath();
    xpath.setXPathVariableResolver(name->"name".equals(name.getLocalPart())?value:null);
    javax.xml.xpath.XPathExpression expr=xpath.compile("//user[@name=$name]");
    return expr.evaluate(document);
    // region:end
  }
}
