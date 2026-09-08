package io.xguardian.javabench.cases.calibration.level4;

public final class Case000313{
  private Case000313(){}

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
