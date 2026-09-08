package io.xguardian.javabench.cases.calibration.level2;

public final class Case000085{
  private Case000085(){}

  public static Object run(javax.naming.directory.DirContext context,String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    String filter="(&(objectClass=person)(uid="+value+"))";
    return context.search("ou=people",filter,new javax.naming.directory.SearchControls());
    // region:end
  }
}
