package io.xguardian.javabench.cases.calibration.level1;

public final class Case000023 {
  private Case000023() {}

  public static Object run(String input) throws Exception {
    var source0 = System.getProperty("jdb.input", input);
    var value = source0;
    // region:start
    return new ProcessBuilder("sh", "-c", "echo " + value).start();
    // region:end
  }
}
