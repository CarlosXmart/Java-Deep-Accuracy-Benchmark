package io.xguardian.javabench.cases.calibration.level3;

public final class Case000169{
  private Case000169(){}

  public static Object run(String input)throws Exception{
    var value=relay(input);
    // region:start
    javax.net.ssl.TrustManager[] tm={new javax.net.ssl.X509TrustManager(){
    public java.security.cert.X509Certificate[] getAcceptedIssuers(){return new java.security.cert.X509Certificate[0];}
    public void checkClientTrusted(java.security.cert.X509Certificate[] x,String a){}
    public void checkServerTrusted(java.security.cert.X509Certificate[] x,String a){}
    }};
    javax.net.ssl.SSLContext ctx=javax.net.ssl.SSLContext.getInstance("TLS");
    ctx.init(null,tm,new java.security.SecureRandom());
    return ctx.getSocketFactory();
    // region:end
  }

  private static <T>T relay(T value){return value;}
}
