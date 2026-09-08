package io.xguardian.javabench.cases.calibration.level3;

public final class Case000229{
  private Case000229(){}

  public static Object run(String input)throws Exception{
    var value=relay(input);
    // region:start
    javax.crypto.KeyGenerator kg=javax.crypto.KeyGenerator.getInstance("DES");
    javax.crypto.SecretKey key=kg.generateKey();
    javax.crypto.Cipher cipher=javax.crypto.Cipher.getInstance("DES/ECB/PKCS5Padding");
    cipher.init(javax.crypto.Cipher.ENCRYPT_MODE,key);
    return cipher.doFinal(value.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
