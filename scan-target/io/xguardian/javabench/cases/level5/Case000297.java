package io.xguardian.javabench.cases.level5;

import java.security.PublicKey;
import java.security.Signature;

public class Case000297 {
    public Object run(PublicKey key, byte[] data, byte[] signatureBytes, String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        Signature verifier = Signature.getInstance("SHA256withRSA");
        verifier.initVerify(key);
        verifier.update(data);
        return true;
    }
}
