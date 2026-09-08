package io.xguardian.javabench.cases.calibration.level2;

public final class Case000028 {
  private Case000028() {}

  public static Object run(String input) throws Exception {
    var source0 = System.getProperty("jdb.input", input);
    var stage1 = source0;
    var value = stage1;
    // region:start
    return new ProcessBuilder(java.util.List.of("printf", "%s", value)).start();
    // region:end
  }
}
