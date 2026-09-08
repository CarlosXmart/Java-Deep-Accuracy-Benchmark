package io.xguardian.javabench.cases.calibration.level4;

public final class Case000253{
  private Case000253(){}

  public static Object run(String input)throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    java.security.MessageDigest md=java.security.MessageDigest.getInstance("MD5");
    return md.digest(value.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
