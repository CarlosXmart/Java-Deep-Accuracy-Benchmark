package io.xguardian.javabench.cases.calibration.level4;

public final class Case000094{
  private Case000094(){}

  public static Object run(javax.naming.directory.DirContext context,String input)throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    String filter="(&(objectClass=person)(uid={0}))";
    return context.search("ou=people",filter,new Object[]{value},new javax.naming.directory.SearchControls());
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
