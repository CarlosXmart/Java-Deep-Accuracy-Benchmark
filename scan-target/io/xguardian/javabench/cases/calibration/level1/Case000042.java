package io.xguardian.javabench.cases.calibration.level1;

import jakarta.servlet.http.HttpServletResponse;

public final class Case000042 {
  private Case000042() {}

  public static Object run(HttpServletResponse response, String input) throws Exception {
    var value = input;
    // region:start
    response.getWriter().write("<div>" + org.apache.commons.text.StringEscapeUtils.escapeHtml4(value) + "</div>");
    return null;
    // region:end
  }
}
