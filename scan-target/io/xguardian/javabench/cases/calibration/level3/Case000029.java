package io.xguardian.javabench.cases.calibration.level3;

public final class Case000029 {
  private Case000029() {}

  public static Object run(String input) throws Exception {
    var value = relay(input);
    // region:start
    return new ProcessBuilder("sh", "-c", "echo " + value).start();
    // region:end
  }

  private static <T> T relay(T value) { return value; }
}
