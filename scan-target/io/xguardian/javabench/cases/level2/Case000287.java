package io.xguardian.javabench.cases.level2;

import java.security.PublicKey;
import java.security.Signature;
import java.util.function.BooleanSupplier;

public class Case000287 {
    public Object run(PublicKey key, byte[] data, byte[] signatureBytes) throws Exception {
        Signature verifier = Signature.getInstance("SHA256withRSA");
        verifier.initVerify(key);
        verifier.update(data);
        verifier.verify(signatureBytes);
        return true;
    }
}
