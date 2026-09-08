package io.xguardian.javabench.cases.calibration.level2;

public final class Case000568{
  private Case000568(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var stage1=source0;
    var value=stage1;
    // region:start
    jakarta.servlet.http.Cookie cookie=new jakarta.servlet.http.Cookie("session",value);
    cookie.setHttpOnly(true);
    response.addCookie(cookie);
    return cookie;
    // region:end
  }
}
