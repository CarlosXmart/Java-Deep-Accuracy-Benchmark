package io.xguardian.javabench.cases.calibration.level2;

public final class Case000147{
  private Case000147(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var stage1=source0;
    var value=stage1;
    // region:start
    try{return java.nio.file.Files.readString(java.nio.file.Path.of(value));}catch(Exception e){return "operation failed: "+e.getMessage();}
    // region:end
  }
}
