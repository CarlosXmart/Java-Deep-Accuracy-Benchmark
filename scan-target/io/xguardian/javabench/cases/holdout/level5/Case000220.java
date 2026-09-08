package io.xguardian.javabench.cases.holdout.level5;

public final class Case000220{
  private Case000220(){}

  public static Object run(javax.crypto.SecretKey input)throws Exception{
    var value=java.util.List.of(new Holder<>(relay(input))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    javax.crypto.SecretKey key=value;
    byte[] iv=new byte[12];new java.security.SecureRandom().nextBytes(iv);
    javax.crypto.Cipher cipher=javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
    cipher.init(javax.crypto.Cipher.ENCRYPT_MODE,key,new javax.crypto.spec.GCMParameterSpec(128,iv));
    return cipher.doFinal("payload".getBytes(java.nio.charset.StandardCharsets.UTF_8));
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
