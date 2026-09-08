package io.xguardian.javabench.cases.calibration.level1;

import jakarta.servlet.http.HttpServletResponse;

public final class Case000041 {
  private Case000041() {}

  public static Object run(HttpServletResponse response, String input) throws Exception {
    var value = input;
    // region:start
    response.getWriter().write("<div>" + value + "</div>");
    return null;
    // region:end
  }
}
