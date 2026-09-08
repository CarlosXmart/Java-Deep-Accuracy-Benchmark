package io.xguardian.javabench.cases.calibration.level1;

public final class Case000181{
  private Case000181(){}

  public static Object run(String input)throws Exception{
    var value=input;
    // region:start
    String q=java.net.URLEncoder.encode(value,java.nio.charset.StandardCharsets.UTF_8);
    return new java.net.URL("http://api.example.com/profile?q="+q).openConnection();
    // region:end
  }
}
