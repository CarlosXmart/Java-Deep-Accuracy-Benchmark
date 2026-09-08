package io.xguardian.javabench.cases.holdout.level3;

public final class Case000271{
  private Case000271(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=relay(source0);
    // region:start
    java.util.Random random=new java.util.Random();
    return value+"-"+random.nextInt(1_000_000);
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
