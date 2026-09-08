package io.xguardian.javabench.cases.level5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Case000077 {
    public Object run(Connection connection, String input) throws Exception {
        java.util.function.Function<String,String> relay = x -> x;
        String value = relay.apply(input);
        Statement st = connection.createStatement();
        String sql = "SELECT * FROM users WHERE name='" + value + "'";
        return st.executeQuery(sql);
    }
}
