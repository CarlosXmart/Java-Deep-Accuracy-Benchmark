package io.xguardian.javabench.cases.holdout.level5;

import java.nio.file.Files;
import java.nio.file.Path;

public final class Case000019 {
  private Case000019() {}

  public static Object run(String input) throws Exception {
    var source0 = System.getProperty("jdb.input", input);
    var value = java.util.List.of(new Holder<>(relay(source0))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    Path base = Path.of("/srv/data").toAbsolutePath().normalize();
    Path candidate = base.resolve(value).normalize();
    return Files.readString(candidate);
    // region:end
  }

  private static <T> T relay(T value) { return value; }

  private record Holder<T>(T value) {}
}
