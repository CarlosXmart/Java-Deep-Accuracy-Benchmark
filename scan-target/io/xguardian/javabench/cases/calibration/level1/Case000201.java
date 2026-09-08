package io.xguardian.javabench.cases.calibration.level1;

public final class Case000201{
  private Case000201(){}

  public static Object run(javax.crypto.SecretKey input)throws Exception{
    var value=input;
    // region:start
    javax.crypto.SecretKey key=new javax.crypto.spec.SecretKeySpec("0123456789abcdef".getBytes(java.nio.charset.StandardCharsets.UTF_8),"AES");
    byte[] iv=new byte[12];new java.security.SecureRandom().nextBytes(iv);
    javax.crypto.Cipher cipher=javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
    cipher.init(javax.crypto.Cipher.ENCRYPT_MODE,key,new javax.crypto.spec.GCMParameterSpec(128,iv));
    return cipher.doFinal("payload".getBytes(java.nio.charset.StandardCharsets.UTF_8));
    // region:end
  }
}
