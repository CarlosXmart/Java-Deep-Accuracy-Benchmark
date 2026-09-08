package io.xguardian.javabench.cases.calibration.level2;

public final class Case000125{
  private Case000125(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    response.setHeader("X-Display-Name",value);
    return null;
    // region:end
  }
}
