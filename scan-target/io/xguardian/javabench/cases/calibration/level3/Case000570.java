package io.xguardian.javabench.cases.calibration.level3;

public final class Case000570{
  private Case000570(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var value=relay(input);
    // region:start
    jakarta.servlet.http.Cookie cookie=new jakarta.servlet.http.Cookie("session",value);
    cookie.setHttpOnly(true);
    response.addCookie(cookie);
    return cookie;
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
