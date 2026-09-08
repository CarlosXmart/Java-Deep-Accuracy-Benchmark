package io.xguardian.javabench.cases.calibration.level1;

public final class Case000021 {
  private Case000021() {}

  public static Object run(String input) throws Exception {
    var value = input;
    // region:start
    return new ProcessBuilder("sh", "-c", "echo " + value).start();
    // region:end
  }
}
