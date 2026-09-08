package org.javadeep.benchmark.cases.level3;

import java.security.PublicKey;
import java.security.Signature;
import java.util.function.BooleanSupplier;

public class Case000291 {
    public Object run(PublicKey key, byte[] data, byte[] signatureBytes) throws Exception {
        verify(key, data, signatureBytes);
        return true;
    }

    private boolean verify(PublicKey key, byte[] data, byte[] signatureBytes) throws Exception {
        Signature verifier = Signature.getInstance("SHA256withRSA");
        verifier.initVerify(key);
        verifier.update(data);
        return verifier.verify(signatureBytes);
    }
}
