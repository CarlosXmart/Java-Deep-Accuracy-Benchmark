package io.xguardian.javabench.cases.calibration.level1;

public final class Case000563{
  private Case000563(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=source0;
    // region:start
    jakarta.servlet.http.Cookie cookie=new jakarta.servlet.http.Cookie("session",value);
    response.addCookie(cookie);
    return cookie;
    // region:end
  }
}
