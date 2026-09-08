package io.xguardian.javabench.cases.calibration.level2;

public final class Case000386{
  private Case000386(){}

  public static Object run(String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    byte[] bytes=java.util.Base64.getDecoder().decode(value);
    try(var in=new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(bytes))){
      in.setObjectInputFilter(java.io.ObjectInputFilter.Config.createFilter("java.base/java.lang.String;!*"));
      return in.readObject();
    }
    // region:end
  }
}
