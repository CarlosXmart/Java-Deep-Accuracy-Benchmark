package io.xguardian.javabench.cases.calibration.level1;

public final class Case000542{
  private Case000542(){}

  public static Object run(String input)throws Exception{
    var value=input;
    // region:start
    java.net.URI target=java.net.URI.create(value);
    if(!"https".equalsIgnoreCase(target.getScheme())||!"api.example.com".equalsIgnoreCase(target.getHost()))throw new SecurityException("destination");
    int port=target.getPort();if(port!=-1&&port!=443)throw new SecurityException("port");
    return target.toURL().openConnection();
    // region:end
  }
}
