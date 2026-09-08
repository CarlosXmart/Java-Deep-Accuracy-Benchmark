package io.xguardian.javabench.cases.holdout.level3;

public final class Case000391{
  private Case000391(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=relay(source0);
    // region:start
    byte[] bytes=java.util.Base64.getDecoder().decode(value);
    try(var in=new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(bytes))){return in.readObject();}
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
