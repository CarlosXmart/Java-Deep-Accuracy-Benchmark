package io.xguardian.javabench.cases.level3;

import java.security.PublicKey;
import java.security.Signature;

public class Case000290 {
    public Object run(PublicKey key, byte[] data, byte[] signatureBytes, String input) throws Exception {
        String value = relay(input);
        Signature verifier = Signature.getInstance("SHA256withRSA");
        verifier.initVerify(key);
        verifier.update(data);
        boolean valid = verifier.verify(signatureBytes);
        return valid;
    }

    private String relay(String value) {
        return value;
    }
}
