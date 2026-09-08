package io.xguardian.javabench.cases.calibration.level1;

public final class Case000362{
  private Case000362(){}

  public static Object run(String input)throws Exception{
    var value=input;
    // region:start
    java.util.Map<String,Class<?>> allowed=java.util.Map.of("builder",StringBuilder.class,"buffer",StringBuffer.class);
    Class<?> type=allowed.get(value);
    if(type==null)throw new SecurityException("class");
    return type.getDeclaredConstructor().newInstance();
    // region:end
  }
}
