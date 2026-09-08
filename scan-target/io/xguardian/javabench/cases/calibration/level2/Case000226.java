package io.xguardian.javabench.cases.calibration.level2;

public final class Case000226{
  private Case000226(){}

  public static Object run(String input)throws Exception{
    var stage1=input;
    var value=stage1;
    // region:start
    javax.crypto.KeyGenerator kg=javax.crypto.KeyGenerator.getInstance("AES");kg.init(128);
    javax.crypto.SecretKey key=kg.generateKey();
    byte[] iv=new byte[12];new java.security.SecureRandom().nextBytes(iv);
    javax.crypto.Cipher cipher=javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
    cipher.init(javax.crypto.Cipher.ENCRYPT_MODE,key,new javax.crypto.spec.GCMParameterSpec(128,iv));
    return cipher.doFinal(value.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    // region:end
  }
}
