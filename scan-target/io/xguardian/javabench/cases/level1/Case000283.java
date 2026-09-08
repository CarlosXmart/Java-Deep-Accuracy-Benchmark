package io.xguardian.javabench.cases.level1;

import java.security.PublicKey;
import java.security.Signature;

public class Case000283 {
    public Object run(PublicKey key, byte[] data, byte[] signatureBytes, String input) throws Exception {
        Signature verifier = Signature.getInstance("SHA256withRSA");
        verifier.initVerify(key);
        verifier.update(data);
        verifier.verify(signatureBytes);
        return true;
    }
}
