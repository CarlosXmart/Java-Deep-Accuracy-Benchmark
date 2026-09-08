package io.xguardian.javabench.cases.calibration.level2;

import java.nio.file.Files;
import java.nio.file.Path;

public final class Case000007 {
  private Case000007() {}

  public static Object run(String input) throws Exception {
    var source0 = System.getProperty("jdb.input", input);
    var stage1 = source0;
    var value = stage1;
    // region:start
    Path base = Path.of("/srv/data").toAbsolutePath().normalize();
    Path candidate = base.resolve(value).normalize();
    return Files.readString(candidate);
    // region:end
  }
}
