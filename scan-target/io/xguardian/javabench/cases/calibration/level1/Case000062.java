package io.xguardian.javabench.cases.calibration.level1;

public final class Case000062{
  private Case000062(){}

  public static Object run(java.sql.Connection connection,String input) throws Exception{
    var value=input;
    // region:start
    java.sql.PreparedStatement ps=connection.prepareStatement("SELECT id FROM users WHERE name=?");
    ps.setString(1,value);
    return ps.executeQuery();
    // region:end
  }
}
