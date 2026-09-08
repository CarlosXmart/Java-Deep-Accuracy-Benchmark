package io.xguardian.javabench.cases.calibration.level1;

public final class Case000242{
  private Case000242(){}

  public static Object run(String input)throws Exception{
    var value=input;
    // region:start
    java.security.MessageDigest md=java.security.MessageDigest.getInstance("SHA-256");
    return md.digest(value.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    // region:end
  }
}
