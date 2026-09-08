package org.javadeep.benchmark.cases.level5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Case000080 {
    public Object run(Connection connection, String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE email=?");
        ps.setString(1, value);
        return ps.executeQuery();
    }
}
