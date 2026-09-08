package io.xguardian.javabench.cases.calibration.level3;

public final class Case000250{
  private Case000250(){}

  public static Object run(String input)throws Exception{
    var value=relay(input);
    // region:start
    java.security.MessageDigest md=java.security.MessageDigest.getInstance("SHA-256");
    return md.digest(value.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
