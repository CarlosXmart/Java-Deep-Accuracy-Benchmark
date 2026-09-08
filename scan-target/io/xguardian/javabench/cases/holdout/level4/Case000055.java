package io.xguardian.javabench.cases.holdout.level4;

import jakarta.servlet.http.HttpServletResponse;

public final class Case000055 {
  private Case000055() {}

  public static Object run(HttpServletResponse response, String input) throws Exception {
    var source0 = System.getProperty("jdb.input", input);
    var value = new Holder<>(relay(source0)).value();
    // region:start
    response.getWriter().write("<div>" + value + "</div>");
    return null;
    // region:end
  }

  private static <T> T relay(T value) { return value; }

  private record Holder<T>(T value) {}
}
