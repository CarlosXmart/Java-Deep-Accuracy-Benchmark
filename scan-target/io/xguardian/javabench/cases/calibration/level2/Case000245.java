package io.xguardian.javabench.cases.calibration.level2;

public final class Case000245{
  private Case000245(){}

  public static Object run(String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    java.security.MessageDigest md=java.security.MessageDigest.getInstance("MD5");
    return md.digest(value.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    // region:end
  }
}
