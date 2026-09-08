package io.xguardian.javabench.cases.calibration.level1;

public final class Case000061{
  private Case000061(){}

  public static Object run(java.sql.Connection connection,String input) throws Exception{
    var value=input;
    // region:start
    java.sql.Statement st=connection.createStatement();
    return st.executeQuery("SELECT id FROM users WHERE name='" + value + "'");
    // region:end
  }
}
