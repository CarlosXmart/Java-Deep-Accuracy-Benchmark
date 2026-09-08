package io.xguardian.javabench.cases.calibration.level2;

public final class Case000026 {
  private Case000026() {}

  public static Object run(String input) throws Exception {
    var stage1 = input;
    var value = stage1;
    // region:start
    return new ProcessBuilder(java.util.List.of("printf", "%s", value)).start();
    // region:end
  }
}
