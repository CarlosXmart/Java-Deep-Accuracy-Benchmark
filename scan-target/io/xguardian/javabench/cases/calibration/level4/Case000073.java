package io.xguardian.javabench.cases.calibration.level4;

public final class Case000073{
  private Case000073(){}

  public static Object run(java.sql.Connection connection,String input) throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    java.sql.Statement st=connection.createStatement();
    return st.executeQuery("SELECT id FROM users WHERE name='" + value + "'");
    // region:end
  }

  private static <T> T relay(T value){return value;}

  private record Holder<T>(T value){}
}
