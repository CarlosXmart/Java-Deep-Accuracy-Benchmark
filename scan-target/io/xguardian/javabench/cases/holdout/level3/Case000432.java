package io.xguardian.javabench.cases.holdout.level3;

public final class Case000432{
  private Case000432(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=relay(source0);
    // region:start
    java.net.URI target=java.net.URI.create(value);
    if(target.isAbsolute()||target.getHost()!=null||!target.getPath().startsWith("/"))throw new SecurityException("redirect");
    response.sendRedirect(target.toString());
    return null;
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
