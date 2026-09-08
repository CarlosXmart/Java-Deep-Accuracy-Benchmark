package io.xguardian.javabench.cases.calibration.level2;

public final class Case000385{
  private Case000385(){}

  public static Object run(String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    byte[] bytes=java.util.Base64.getDecoder().decode(value);
    try(var in=new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(bytes))){return in.readObject();}
    // region:end
  }
}
