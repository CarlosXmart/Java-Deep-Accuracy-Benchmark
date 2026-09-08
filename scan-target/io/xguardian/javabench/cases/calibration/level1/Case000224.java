package io.xguardian.javabench.cases.calibration.level1;

public final class Case000224{
  private Case000224(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=source0;
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
