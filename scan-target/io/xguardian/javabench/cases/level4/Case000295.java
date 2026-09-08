package io.xguardian.javabench.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.security.PublicKey;
import java.security.Signature;

public class Case000295 {
    public Object run(PublicKey key, byte[] data, byte[] signatureBytes, HttpServletRequest request) throws Exception {
        String value = request.getParameter("q");
        Signature verifier = Signature.getInstance("SHA256withRSA");
        verifier.initVerify(key);
        verifier.update(data);
        verifier.verify(signatureBytes);
        return true;
    }
}
