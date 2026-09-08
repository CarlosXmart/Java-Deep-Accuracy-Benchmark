package io.xguardian.javabench.cases.calibration.level2;

public final class Case000308{
  private Case000308(){}

  public static Object run(jakarta.servlet.http.HttpServletRequest input)throws Exception{
    var stage1=input;
    var value=stage1;
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
}
