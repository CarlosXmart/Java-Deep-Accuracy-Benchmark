package io.xguardian.javabench.cases.level4;

import java.security.PublicKey;
import java.security.Signature;
import java.util.function.BooleanSupplier;

public class Case000294 {
    public Object run(PublicKey key, byte[] data, byte[] signatureBytes) throws Exception {
        Signature verifier = Signature.getInstance("SHA256withRSA");
        verifier.initVerify(key);
        verifier.update(data);
        if (!verifier.verify(signatureBytes)) throw new SecurityException("invalid signature");
        return Boolean.TRUE;
    }
}
