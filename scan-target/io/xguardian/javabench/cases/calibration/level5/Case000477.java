package io.xguardian.javabench.cases.calibration.level5;

public final class Case000477{
  private Case000477(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var value=java.util.List.of(new Holder<>(relay(input))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    jakarta.servlet.http.Cookie cookie=new jakarta.servlet.http.Cookie("sid",value);
    response.addCookie(cookie);
    return cookie;
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
