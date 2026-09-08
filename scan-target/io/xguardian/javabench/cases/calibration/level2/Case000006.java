package io.xguardian.javabench.cases.calibration.level2;

import java.nio.file.Files;
import java.nio.file.Path;

public final class Case000006 {
  private Case000006() {}

  public static Object run(String input) throws Exception {
    var stage1 = input;
    var value = stage1;
    // region:start
    Path base = Path.of("/srv/data").toAbsolutePath().normalize();
    Path candidate = base.resolve(value).normalize();
    if (!candidate.startsWith(base)) throw new SecurityException("outside base");
    return Files.readString(candidate);
    // region:end
  }
}
