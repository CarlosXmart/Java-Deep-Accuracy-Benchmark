package io.xguardian.javabench.cases.calibration.level2;

public final class Case000307{
  private Case000307(){}

  public static Object run(jakarta.servlet.http.HttpServletRequest input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    String email=value.getParameter("email");
    System.setProperty("jdb.account.email",email==null?"":email);
    return email;
    // region:end
  }
}
