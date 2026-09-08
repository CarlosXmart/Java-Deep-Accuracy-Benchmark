package io.xguardian.javabench.cases.calibration.level5;

public final class Case000318{
  private Case000318(){}

  public static Object run(jakarta.servlet.http.HttpServletRequest input)throws Exception{
    var value=java.util.List.of(new Holder<>(relay(input))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    String token=value.getHeader("X-CSRF-Token");
    var session=value.getSession(false);
    Object expected=session==null?null:session.getAttribute("csrf");
    if(token==null||expected==null||!java.security.MessageDigest.isEqual(token.getBytes(java.nio.charset.StandardCharsets.UTF_8),expected.toString().getBytes(java.nio.charset.StandardCharsets.UTF_8)))throw new SecurityException("csrf");
    String email=value.getParameter("email");
    System.setProperty("jdb.account.email",email==null?"":email);
    return email;
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
