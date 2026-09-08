package io.xguardian.javabench.cases.calibration.level1;

public final class Case000081{
  private Case000081(){}

  public static Object run(javax.naming.directory.DirContext context,String input)throws Exception{
    var value=input;
    // region:start
    String filter="(&(objectClass=person)(uid="+value+"))";
    return context.search("ou=people",filter,new javax.naming.directory.SearchControls());
    // region:end
  }
}
