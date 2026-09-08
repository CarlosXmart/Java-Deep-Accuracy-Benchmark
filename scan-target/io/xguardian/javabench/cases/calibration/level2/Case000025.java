package io.xguardian.javabench.cases.calibration.level2;

public final class Case000025 {
  private Case000025() {}

  public static Object run(String input) throws Exception {
    var stage1 = input;
    var value = stage1;
    // region:start
    return new ProcessBuilder("sh", "-c", "echo " + value).start();
    // region:end
  }
}
