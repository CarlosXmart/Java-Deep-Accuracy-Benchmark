package io.xguardian.javabench.cases.calibration.level2;

public final class Case000427{
  private Case000427(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var stage1=source0;
    var value=stage1;
    // region:start
    response.sendRedirect(value);
    return null;
    // region:end
  }
}
