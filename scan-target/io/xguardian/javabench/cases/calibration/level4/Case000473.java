package io.xguardian.javabench.cases.calibration.level4;

public final class Case000473{
  private Case000473(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    jakarta.servlet.http.Cookie cookie=new jakarta.servlet.http.Cookie("sid",value);
    response.addCookie(cookie);
    return cookie;
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
