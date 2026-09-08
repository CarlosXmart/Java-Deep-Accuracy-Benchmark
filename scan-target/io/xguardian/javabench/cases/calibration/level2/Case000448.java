package io.xguardian.javabench.cases.calibration.level2;

public final class Case000448{
  private Case000448(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var stage1=source0;
    var value=stage1;
    // region:start
    javax.xml.parsers.DocumentBuilderFactory f=javax.xml.parsers.DocumentBuilderFactory.newInstance();
    f.setFeature("http://apache.org/xml/features/disallow-doctype-decl",true);
    f.setFeature("http://xml.org/sax/features/external-general-entities",false);
    f.setFeature("http://xml.org/sax/features/external-parameter-entities",false);
    f.setXIncludeAware(false);f.setExpandEntityReferences(false);
    return f.newDocumentBuilder().parse(new org.xml.sax.InputSource(new java.io.StringReader(value)));
    // region:end
  }
}
