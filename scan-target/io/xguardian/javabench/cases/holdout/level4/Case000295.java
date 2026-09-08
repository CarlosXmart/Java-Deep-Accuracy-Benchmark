package io.xguardian.javabench.cases.holdout.level4;

public final class Case000295{
  private Case000295(){}

  public static Object run(java.security.PublicKey key,String input)throws Exception{
    var source0=System.getProperty("jdb.input",input);
    var value=new Holder<>(relay(source0)).value();
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
