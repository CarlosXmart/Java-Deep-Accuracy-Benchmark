package io.xguardian.javabench.cases.calibration.level1;

public final class Case000441{
  private Case000441(){}

  public static Object run(String input)throws Exception{
    var value=input;
    // region:start
    javax.xml.parsers.DocumentBuilderFactory f=javax.xml.parsers.DocumentBuilderFactory.newInstance();
    return f.newDocumentBuilder().parse(new org.xml.sax.InputSource(new java.io.StringReader(value)));
    // region:end
  }
}
