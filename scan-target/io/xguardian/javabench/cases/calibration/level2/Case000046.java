package io.xguardian.javabench.cases.calibration.level2;

import jakarta.servlet.http.HttpServletResponse;

public final class Case000046 {
  private Case000046() {}

  public static Object run(HttpServletResponse response, String input) throws Exception {
    var stage1 = input;
    var value = stage1;
    // region:start
    response.getWriter().write("<div>" + org.apache.commons.text.StringEscapeUtils.escapeHtml4(value) + "</div>");
    return null;
    // region:end
  }
}
