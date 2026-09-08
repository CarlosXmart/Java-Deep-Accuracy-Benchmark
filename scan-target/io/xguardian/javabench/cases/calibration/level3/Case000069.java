package io.xguardian.javabench.cases.calibration.level3;

public final class Case000069{
  private Case000069(){}

  public static Object run(java.sql.Connection connection,String input) throws Exception{
    var value=relay(input);
    // region:start
    java.sql.Statement st=connection.createStatement();
    return st.executeQuery("SELECT id FROM users WHERE name='" + value + "'");
    // region:end
  }

  private static <T> T relay(T value){return value;}
}
