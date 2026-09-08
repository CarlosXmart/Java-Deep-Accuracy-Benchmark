package io.xguardian.javabench.cases.calibration.level2;

public final class Case000146{
  private Case000146(){}

  public static Object run(String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    try{return java.nio.file.Files.readString(java.nio.file.Path.of(value));}catch(Exception e){return "operation failed";}
    // region:end
  }
}
