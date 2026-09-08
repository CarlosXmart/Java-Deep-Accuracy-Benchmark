package io.xguardian.javabench.cases.calibration.level2;

public final class Case000466{
  private Case000466(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    jakarta.servlet.http.Cookie cookie=new jakarta.servlet.http.Cookie("sid",value);
    cookie.setSecure(true);
    response.addCookie(cookie);
    return cookie;
    // region:end
  }
}
