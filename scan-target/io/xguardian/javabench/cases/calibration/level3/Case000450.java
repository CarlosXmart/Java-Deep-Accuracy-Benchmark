package io.xguardian.javabench.cases.calibration.level3;

public final class Case000450{
  private Case000450(){}

  public static Object run(String input)throws Exception{
    var value=relay(input);
    // region:start
    javax.xml.parsers.DocumentBuilderFactory f=javax.xml.parsers.DocumentBuilderFactory.newInstance();
    f.setFeature("http://apache.org/xml/features/disallow-doctype-decl",true);
    f.setFeature("http://xml.org/sax/features/external-general-entities",false);
    f.setFeature("http://xml.org/sax/features/external-parameter-entities",false);
    f.setXIncludeAware(false);f.setExpandEntityReferences(false);
    return f.newDocumentBuilder().parse(new org.xml.sax.InputSource(new java.io.StringReader(value)));
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
