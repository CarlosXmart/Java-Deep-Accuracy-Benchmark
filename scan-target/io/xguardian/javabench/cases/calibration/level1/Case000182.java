package io.xguardian.javabench.cases.calibration.level1;

public final class Case000182{
  private Case000182(){}

  public static Object run(String input)throws Exception{
    var value=input;
    // region:start
    String q=java.net.URLEncoder.encode(value,java.nio.charset.StandardCharsets.UTF_8);
    return new java.net.URL("https://api.example.com/profile?q="+q).openConnection();
    // region:end
  }
}
