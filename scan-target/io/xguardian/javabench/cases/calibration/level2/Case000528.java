package io.xguardian.javabench.cases.calibration.level2;

public final class Case000528{
  private Case000528(){}
  private static final java.util.Map<String,String> SENSITIVE=new java.util.concurrent.ConcurrentHashMap<>();

  public static Object run(jakarta.servlet.http.HttpServletRequest input,String newValue)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    if(!value.isUserInRole("ADMIN"))throw new SecurityException("forbidden");
    String actor=value.getRemoteUser();
    SENSITIVE.put(actor==null?"anonymous":actor,newValue);
    return Boolean.TRUE;
    // region:end
  }
}
