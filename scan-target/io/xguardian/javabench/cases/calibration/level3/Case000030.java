package io.xguardian.javabench.cases.calibration.level3;

public final class Case000030 {
  private Case000030() {}

  public static Object run(String input) throws Exception {
    var value = relay(input);
    // region:start
    return new ProcessBuilder(java.util.List.of("printf", "%s", value)).start();
    // region:end
  }

  private static <T> T relay(T value) { return value; }
}
