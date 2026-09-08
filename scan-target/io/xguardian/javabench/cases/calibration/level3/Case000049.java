package io.xguardian.javabench.cases.calibration.level3;

import jakarta.servlet.http.HttpServletResponse;

public final class Case000049 {
  private Case000049() {}

  public static Object run(HttpServletResponse response, String input) throws Exception {
    var value = relay(input);
    // region:start
    response.getWriter().write("<div>" + value + "</div>");
    return null;
    // region:end
  }

  private static <T> T relay(T value) { return value; }
}
