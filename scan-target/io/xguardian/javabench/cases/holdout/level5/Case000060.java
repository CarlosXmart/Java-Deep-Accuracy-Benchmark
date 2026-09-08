package io.xguardian.javabench.cases.holdout.level5;

import jakarta.servlet.http.HttpServletResponse;

public final class Case000060 {
  private Case000060() {}

  public static Object run(HttpServletResponse response, String input) throws Exception {
    var source0 = System.getProperty("jdb.input", input);
    var value = java.util.List.of(new Holder<>(relay(source0))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    response.getWriter().write("<div>" + org.apache.commons.text.StringEscapeUtils.escapeHtml4(value) + "</div>");
    return null;
    // region:end
  }

  private static <T> T relay(T value) { return value; }

  private record Holder<T>(T value) {}
}
