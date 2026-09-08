package io.xguardian.javabench.cases.calibration.level1;

public final class Case000562{
  private Case000562(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var value=input;
    // region:start
    jakarta.servlet.http.Cookie cookie=new jakarta.servlet.http.Cookie("session",value);
    cookie.setHttpOnly(true);
    response.addCookie(cookie);
    return cookie;
    // region:end
  }
}
