package io.xguardian.javabench.cases.calibration.level2;

public final class Case000067{
  private Case000067(){}

  public static Object run(java.sql.Connection connection,String input) throws Exception{
    var source0=System.getProperty("jdb.input", input);
    var stage1=source0;
    var value=stage1;
    // region:start
    java.sql.Statement st=connection.createStatement();
    return st.executeQuery("SELECT id FROM users WHERE name='" + value + "'");
    // region:end
  }
}
