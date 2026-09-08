package io.xguardian.javabench.cases.calibration.level2;

public final class Case000066{
  private Case000066(){}

  public static Object run(java.sql.Connection connection,String input) throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    java.sql.PreparedStatement ps=connection.prepareStatement("SELECT id FROM users WHERE name=?");
    ps.setString(1,value);
    return ps.executeQuery();
    // region:end
  }
}
