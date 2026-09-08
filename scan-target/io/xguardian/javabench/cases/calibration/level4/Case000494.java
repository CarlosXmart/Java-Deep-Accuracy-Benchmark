package io.xguardian.javabench.cases.calibration.level4;

public final class Case000494{
  private Case000494(){}

  public static Object run(org.w3c.dom.Document document,String input)throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    javax.xml.xpath.XPath xpath=javax.xml.xpath.XPathFactory.newInstance().newXPath();
    xpath.setXPathVariableResolver(name->"name".equals(name.getLocalPart())?value:null);
    javax.xml.xpath.XPathExpression expr=xpath.compile("//user[@name=$name]");
    return expr.evaluate(document);
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
