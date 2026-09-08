package io.xguardian.javabench.support;

import java.net.URI;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Set;

public final class BenchSupport {
    private BenchSupport() {}

    public static String htmlEscape(String value) {
        if (value == null) return "";
        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#x27;");
    }

    public static boolean simpleToken(String value) {
        return value != null && value.matches("[A-Za-z0-9._-]{1,64}");
    }

    public static boolean headerValue(String value) {
        return value != null && !value.contains("\r") && !value.contains("\n");
    }

    public static String basename(String value) {
        if (value == null || value.isBlank()) return "upload.bin";
        return Path.of(value).getFileName().toString();
    }

    public static boolean allowedUploadName(String value) {
        String lower = basename(value).toLowerCase(Locale.ROOT);
        return lower.endsWith(".txt") || lower.endsWith(".png") || lower.endsWith(".jpg") || lower.endsWith(".jpeg");
    }

    public static boolean allowedHost(URI uri) {
        if (uri == null || uri.getHost() == null) return false;
        return "https".equalsIgnoreCase(uri.getScheme())
            && Set.of("api.example.test", "cdn.example.test").contains(uri.getHost().toLowerCase(Locale.ROOT));
    }

    public static boolean localRedirect(String value) {
        return value != null && value.startsWith("/app/") && !value.startsWith("//") && !value.contains("\r") && !value.contains("\n");
    }

    public static String ldapFilterEncode(String value) {
        if (value == null) return "";
        StringBuilder out = new StringBuilder();
        for (char ch : value.toCharArray()) {
            switch (ch) {
                case '*': out.append("\\2a"); break;
                case '(': out.append("\\28"); break;
                case ')': out.append("\\29"); break;
                case '\\': out.append("\\5c"); break;
                case '\u0000': out.append("\\00"); break;
                default: out.append(ch);
            }
        }
        return out.toString();
    }

    public static boolean sameUser(String authenticatedUser, String requestedUser) {
        return authenticatedUser != null && authenticatedUser.equals(requestedUser);
    }
}
