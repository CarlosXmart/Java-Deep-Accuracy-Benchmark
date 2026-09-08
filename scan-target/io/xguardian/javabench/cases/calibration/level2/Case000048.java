package io.xguardian.javabench.cases.calibration.level2;

import jakarta.servlet.http.HttpServletResponse;

public final class Case000048 {
  private Case000048() {}

  public static Object run(HttpServletResponse response, String input) throws Exception {
    var source0 = System.getProperty("jdb.input", input);
    var stage1 = source0;
    var value = stage1;
    // region:start
    response.getWriter().write("<div>" + org.apache.commons.text.StringEscapeUtils.escapeHtml4(value) + "</div>");
    return null;
    // region:end
  }
}
