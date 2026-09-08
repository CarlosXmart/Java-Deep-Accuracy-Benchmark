package io.xguardian.javabench.cases.holdout.level4;

public final class Case000355{
  private Case000355(){}

  public static Object run(jakarta.servlet.http.Part input)throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    String name=value.getSubmittedFileName();
    java.nio.file.Path target=java.nio.file.Path.of("/var/www/uploads").resolve(name);
    try(var in=value.getInputStream()){java.nio.file.Files.copy(in,target,java.nio.file.StandardCopyOption.REPLACE_EXISTING);}
    return target;
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
