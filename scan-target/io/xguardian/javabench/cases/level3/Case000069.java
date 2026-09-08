package io.xguardian.javabench.cases.level3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Case000069 {
    public Object run(Connection connection, String input) throws Exception {
        String value = relay(input);
        Statement st = connection.createStatement();
        String sql = "SELECT * FROM users WHERE name='" + value + "'";
        return st.executeQuery(sql);
    }

    private String relay(String value) {
        return value;
    }
}
