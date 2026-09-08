package io.xguardian.javabench.cases.holdout.level4;

public final class Case000136{
  private Case000136(){}

  public static Object run(jakarta.servlet.http.HttpServletResponse response,String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=new Holder<>(relay(source0)).value();
    // region:start
    if(value.indexOf('\r')>=0||value.indexOf('\n')>=0)throw new IllegalArgumentException("invalid header");
    response.setHeader("X-Display-Name",value);
    return null;
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
