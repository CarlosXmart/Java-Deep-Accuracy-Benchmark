package io.xguardian.javabench.cases.calibration.level2;

public final class Case000425{
  private Case000425(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    response.sendRedirect(value);
    return null;
    // region:end
  }
}
