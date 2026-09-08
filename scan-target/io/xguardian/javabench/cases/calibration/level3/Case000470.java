package io.xguardian.javabench.cases.calibration.level3;

public final class Case000470{
  private Case000470(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var value=relay(input);
    // region:start
    jakarta.servlet.http.Cookie cookie=new jakarta.servlet.http.Cookie("sid",value);
    cookie.setSecure(true);
    response.addCookie(cookie);
    return cookie;
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
