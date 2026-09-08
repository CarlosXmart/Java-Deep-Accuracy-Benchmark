package io.xguardian.javabench.cases.calibration.level3;

public final class Case000189{
  private Case000189(){}

  public static Object run(String input)throws Exception{
    var value=relay(input);
    // region:start
    String q=java.net.URLEncoder.encode(value,java.nio.charset.StandardCharsets.UTF_8);
    return new java.net.URL("http://api.example.com/profile?q="+q).openConnection();
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
