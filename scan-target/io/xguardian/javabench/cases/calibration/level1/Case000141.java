package io.xguardian.javabench.cases.calibration.level1;

public final class Case000141{
  private Case000141(){}

  public static Object run(String input)throws Exception{
    var value=input;
    // region:start
    try{return java.nio.file.Files.readString(java.nio.file.Path.of(value));}catch(Exception e){return "operation failed: "+e.getMessage();}
    // region:end
  }
}
