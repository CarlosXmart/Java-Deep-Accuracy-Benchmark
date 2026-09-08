package io.xguardian.javabench.cases.calibration.level3;

public final class Case000389{
  private Case000389(){}

  public static Object run(String input)throws Exception{
    var value=relay(input);
    // region:start
    byte[] bytes=java.util.Base64.getDecoder().decode(value);
    try(var in=new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(bytes))){return in.readObject();}
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
