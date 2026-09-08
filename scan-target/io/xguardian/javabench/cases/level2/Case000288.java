package io.xguardian.javabench.cases.level2;

import java.security.PublicKey;
import java.security.Signature;

public class Case000288 {
    public Object run(PublicKey key, byte[] data, byte[] signatureBytes, String input) throws Exception {
        String value = input == null ? "" : input.trim();
        Signature verifier = Signature.getInstance("SHA256withRSA");
        verifier.initVerify(key);
        verifier.update(data);
        boolean valid = verifier.verify(signatureBytes);
        if (!valid) throw new SecurityException("invalid signature");
        return Boolean.TRUE;
    }
}
