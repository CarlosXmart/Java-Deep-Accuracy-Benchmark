package io.xguardian.javabench.cases.calibration.level4;

public final class Case000093{
  private Case000093(){}

  public static Object run(javax.naming.directory.DirContext context,String input)throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    String filter="(&(objectClass=person)(uid="+value+"))";
    return context.search("ou=people",filter,new javax.naming.directory.SearchControls());
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
