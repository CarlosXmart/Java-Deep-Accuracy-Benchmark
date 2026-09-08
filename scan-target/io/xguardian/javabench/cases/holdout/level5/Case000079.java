package io.xguardian.javabench.cases.holdout.level5;

public final class Case000079{
  private Case000079(){}

  public static Object run(java.sql.Connection connection,String input) throws Exception{
    var source0=System.getProperty("jdb.input", input);
    var value=java.util.List.of(new Holder<>(relay(source0))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    java.sql.Statement st=connection.createStatement();
    return st.executeQuery("SELECT id FROM users WHERE name='" + value + "'");
    // region:end
  }

  private static <T> T relay(T value){return value;}

  private record Holder<T>(T value){}
}
