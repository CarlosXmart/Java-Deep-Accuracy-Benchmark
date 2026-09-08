package io.xguardian.javabench.cases.calibration.level5;

public final class Case000077{
  private Case000077(){}

  public static Object run(java.sql.Connection connection,String input) throws Exception{
    var value=java.util.List.of(new Holder<>(relay(input))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    java.sql.Statement st=connection.createStatement();
    return st.executeQuery("SELECT id FROM users WHERE name='" + value + "'");
    // region:end
  }

  private static <T> T relay(T value){return value;}

  private record Holder<T>(T value){}
}
