package io.xguardian.javabench.cases.calibration.level5;

public final class Case000097{
  private Case000097(){}

  public static Object run(javax.naming.directory.DirContext context,String input)throws Exception{
    var value=java.util.List.of(new Holder<>(relay(input))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    String filter="(&(objectClass=person)(uid="+value+"))";
    return context.search("ou=people",filter,new javax.naming.directory.SearchControls());
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
