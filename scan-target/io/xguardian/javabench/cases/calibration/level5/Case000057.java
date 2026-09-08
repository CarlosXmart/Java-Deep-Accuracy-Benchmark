package io.xguardian.javabench.cases.calibration.level5;

import jakarta.servlet.http.HttpServletResponse;

public final class Case000057 {
  private Case000057() {}

  public static Object run(HttpServletResponse response, String input) throws Exception {
    var value = java.util.List.of(new Holder<>(relay(input))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    response.getWriter().write("<div>" + value + "</div>");
    return null;
    // region:end
  }

  private static <T> T relay(T value) { return value; }

  private record Holder<T>(T value) {}
}
