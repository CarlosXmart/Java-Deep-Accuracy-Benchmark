package io.xguardian.javabench.cases.holdout.level3;

public final class Case000072{
  private Case000072(){}

  public static Object run(java.sql.Connection connection,String input) throws Exception{
    var source0=System.getProperty("jdb.input", input);
    var value=relay(source0);
    // region:start
    java.sql.PreparedStatement ps=connection.prepareStatement("SELECT id FROM users WHERE name=?");
    ps.setString(1,value);
    return ps.executeQuery();
    // region:end
  }

  private static <T> T relay(T value){return value;}
}
