package io.xguardian.javabench.cases.calibration.level3;

public final class Case000370{
  private Case000370(){}

  public static Object run(String input)throws Exception{
    var value=relay(input);
    // region:start
    java.util.Map<String,Class<?>> allowed=java.util.Map.of("builder",StringBuilder.class,"buffer",StringBuffer.class);
    Class<?> type=allowed.get(value);
    if(type==null)throw new SecurityException("class");
    return type.getDeclaredConstructor().newInstance();
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
