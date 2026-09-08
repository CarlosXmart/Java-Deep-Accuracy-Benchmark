package io.xguardian.javabench.cases.calibration.level1;

public final class Case000263{
  private Case000263(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=source0;
    // region:start
    java.util.Random random=new java.util.Random();
    return value+"-"+random.nextInt(1_000_000);
    // region:end
  }
}
