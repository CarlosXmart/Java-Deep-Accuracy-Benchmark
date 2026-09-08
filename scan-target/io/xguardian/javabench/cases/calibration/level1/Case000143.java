package io.xguardian.javabench.cases.calibration.level1;

public final class Case000143{
  private Case000143(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=source0;
    // region:start
    try{return java.nio.file.Files.readString(java.nio.file.Path.of(value));}catch(Exception e){return "operation failed: "+e.getMessage();}
    // region:end
  }
}
