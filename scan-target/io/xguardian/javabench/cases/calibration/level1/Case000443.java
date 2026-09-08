package io.xguardian.javabench.cases.calibration.level1;

public final class Case000443{
  private Case000443(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=source0;
    // region:start
    javax.xml.parsers.DocumentBuilderFactory f=javax.xml.parsers.DocumentBuilderFactory.newInstance();
    return f.newDocumentBuilder().parse(new org.xml.sax.InputSource(new java.io.StringReader(value)));
    // region:end
  }
}
