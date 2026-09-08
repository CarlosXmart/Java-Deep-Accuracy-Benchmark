package io.xguardian.javabench.cases.calibration.level2;

public final class Case000366{
  private Case000366(){}

  public static Object run(String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    java.util.Map<String,Class<?>> allowed=java.util.Map.of("builder",StringBuilder.class,"buffer",StringBuffer.class);
    Class<?> type=allowed.get(value);
    if(type==null)throw new SecurityException("class");
    return type.getDeclaredConstructor().newInstance();
    // region:end
  }
}
