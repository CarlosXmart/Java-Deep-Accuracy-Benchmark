package io.xguardian.javabench.cases.holdout.level3;

public final class Case000472{
  private Case000472(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=relay(source0);
    // region:start
    jakarta.servlet.http.Cookie cookie=new jakarta.servlet.http.Cookie("sid",value);
    cookie.setSecure(true);
    response.addCookie(cookie);
    return cookie;
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
