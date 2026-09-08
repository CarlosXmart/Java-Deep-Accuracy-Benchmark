package io.xguardian.javabench.cases.holdout.level3;

public final class Case000092{
  private Case000092(){}

  public static Object run(javax.naming.directory.DirContext context,String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=relay(source0);
    // region:start
    String filter="(&(objectClass=person)(uid={0}))";
    return context.search("ou=people",filter,new Object[]{value},new javax.naming.directory.SearchControls());
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
