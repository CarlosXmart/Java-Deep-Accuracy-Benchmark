package io.xguardian.javabench.cases.calibration.level4;

public final class Case000153{
  private Case000153(){}

  public static Object run(String input)throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    try{return java.nio.file.Files.readString(java.nio.file.Path.of(value));}catch(Exception e){return "operation failed: "+e.getMessage();}
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
