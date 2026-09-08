package io.xguardian.javabench.cases.calibration.level4;

public final class Case000034 {
  private Case000034() {}

  public static Object run(String input) throws Exception {
    var value = new Holder<>(relay(input)).value();
    // region:start
    return new ProcessBuilder(java.util.List.of("printf", "%s", value)).start();
    // region:end
  }

  private static <T> T relay(T value) { return value; }

  private record Holder<T>(T value) {}
}
