package io.xguardian.javabench.cases.calibration.level1;

public final class Case000301{
  private Case000301(){}

  public static Object run(jakarta.servlet.http.HttpServletRequest input)throws Exception{
    var value=input;
    // region:start
    String email=value.getParameter("email");
    System.setProperty("jdb.account.email",email==null?"":email);
    return email;
    // region:end
  }
}
