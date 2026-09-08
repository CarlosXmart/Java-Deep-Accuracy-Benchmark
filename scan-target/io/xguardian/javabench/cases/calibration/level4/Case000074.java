package io.xguardian.javabench.cases.calibration.level4;

public final class Case000074{
  private Case000074(){}

  public static Object run(java.sql.Connection connection,String input) throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    java.sql.PreparedStatement ps=connection.prepareStatement("SELECT id FROM users WHERE name=?");
    ps.setString(1,value);
    return ps.executeQuery();
    // region:end
  }

  private static <T> T relay(T value){return value;}

  private record Holder<T>(T value){}
}
