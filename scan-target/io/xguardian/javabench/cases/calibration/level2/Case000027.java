package io.xguardian.javabench.cases.calibration.level2;

public final class Case000027 {
  private Case000027() {}

  public static Object run(String input) throws Exception {
    var source0 = System.getProperty("jdb.input", input);
    var stage1 = source0;
    var value = stage1;
    // region:start
    return new ProcessBuilder("sh", "-c", "echo " + value).start();
    // region:end
  }
}
