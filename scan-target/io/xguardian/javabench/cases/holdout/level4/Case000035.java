package io.xguardian.javabench.cases.holdout.level4;

public final class Case000035 {
  private Case000035() {}

  public static Object run(String input) throws Exception {
    var source0 = System.getProperty("jdb.input", input);
    var value = new Holder<>(relay(source0)).value();
    // region:start
    return new ProcessBuilder("sh", "-c", "echo " + value).start();
    // region:end
  }

  private static <T> T relay(T value) { return value; }

  private record Holder<T>(T value) {}
}
