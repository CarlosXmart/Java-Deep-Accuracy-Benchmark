package io.xguardian.javabench.cases.calibration.level3;

public final class Case000289{
  private Case000289(){}

  public static Object run(java.security.PublicKey key,String input)throws Exception{
    var value=relay(input);
    // region:start
    byte[] sigBytes=java.util.Base64.getDecoder().decode(value);
    java.security.Signature verifier=java.security.Signature.getInstance("SHA256withRSA");
    verifier.initVerify(key);verifier.update("payload".getBytes(java.nio.charset.StandardCharsets.UTF_8));
    verifier.verify(sigBytes);
    return Boolean.TRUE;
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
