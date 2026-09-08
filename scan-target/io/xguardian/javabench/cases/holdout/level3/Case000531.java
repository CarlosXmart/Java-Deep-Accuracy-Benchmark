package io.xguardian.javabench.cases.holdout.level3;

public final class Case000531{
  private Case000531(){}
  private static final java.util.Map<String,String> SENSITIVE=new java.util.concurrent.ConcurrentHashMap<>();

  public static Object run(jakarta.servlet.http.HttpServletRequest input,String newValue)throws Exception{
    var value=relay(input);
    // region:start
    String actor=value.getRemoteUser();
    SENSITIVE.put(actor==null?"anonymous":actor,newValue);
    return Boolean.TRUE;
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
