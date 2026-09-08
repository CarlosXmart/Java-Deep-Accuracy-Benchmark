package io.xguardian.javabench.cases.calibration.level1;

public final class Case000384{
  private Case000384(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=source0;
    // region:start
    byte[] bytes=java.util.Base64.getDecoder().decode(value);
    try(var in=new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(bytes))){
      in.setObjectInputFilter(java.io.ObjectInputFilter.Config.createFilter("java.base/java.lang.String;!*"));
      return in.readObject();
    }
    // region:end
  }
}
