package io.xguardian.javabench.cases.calibration.level2;

public final class Case000068{
  private Case000068(){}

  public static Object run(java.sql.Connection connection,String input) throws Exception{
    var source0=System.getProperty("jdb.input", input);
    var stage1=source0;
    var value=stage1;
    // region:start
    java.sql.PreparedStatement ps=connection.prepareStatement("SELECT id FROM users WHERE name=?");
    ps.setString(1,value);
    return ps.executeQuery();
    // region:end
  }
}
