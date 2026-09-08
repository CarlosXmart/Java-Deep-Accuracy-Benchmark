package io.xguardian.javabench.cases.holdout.level4;

public final class Case000235{
  private Case000235(){}

  public static Object run(String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=new Holder<>(relay(source0)).value();
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
