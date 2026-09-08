package io.xguardian.javabench.cases.calibration.level4;

public final class Case000254{
  private Case000254(){}

  public static Object run(String input)throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    java.security.MessageDigest md=java.security.MessageDigest.getInstance("SHA-256");
    return md.digest(value.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
