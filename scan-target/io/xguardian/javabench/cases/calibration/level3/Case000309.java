package io.xguardian.javabench.cases.calibration.level3;

public final class Case000309{
  private Case000309(){}

  public static Object run(jakarta.servlet.http.HttpServletRequest input)throws Exception{
    var value=relay(input);
    // region:start
    String email=value.getParameter("email");
    System.setProperty("jdb.account.email",email==null?"":email);
    return email;
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
