package io.xguardian.javabench.cases.calibration.level3;

public final class Case000310{
  private Case000310(){}

  public static Object run(jakarta.servlet.http.HttpServletRequest input)throws Exception{
    var value=relay(input);
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
}
