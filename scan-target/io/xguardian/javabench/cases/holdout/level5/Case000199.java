package io.xguardian.javabench.cases.holdout.level5;

public final class Case000199{
  private Case000199(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=java.util.List.of(new Holder<>(relay(source0))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    String q=java.net.URLEncoder.encode(value,java.nio.charset.StandardCharsets.UTF_8);
    return new java.net.URL("http://api.example.com/profile?q="+q).openConnection();
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
