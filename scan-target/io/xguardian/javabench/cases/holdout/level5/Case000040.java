package io.xguardian.javabench.cases.holdout.level5;

public final class Case000040 {
  private Case000040() {}

  public static Object run(String input) throws Exception {
    var source0 = System.getProperty("jdb.input", input);
    var value = java.util.List.of(new Holder<>(relay(source0))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    return new ProcessBuilder(java.util.List.of("printf", "%s", value)).start();
    // region:end
  }

  private static <T> T relay(T value) { return value; }

  private record Holder<T>(T value) {}
}
