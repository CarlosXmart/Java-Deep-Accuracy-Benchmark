package io.xguardian.javabench.cases.calibration.level1;

public final class Case000383{
  private Case000383(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=source0;
    // region:start
    byte[] bytes=java.util.Base64.getDecoder().decode(value);
    try(var in=new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(bytes))){return in.readObject();}
    // region:end
  }
}
