package io.xguardian.javabench.cases.calibration.level1;

public final class Case000281{
  private Case000281(){}

  public static Object run(java.security.PublicKey key,String input)throws Exception{
    var value=input;
    // region:start
    byte[] sigBytes=java.util.Base64.getDecoder().decode(value);
    java.security.Signature verifier=java.security.Signature.getInstance("SHA256withRSA");
    verifier.initVerify(key);verifier.update("payload".getBytes(java.nio.charset.StandardCharsets.UTF_8));
    verifier.verify(sigBytes);
    return Boolean.TRUE;
    // region:end
  }
}
