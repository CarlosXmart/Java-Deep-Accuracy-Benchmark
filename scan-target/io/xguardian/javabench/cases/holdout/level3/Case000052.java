package io.xguardian.javabench.cases.holdout.level3;

import jakarta.servlet.http.HttpServletResponse;

public final class Case000052 {
  private Case000052() {}

  public static Object run(HttpServletResponse response, String input) throws Exception {
    var source0 = System.getProperty("jdb.input", input);
    var value = relay(source0);
    // region:start
    response.getWriter().write("<div>" + org.apache.commons.text.StringEscapeUtils.escapeHtml4(value) + "</div>");
    return null;
    // region:end
  }

  private static <T> T relay(T value) { return value; }
}
