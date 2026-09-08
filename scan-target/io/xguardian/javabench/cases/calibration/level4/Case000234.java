package io.xguardian.javabench.cases.calibration.level4;

public final class Case000234{
  private Case000234(){}

  public static Object run(String input)throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    javax.crypto.KeyGenerator kg=javax.crypto.KeyGenerator.getInstance("AES");kg.init(128);
    javax.crypto.SecretKey key=kg.generateKey();
    byte[] iv=new byte[12];new java.security.SecureRandom().nextBytes(iv);
    javax.crypto.Cipher cipher=javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
    cipher.init(javax.crypto.Cipher.ENCRYPT_MODE,key,new javax.crypto.spec.GCMParameterSpec(128,iv));
    return cipher.doFinal(value.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
