package io.xguardian.javabench.cases.calibration.level4;

public final class Case000394{
  private Case000394(){}

  public static Object run(String input)throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    byte[] bytes=java.util.Base64.getDecoder().decode(value);
    try(var in=new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(bytes))){
      in.setObjectInputFilter(java.io.ObjectInputFilter.Config.createFilter("java.base/java.lang.String;!*"));
      return in.readObject();
    }
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
