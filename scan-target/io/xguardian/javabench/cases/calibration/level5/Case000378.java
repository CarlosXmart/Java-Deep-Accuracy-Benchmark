package io.xguardian.javabench.cases.calibration.level5;

public final class Case000378{
  private Case000378(){}

  public static Object run(String input)throws Exception{
    var value=java.util.List.of(new Holder<>(relay(input))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    java.util.Map<String,Class<?>> allowed=java.util.Map.of("builder",StringBuilder.class,"buffer",StringBuffer.class);
    Class<?> type=allowed.get(value);
    if(type==null)throw new SecurityException("class");
    return type.getDeclaredConstructor().newInstance();
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
