package org.javadeep.benchmark.cases.level5;

import java.security.PublicKey;
import java.security.Signature;
import java.util.function.BooleanSupplier;

public class Case000297 {
    public Object run(PublicKey key, byte[] data, byte[] signatureBytes) throws Exception {
        Signature verifier = Signature.getInstance("SHA256withRSA");
        verifier.initVerify(key);
        verifier.update(data);
        BooleanSupplier check = () -> {
            try { return verifier.verify(signatureBytes); }
            catch (Exception e) { return false; }
        };
        check.getAsBoolean();
        return true;
    }
}
