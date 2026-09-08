package io.xguardian.javabench.cases.calibration.level2;

public final class Case000127{
  private Case000127(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var stage1=source0;
    var value=stage1;
    // region:start
    response.setHeader("X-Display-Name",value);
    return null;
    // region:end
  }
}
