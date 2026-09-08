package io.xguardian.javabench.cases.holdout.level4;

public final class Case000476{
  private Case000476(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=new Holder<>(relay(source0)).value();
    // region:start
    jakarta.servlet.http.Cookie cookie=new jakarta.servlet.http.Cookie("sid",value);
    cookie.setSecure(true);
    response.addCookie(cookie);
    return cookie;
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
