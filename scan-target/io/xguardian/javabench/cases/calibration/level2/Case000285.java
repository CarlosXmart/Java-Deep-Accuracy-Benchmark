package io.xguardian.javabench.cases.calibration.level2;

public final class Case000285{
  private Case000285(){}

  public static Object run(java.security.PublicKey key,String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    byte[] sigBytes=java.util.Base64.getDecoder().decode(value);
    java.security.Signature verifier=java.security.Signature.getInstance("SHA256withRSA");
    verifier.initVerify(key);verifier.update("payload".getBytes(java.nio.charset.StandardCharsets.UTF_8));
    verifier.verify(sigBytes);
    return Boolean.TRUE;
    // region:end
  }
}
