package io.xguardian.javabench.cases.holdout.level4;

import java.nio.file.Files;
import java.nio.file.Path;

public final class Case000015 {
  private Case000015() {}

  public static Object run(String input) throws Exception {
    var source0 = System.getProperty("jdb.input", input);
    var value = new Holder<>(relay(source0)).value();
    // region:start
    Path base = Path.of("/srv/data").toAbsolutePath().normalize();
    Path candidate = base.resolve(value).normalize();
    return Files.readString(candidate);
    // region:end
  }

  private static <T> T relay(T value) { return value; }

  private record Holder<T>(T value) {}
}
