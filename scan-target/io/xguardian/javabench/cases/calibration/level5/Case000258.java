package io.xguardian.javabench.cases.calibration.level5;

public final class Case000258{
  private Case000258(){}

  public static Object run(String input)throws Exception{
    var value=java.util.List.of(new Holder<>(relay(input))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    java.security.MessageDigest md=java.security.MessageDigest.getInstance("SHA-256");
    return md.digest(value.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
