package io.xguardian.javabench.cases.calibration.level2;

public final class Case000445{
  private Case000445(){}

  public static Object run(String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    javax.xml.parsers.DocumentBuilderFactory f=javax.xml.parsers.DocumentBuilderFactory.newInstance();
    return f.newDocumentBuilder().parse(new org.xml.sax.InputSource(new java.io.StringReader(value)));
    // region:end
  }
}
