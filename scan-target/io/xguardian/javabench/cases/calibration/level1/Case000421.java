package io.xguardian.javabench.cases.calibration.level1;

public final class Case000421{
  private Case000421(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var value=input;
    // region:start
    response.sendRedirect(value);
    return null;
    // region:end
  }
}
