package io.xguardian.javabench.cases.holdout.level3;

public final class Case000152{
  private Case000152(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=relay(source0);
    // region:start
    try{return java.nio.file.Files.readString(java.nio.file.Path.of(value));}catch(Exception e){return "operation failed";}
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
