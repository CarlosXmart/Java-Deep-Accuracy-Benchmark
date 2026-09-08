package io.xguardian.javabench.cases.calibration.level3;

public final class Case000089{
  private Case000089(){}

  public static Object run(javax.naming.directory.DirContext context,String input)throws Exception{
    var value=relay(input);
    // region:start
    String filter="(&(objectClass=person)(uid="+value+"))";
    return context.search("ou=people",filter,new javax.naming.directory.SearchControls());
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
