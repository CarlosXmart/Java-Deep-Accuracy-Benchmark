package io.xguardian.javabench.cases.calibration.level1;

import jakarta.servlet.http.HttpServletResponse;

public final class Case000044 {
  private Case000044() {}

  public static Object run(HttpServletResponse response, String input) throws Exception {
    var source0 = System.getProperty("jdb.input", input);
    var value = source0;
    // region:start
    response.getWriter().write("<div>" + org.apache.commons.text.StringEscapeUtils.escapeHtml4(value) + "</div>");
    return null;
    // region:end
  }
}
