package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import javax.crypto.Cipher;

public class Case000233 {
    public Object run(HttpServletRequest request) throws Exception {
        String value = request.getParameter("value");
        return Cipher.getInstance("DES/ECB/PKCS5Padding");
    }
}
