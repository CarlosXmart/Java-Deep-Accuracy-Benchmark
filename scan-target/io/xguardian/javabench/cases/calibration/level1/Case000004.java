package io.xguardian.javabench.cases.calibration.level1;

import java.nio.file.Files;
import java.nio.file.Path;

public final class Case000004 {
  private Case000004() {}

  public static Object run(String input) throws Exception {
    var source0 = System.getProperty("jdb.input", input);
    var value = source0;
    // region:start
    Path base = Path.of("/srv/data").toAbsolutePath().normalize();
    Path candidate = base.resolve(value).normalize();
    if (!candidate.startsWith(base)) throw new SecurityException("outside base");
    return Files.readString(candidate);
    // region:end
  }
}
