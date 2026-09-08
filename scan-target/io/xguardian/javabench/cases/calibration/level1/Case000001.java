package io.xguardian.javabench.cases.calibration.level1;

import java.nio.file.Files;
import java.nio.file.Path;

public final class Case000001 {
  private Case000001() {}

  public static Object run(String input) throws Exception {
    var value = input;
    // region:start
    Path base = Path.of("/srv/data").toAbsolutePath().normalize();
    Path candidate = base.resolve(value).normalize();
    return Files.readString(candidate);
    // region:end
  }
}
