package io.xguardian.javabench.cases.calibration.level2;

public final class Case000086{
  private Case000086(){}

  public static Object run(javax.naming.directory.DirContext context,String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    String filter="(&(objectClass=person)(uid={0}))";
    return context.search("ou=people",filter,new Object[]{value},new javax.naming.directory.SearchControls());
    // region:end
  }
}
