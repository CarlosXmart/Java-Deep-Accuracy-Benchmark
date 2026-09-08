package io.xguardian.javabench.cases.calibration.level3;

public final class Case000149{
  private Case000149(){}

  public static Object run(String input)throws Exception{
    var value=relay(input);
    // region:start
    try{return java.nio.file.Files.readString(java.nio.file.Path.of(value));}catch(Exception e){return "operation failed: "+e.getMessage();}
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
