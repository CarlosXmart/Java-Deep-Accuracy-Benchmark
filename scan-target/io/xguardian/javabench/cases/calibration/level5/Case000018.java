package io.xguardian.javabench.cases.calibration.level5;

import java.nio.file.Files;
import java.nio.file.Path;

public final class Case000018 {
  private Case000018() {}

  public static Object run(String input) throws Exception {
    var value = java.util.List.of(new Holder<>(relay(input))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    Path base = Path.of("/srv/data").toAbsolutePath().normalize();
    Path candidate = base.resolve(value).normalize();
    if (!candidate.startsWith(base)) throw new SecurityException("outside base");
    return Files.readString(candidate);
    // region:end
  }

  private static <T> T relay(T value) { return value; }

  private record Holder<T>(T value) {}
}
