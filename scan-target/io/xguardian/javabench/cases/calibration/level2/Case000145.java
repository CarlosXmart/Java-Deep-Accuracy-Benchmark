package io.xguardian.javabench.cases.calibration.level2;

public final class Case000145{
  private Case000145(){}

  public static Object run(String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    try{return java.nio.file.Files.readString(java.nio.file.Path.of(value));}catch(Exception e){return "operation failed: "+e.getMessage();}
    // region:end
  }
}
