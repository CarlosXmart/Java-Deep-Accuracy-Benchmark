package io.xguardian.javabench.cases.calibration.level3;

public final class Case000090{
  private Case000090(){}

  public static Object run(javax.naming.directory.DirContext context,String input)throws Exception{
    var value=relay(input);
    // region:start
    String filter="(&(objectClass=person)(uid={0}))";
    return context.search("ou=people",filter,new Object[]{value},new javax.naming.directory.SearchControls());
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
