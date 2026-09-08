package io.xguardian.javabench.cases.holdout.level3;

public final class Case000372{
  private Case000372(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=relay(source0);
    // region:start
    java.util.Map<String,Class<?>> allowed=java.util.Map.of("builder",StringBuilder.class,"buffer",StringBuffer.class);
    Class<?> type=allowed.get(value);
    if(type==null)throw new SecurityException("class");
    return type.getDeclaredConstructor().newInstance();
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
