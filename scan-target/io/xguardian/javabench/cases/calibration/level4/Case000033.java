package io.xguardian.javabench.cases.calibration.level4;

public final class Case000033 {
  private Case000033() {}

  public static Object run(String input) throws Exception {
    var value = new Holder<>(relay(input)).value();
    // region:start
    return new ProcessBuilder("sh", "-c", "echo " + value).start();
    // region:end
  }

  private static <T> T relay(T value) { return value; }

  private record Holder<T>(T value) {}
}
