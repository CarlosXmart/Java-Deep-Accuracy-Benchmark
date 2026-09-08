package io.xguardian.javabench.cases.calibration.level4;

public final class Case000433{
  private Case000433(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    response.sendRedirect(value);
    return null;
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
