package io.xguardian.javabench.cases.calibration.level2;

public final class Case000185{
  private Case000185(){}

  public static Object run(String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    String q=java.net.URLEncoder.encode(value,java.nio.charset.StandardCharsets.UTF_8);
    return new java.net.URL("http://api.example.com/profile?q="+q).openConnection();
    // region:end
  }
}
