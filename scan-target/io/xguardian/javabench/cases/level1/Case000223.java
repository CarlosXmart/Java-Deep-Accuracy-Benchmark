package io.xguardian.javabench.cases.level1;

import java.util.Map;
import java.util.function.Supplier;
import javax.crypto.Cipher;

public class Case000223 {
    public Object run() throws Exception {
        return Cipher.getInstance("RC4");
    }
}
