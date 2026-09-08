package io.xguardian.javabench.cases.calibration.level1;

public final class Case000024 {
  private Case000024() {}

  public static Object run(String input) throws Exception {
    var source0 = System.getProperty("jdb.input", input);
    var value = source0;
    // region:start
    return new ProcessBuilder(java.util.List.of("printf", "%s", value)).start();
    // region:end
  }
}
