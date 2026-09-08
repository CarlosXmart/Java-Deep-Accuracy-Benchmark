package io.xguardian.javabench.cases.holdout.level4;

public final class Case000075{
  private Case000075(){}

  public static Object run(java.sql.Connection connection,String input) throws Exception{
    var source0=System.getProperty("jdb.input", input);
    var value=new Holder<>(relay(source0)).value();
    // region:start
    java.sql.Statement st=connection.createStatement();
    return st.executeQuery("SELECT id FROM users WHERE name='" + value + "'");
    // region:end
  }

  private static <T> T relay(T value){return value;}

  private record Holder<T>(T value){}
}
