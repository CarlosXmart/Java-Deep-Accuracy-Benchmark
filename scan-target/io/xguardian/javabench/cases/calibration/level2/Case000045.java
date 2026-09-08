package io.xguardian.javabench.cases.calibration.level2;

import jakarta.servlet.http.HttpServletResponse;

public final class Case000045 {
  private Case000045() {}

  public static Object run(HttpServletResponse response, String input) throws Exception {
    var stage1 = input;
    var value = stage1;
    // region:start
    response.getWriter().write("<div>" + value + "</div>");
    return null;
    // region:end
  }
}
