package io.xguardian.javabench.cases.calibration.level2;

public final class Case000348{
  private Case000348(){}

  public static Object run(jakarta.servlet.http.Part input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    String name=java.nio.file.Path.of(value.getSubmittedFileName()).getFileName().toString();
    if(!name.toLowerCase(java.util.Locale.ROOT).endsWith(".txt"))throw new SecurityException("type");
    java.nio.file.Path base=java.nio.file.Path.of("/srv/benchmark-uploads");
    java.nio.file.Path target=base.resolve(java.util.UUID.randomUUID()+".txt");
    try(var in=value.getInputStream()){java.nio.file.Files.copy(in,target,java.nio.file.StandardCopyOption.REPLACE_EXISTING);}
    return target;
    // region:end
  }
}
