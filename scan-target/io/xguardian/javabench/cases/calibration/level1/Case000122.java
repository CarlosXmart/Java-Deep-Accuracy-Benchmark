package io.xguardian.javabench.cases.calibration.level1;

public final class Case000122{
  private Case000122(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var value=input;
    // region:start
    if(value.indexOf('\r')>=0||value.indexOf('\n')>=0)throw new IllegalArgumentException("invalid header");
    response.setHeader("X-Display-Name",value);
    return null;
    // region:end
  }
}
