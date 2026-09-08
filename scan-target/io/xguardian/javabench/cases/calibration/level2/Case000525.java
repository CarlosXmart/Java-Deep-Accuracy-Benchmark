package io.xguardian.javabench.cases.calibration.level2;

public final class Case000525{
  private Case000525(){}
  private static final java.util.Map<String,String> SENSITIVE=new java.util.concurrent.ConcurrentHashMap<>();

  public static Object run(jakarta.servlet.http.HttpServletRequest input,String newValue)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    String actor=value.getRemoteUser();
    SENSITIVE.put(actor==null?"anonymous":actor,newValue);
    return Boolean.TRUE;
    // region:end
  }
}
