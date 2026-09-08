package io.xguardian.javabench.cases.calibration.level1;

public final class Case000462{
  private Case000462(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var value=input;
    // region:start
    jakarta.servlet.http.Cookie cookie=new jakarta.servlet.http.Cookie("sid",value);
    cookie.setSecure(true);
    response.addCookie(cookie);
    return cookie;
    // region:end
  }
}
