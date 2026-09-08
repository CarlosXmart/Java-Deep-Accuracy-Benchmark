package io.xguardian.javabench.cases.calibration.level5;

public final class Case000498{
  private Case000498(){}

  public static Object run(org.w3c.dom.Document document,String input)throws Exception{
    var value=java.util.List.of(new Holder<>(relay(input))).stream().map(Holder::value).findFirst().orElseThrow();
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
