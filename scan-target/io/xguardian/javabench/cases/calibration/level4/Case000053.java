package io.xguardian.javabench.cases.calibration.level4;

import jakarta.servlet.http.HttpServletResponse;

public final class Case000053 {
  private Case000053() {}

  public static Object run(HttpServletResponse response, String input) throws Exception {
    var value = new Holder<>(relay(input)).value();
    // region:start
    response.getWriter().write("<div>" + value + "</div>");
    return null;
    // region:end
  }

  private static <T> T relay(T value) { return value; }

  private record Holder<T>(T value) {}
}
