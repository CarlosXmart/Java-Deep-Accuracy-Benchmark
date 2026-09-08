package io.xguardian.javabench.cases.calibration.level2;

public final class Case000465{
  private Case000465(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    jakarta.servlet.http.Cookie cookie=new jakarta.servlet.http.Cookie("sid",value);
    response.addCookie(cookie);
    return cookie;
    // region:end
  }
}
