package io.xguardian.javabench.cases.calibration.level3;

public final class Case000530{
  private Case000530(){}
  private static final java.util.Map<String,String> SENSITIVE=new java.util.concurrent.ConcurrentHashMap<>();

  public static Object run(jakarta.servlet.http.HttpServletRequest input,String newValue)throws Exception{
    var value=relay(input);
    // region:start
    if(!value.isUserInRole("ADMIN"))throw new SecurityException("forbidden");
    String actor=value.getRemoteUser();
    SENSITIVE.put(actor==null?"anonymous":actor,newValue);
    return Boolean.TRUE;
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
