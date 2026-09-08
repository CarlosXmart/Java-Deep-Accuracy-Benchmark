package io.xguardian.javabench.cases.calibration.level1;

public final class Case000461{
  private Case000461(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var value=input;
    // region:start
    jakarta.servlet.http.Cookie cookie=new jakarta.servlet.http.Cookie("sid",value);
    response.addCookie(cookie);
    return cookie;
    // region:end
  }
}
