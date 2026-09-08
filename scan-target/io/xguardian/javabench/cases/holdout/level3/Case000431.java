package io.xguardian.javabench.cases.holdout.level3;

public final class Case000431{
  private Case000431(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=relay(source0);
    // region:start
    response.sendRedirect(value);
    return null;
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
