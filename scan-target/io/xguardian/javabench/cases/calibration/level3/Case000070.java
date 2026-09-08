package io.xguardian.javabench.cases.calibration.level3;

public final class Case000070{
  private Case000070(){}

  public static Object run(java.sql.Connection connection,String input) throws Exception{
    var value=relay(input);
    // region:start
    java.sql.PreparedStatement ps=connection.prepareStatement("SELECT id FROM users WHERE name=?");
    ps.setString(1,value);
    return ps.executeQuery();
    // region:end
  }

  private static <T> T relay(T value){return value;}
}
