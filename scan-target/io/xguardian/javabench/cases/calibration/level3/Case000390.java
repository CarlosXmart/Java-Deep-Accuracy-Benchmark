package io.xguardian.javabench.cases.calibration.level3;

public final class Case000390{
  private Case000390(){}

  public static Object run(String input)throws Exception{
    var value=relay(input);
    // region:start
    byte[] bytes=java.util.Base64.getDecoder().decode(value);
    try(var in=new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(bytes))){
      in.setObjectInputFilter(java.io.ObjectInputFilter.Config.createFilter("java.base/java.lang.String;!*"));
      return in.readObject();
    }
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
