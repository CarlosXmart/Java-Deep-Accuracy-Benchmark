package io.xguardian.javabench.cases.calibration.level1;

public final class Case000284{
  private Case000284(){}

  public static Object run(java.security.PublicKey key,String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=source0;
    // region:start
    byte[] sigBytes=java.util.Base64.getDecoder().decode(value);
    java.security.Signature verifier=java.security.Signature.getInstance("SHA256withRSA");
    verifier.initVerify(key);verifier.update("payload".getBytes(java.nio.charset.StandardCharsets.UTF_8));
    return verifier.verify(sigBytes);
    // region:end
  }
}
