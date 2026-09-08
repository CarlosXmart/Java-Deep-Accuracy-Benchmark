package io.xguardian.javabench.cases.calibration.level2;

public final class Case000247{
  private Case000247(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var stage1=source0;
    var value=stage1;
    // region:start
    java.security.MessageDigest md=java.security.MessageDigest.getInstance("MD5");
    return md.digest(value.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    // region:end
  }
}
