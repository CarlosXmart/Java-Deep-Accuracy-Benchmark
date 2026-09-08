package io.xguardian.javabench.cases.calibration.level5;

public final class Case000198{
  private Case000198(){}

  public static Object run(String input)throws Exception{
    var value=java.util.List.of(new Holder<>(relay(input))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    String q=java.net.URLEncoder.encode(value,java.nio.charset.StandardCharsets.UTF_8);
    return new java.net.URL("https://api.example.com/profile?q="+q).openConnection();
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
