package io.xguardian.javabench.cases.holdout.level3;

public final class Case000032 {
  private Case000032() {}

  public static Object run(String input) throws Exception {
    var source0 = System.getProperty("jdb.input", input);
    var value = relay(source0);
    // region:start
    return new ProcessBuilder(java.util.List.of("printf", "%s", value)).start();
    // region:end
  }

  private static <T> T relay(T value) { return value; }
}
