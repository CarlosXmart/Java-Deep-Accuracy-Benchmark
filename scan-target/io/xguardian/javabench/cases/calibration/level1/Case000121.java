package io.xguardian.javabench.cases.calibration.level1;

public final class Case000121{
  private Case000121(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var value=input;
    // region:start
    response.setHeader("X-Display-Name",value);
    return null;
    // region:end
  }
}
