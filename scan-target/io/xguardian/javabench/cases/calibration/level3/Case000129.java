package io.xguardian.javabench.cases.calibration.level3;

public final class Case000129{
  private Case000129(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var value=relay(input);
    // region:start
    response.setHeader("X-Display-Name",value);
    return null;
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
