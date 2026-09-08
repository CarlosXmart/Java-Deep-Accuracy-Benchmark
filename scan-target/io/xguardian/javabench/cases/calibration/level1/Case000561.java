package io.xguardian.javabench.cases.calibration.level1;

public final class Case000561{
  private Case000561(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var value=input;
    // region:start
    jakarta.servlet.http.Cookie cookie=new jakarta.servlet.http.Cookie("session",value);
    response.addCookie(cookie);
    return cookie;
    // region:end
  }
}
