package io.xguardian.javabench.cases.calibration.level3;

import java.nio.file.Files;
import java.nio.file.Path;

public final class Case000009 {
  private Case000009() {}

  public static Object run(String input) throws Exception {
    var value = relay(input);
    // region:start
    Path base = Path.of("/srv/data").toAbsolutePath().normalize();
    Path candidate = base.resolve(value).normalize();
    return Files.readString(candidate);
    // region:end
  }

  private static <T> T relay(T value) { return value; }
}
