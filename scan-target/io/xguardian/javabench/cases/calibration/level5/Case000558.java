package io.xguardian.javabench.cases.calibration.level5;

public final class Case000558{
  private Case000558(){}

  public static Object run(String input)throws Exception{
    var value=java.util.List.of(new Holder<>(relay(input))).stream().map(Holder::value).findFirst().orElseThrow();
    // region:start
    java.net.URI target=java.net.URI.create(value);
    if(!"https".equalsIgnoreCase(target.getScheme())||!"api.example.com".equalsIgnoreCase(target.getHost()))throw new SecurityException("destination");
    int port=target.getPort();if(port!=-1&&port!=443)throw new SecurityException("port");
    return target.toURL().openConnection();
    // region:end
  }

  private static <T>T relay(T value){return value;}

  private record Holder<T>(T value){}
}
