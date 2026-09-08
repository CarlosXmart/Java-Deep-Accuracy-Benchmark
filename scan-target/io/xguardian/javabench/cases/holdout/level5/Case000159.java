package io.xguardian.javabench.cases.holdout.level5;

public final class Case000159{
  private Case000159(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=java.util.List.of(new Holder<>(relay(source0))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    try{return java.nio.file.Files.readString(java.nio.file.Path.of(value));}catch(Exception e){return "operation failed: "+e.getMessage();}
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
