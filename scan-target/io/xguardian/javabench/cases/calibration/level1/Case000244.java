package io.xguardian.javabench.cases.calibration.level1;

public final class Case000244{
  private Case000244(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=source0;
    // region:start
    java.security.MessageDigest md=java.security.MessageDigest.getInstance("SHA-256");
    return md.digest(value.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    // region:end
  }
}
