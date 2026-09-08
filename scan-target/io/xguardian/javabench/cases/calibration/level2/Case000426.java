package io.xguardian.javabench.cases.calibration.level2;

public final class Case000426{
  private Case000426(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    java.net.URI target=java.net.URI.create(value);
    if(target.isAbsolute()||target.getHost()!=null||!target.getPath().startsWith("/"))throw new SecurityException("redirect");
    response.sendRedirect(target.toString());
    return null;
    // region:end
  }
}
