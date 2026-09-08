package io.xguardian.javabench.cases.calibration.level2;

public final class Case000267{
  private Case000267(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var stage1=source0;
    var value=stage1;
    // region:start
    java.util.Random random=new java.util.Random();
    return value+"-"+random.nextInt(1_000_000);
    // region:end
  }
}
