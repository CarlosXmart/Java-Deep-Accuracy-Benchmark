package io.xguardian.javabench.cases.holdout.level5;

public final class Case000319{
  private Case000319(){}

  public static Object run(jakarta.servlet.http.HttpServletRequest input)throws Exception{
    var value=java.util.List.of(new Holder<>(relay(input))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    String email=value.getParameter("email");
    System.setProperty("jdb.account.email",email==null?"":email);
    return email;
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
