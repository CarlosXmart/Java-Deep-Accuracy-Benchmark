package io.xguardian.javabench.cases.holdout.level4;

public final class Case000436{
  private Case000436(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=new Holder<>(relay(source0)).value();
    // region:start
    java.net.URI target=java.net.URI.create(value);
    if(target.isAbsolute()||target.getHost()!=null||!target.getPath().startsWith("/"))throw new SecurityException("redirect");
    response.sendRedirect(target.toString());
    return null;
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
