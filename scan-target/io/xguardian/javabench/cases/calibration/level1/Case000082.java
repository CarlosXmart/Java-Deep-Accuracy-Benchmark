package io.xguardian.javabench.cases.calibration.level1;

public final class Case000082{
  private Case000082(){}

  public static Object run(javax.naming.directory.DirContext context,String input)throws Exception{
    var value=input;
    // region:start
    String filter="(&(objectClass=person)(uid={0}))";
    return context.search("ou=people",filter,new Object[]{value},new javax.naming.directory.SearchControls());
    // region:end
  }
}
