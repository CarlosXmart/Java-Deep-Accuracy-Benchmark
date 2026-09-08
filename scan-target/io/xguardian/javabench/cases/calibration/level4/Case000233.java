package io.xguardian.javabench.cases.calibration.level4;

public final class Case000233{
  private Case000233(){}

  public static Object run(String input)throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    javax.crypto.KeyGenerator kg=javax.crypto.KeyGenerator.getInstance("DES");
    javax.crypto.SecretKey key=kg.generateKey();
    javax.crypto.Cipher cipher=javax.crypto.Cipher.getInstance("DES/ECB/PKCS5Padding");
    cipher.init(javax.crypto.Cipher.ENCRYPT_MODE,key);
    return cipher.doFinal(value.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
