package io.xguardian.javabench.cases.calibration.level1;

public final class Case000382{
  private Case000382(){}

  public static Object run(String input)throws Exception{
    var value=input;
    // region:start
    byte[] bytes=java.util.Base64.getDecoder().decode(value);
    try(var in=new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(bytes))){
      in.setObjectInputFilter(java.io.ObjectInputFilter.Config.createFilter("java.base/java.lang.String;!*"));
      return in.readObject();
    }
    // region:end
  }
}
