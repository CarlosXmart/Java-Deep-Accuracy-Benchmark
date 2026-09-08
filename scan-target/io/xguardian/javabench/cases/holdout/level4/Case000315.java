package io.xguardian.javabench.cases.holdout.level4;

public final class Case000315{
  private Case000315(){}

  public static Object run(jakarta.servlet.http.HttpServletRequest input)throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    String email=value.getParameter("email");
    System.setProperty("jdb.account.email",email==null?"":email);
    return email;
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
