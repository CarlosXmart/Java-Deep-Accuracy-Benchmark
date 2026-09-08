package io.xguardian.javabench.cases.holdout.level4;

public final class Case000255{
  private Case000255(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=new Holder<>(relay(source0)).value();
    // region:start
    java.security.MessageDigest md=java.security.MessageDigest.getInstance("MD5");
    return md.digest(value.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
