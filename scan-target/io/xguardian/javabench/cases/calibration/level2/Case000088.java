package io.xguardian.javabench.cases.calibration.level2;

public final class Case000088{
  private Case000088(){}

  public static Object run(javax.naming.directory.DirContext context,String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var stage1=source0;
    var value=stage1;
    // region:start
    String filter="(&(objectClass=person)(uid={0}))";
    return context.search("ou=people",filter,new Object[]{value},new javax.naming.directory.SearchControls());
    // region:end
  }
}
