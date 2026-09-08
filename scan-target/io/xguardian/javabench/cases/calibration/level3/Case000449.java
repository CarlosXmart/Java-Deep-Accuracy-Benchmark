package io.xguardian.javabench.cases.calibration.level3;

public final class Case000449{
  private Case000449(){}

  public static Object run(String input)throws Exception{
    var value=relay(input);
    // region:start
    javax.xml.parsers.DocumentBuilderFactory f=javax.xml.parsers.DocumentBuilderFactory.newInstance();
    return f.newDocumentBuilder().parse(new org.xml.sax.InputSource(new java.io.StringReader(value)));
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
