package io.xguardian.javabench.cases.calibration.level2;

public final class Case000065{
  private Case000065(){}

  public static Object run(java.sql.Connection connection,String input) throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    java.sql.Statement st=connection.createStatement();
    return st.executeQuery("SELECT id FROM users WHERE name='" + value + "'");
    // region:end
  }
}
