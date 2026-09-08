package io.xguardian.javabench.cases.holdout.level3;

public final class Case000352{
  private Case000352(){}

  public static Object run(jakarta.servlet.http.Part input)throws Exception{
    var value=relay(input);
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
}
