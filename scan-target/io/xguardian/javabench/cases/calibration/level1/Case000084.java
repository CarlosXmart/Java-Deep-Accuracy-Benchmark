package io.xguardian.javabench.cases.calibration.level1;

public final class Case000084{
  private Case000084(){}

  public static Object run(javax.naming.directory.DirContext context,String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=source0;
    // region:start
    String filter="(&(objectClass=person)(uid={0}))";
    return context.search("ou=people",filter,new Object[]{value},new javax.naming.directory.SearchControls());
    // region:end
  }
}
