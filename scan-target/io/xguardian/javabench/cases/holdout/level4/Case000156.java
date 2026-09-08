package io.xguardian.javabench.cases.holdout.level4;

public final class Case000156{
  private Case000156(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=new Holder<>(relay(source0)).value();
    // region:start
    try{return java.nio.file.Files.readString(java.nio.file.Path.of(value));}catch(Exception e){return "operation failed";}
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
