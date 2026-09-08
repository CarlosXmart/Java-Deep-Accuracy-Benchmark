package io.xguardian.javabench.cases.calibration.level1;

public final class Case000123{
  private Case000123(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=source0;
    // region:start
    response.setHeader("X-Display-Name",value);
    return null;
    // region:end
  }
}
