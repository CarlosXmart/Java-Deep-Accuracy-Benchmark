package io.xguardian.javabench.cases.calibration.level3;

public final class Case000249{
  private Case000249(){}

  public static Object run(String input)throws Exception{
    var value=relay(input);
    // region:start
    java.security.MessageDigest md=java.security.MessageDigest.getInstance("MD5");
    return md.digest(value.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
