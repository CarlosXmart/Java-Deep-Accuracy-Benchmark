package io.xguardian.javabench.cases.holdout.level3;

public final class Case000071{
  private Case000071(){}

  public static Object run(java.sql.Connection connection,String input) throws Exception{
    var source0=System.getProperty("jdb.input", input);
    var value=relay(source0);
    // region:start
    java.sql.Statement st=connection.createStatement();
    return st.executeQuery("SELECT id FROM users WHERE name='" + value + "'");
    // region:end
  }

  private static <T> T relay(T value){return value;}
}
