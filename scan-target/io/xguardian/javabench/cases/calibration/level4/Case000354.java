package io.xguardian.javabench.cases.calibration.level4;

public final class Case000354{
  private Case000354(){}

  public static Object run(jakarta.servlet.http.Part input)throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    String name=java.nio.file.Path.of(value.getSubmittedFileName()).getFileName().toString();
    if(!name.toLowerCase(java.util.Locale.ROOT).endsWith(".txt"))throw new SecurityException("type");
    java.nio.file.Path base=java.nio.file.Path.of("/srv/benchmark-uploads");
    java.nio.file.Path target=base.resolve(java.util.UUID.randomUUID()+".txt");
    try(var in=value.getInputStream()){java.nio.file.Files.copy(in,target,java.nio.file.StandardCopyOption.REPLACE_EXISTING);}
    return target;
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
