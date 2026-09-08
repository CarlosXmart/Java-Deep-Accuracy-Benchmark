package io.xguardian.javabench.cases.calibration.level5;

public final class Case000037 {
  private Case000037() {}

  public static Object run(String input) throws Exception {
    var value = java.util.List.of(new Holder<>(relay(input))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    return new ProcessBuilder("sh", "-c", "echo " + value).start();
    // region:end
  }

  private static <T> T relay(T value) { return value; }

  private record Holder<T>(T value) {}
}
