package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import javax.crypto.Cipher;

public class Case000235 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("q");
        return Cipher.getInstance("RC4");
    }
}
