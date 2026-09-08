package io.xguardian.javabench.cases.calibration.level1;

public final class Case000022 {
  private Case000022() {}

  public static Object run(String input) throws Exception {
    var value = input;
    // region:start
    return new ProcessBuilder(java.util.List.of("printf", "%s", value)).start();
    // region:end
  }
}
