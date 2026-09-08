package io.xguardian.javabench.cases.calibration.level4;

public final class Case000293{
  private Case000293(){}

  public static Object run(java.security.PublicKey key,String input)throws Exception{
    var value=new Holder<>(relay(input)).value();
    // region:start
    byte[] sigBytes=java.util.Base64.getDecoder().decode(value);
    java.security.Signature verifier=java.security.Signature.getInstance("SHA256withRSA");
    verifier.initVerify(key);verifier.update("payload".getBytes(java.nio.charset.StandardCharsets.UTF_8));
    verifier.verify(sigBytes);
    return Boolean.TRUE;
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
