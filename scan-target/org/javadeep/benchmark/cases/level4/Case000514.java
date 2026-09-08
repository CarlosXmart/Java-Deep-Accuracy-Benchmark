package org.javadeep.benchmark.cases.level4;

import java.util.Map;
import java.util.function.Supplier;

public class Case000514 {
    public Object run(String user) throws Exception {
        String credential = System.getProperty("service.credential");
        if (credential == null) throw new IllegalStateException("credential unavailable");
        return user + ":" + credential;
    }
}
