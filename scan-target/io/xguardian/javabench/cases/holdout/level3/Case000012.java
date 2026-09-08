package io.xguardian.javabench.cases.holdout.level3;

import java.nio.file.Files;
import java.nio.file.Path;

public final class Case000012 {
  private Case000012() {}

  public static Object run(String input) throws Exception {
    var source0 = System.getProperty("jdb.input", input);
    var value = relay(source0);
    // region:start
    Path base = Path.of("/srv/data").toAbsolutePath().normalize();
    Path candidate = base.resolve(value).normalize();
    if (!candidate.startsWith(base)) throw new SecurityException("outside base");
    return Files.readString(candidate);
    // region:end
  }

  private static <T> T relay(T value) { return value; }
}
