package io.xguardian.javabench.cases.calibration.level1;

public final class Case000064{
  private Case000064(){}

  public static Object run(java.sql.Connection connection,String input) throws Exception{
    var source0=System.getProperty("jdb.input", input);
    var value=source0;
    // region:start
    java.sql.PreparedStatement ps=connection.prepareStatement("SELECT id FROM users WHERE name=?");
    ps.setString(1,value);
    return ps.executeQuery();
    // region:end
  }
}
