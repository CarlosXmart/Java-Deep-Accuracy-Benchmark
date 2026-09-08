package io.xguardian.javabench.cases.calibration.level1;

public final class Case000423{
  private Case000423(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=source0;
    // region:start
    response.sendRedirect(value);
    return null;
    // region:end
  }
}
