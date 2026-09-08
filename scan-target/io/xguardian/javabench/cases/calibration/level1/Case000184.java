package io.xguardian.javabench.cases.calibration.level1;

public final class Case000184{
  private Case000184(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=source0;
    // region:start
    String q=java.net.URLEncoder.encode(value,java.nio.charset.StandardCharsets.UTF_8);
    return new java.net.URL("https://api.example.com/profile?q="+q).openConnection();
    // region:end
  }
}
