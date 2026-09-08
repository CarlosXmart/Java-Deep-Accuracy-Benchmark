package io.xguardian.javabench.cases.calibration.level3;

import jakarta.servlet.http.HttpServletResponse;

public final class Case000050 {
  private Case000050() {}

  public static Object run(HttpServletResponse response, String input) throws Exception {
    var value = relay(input);
    // region:start
    response.getWriter().write("<div>" + org.apache.commons.text.StringEscapeUtils.escapeHtml4(value) + "</div>");
    return null;
    // region:end
  }

  private static <T> T relay(T value) { return value; }
}
