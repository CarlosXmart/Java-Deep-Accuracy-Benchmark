package io.xguardian.javabench.cases.holdout.level4;

public final class Case000496{
  private Case000496(){}

  public static Object run(org.w3c.dom.Document document,String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=new Holder<>(relay(source0)).value();
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
