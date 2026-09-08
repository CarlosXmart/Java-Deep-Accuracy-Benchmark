package org.javadeep.benchmark.cases.level3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Case000071 {
    public Object run(Connection connection, String input) throws Exception {
        String value = relay(input);
        Statement st = connection.createStatement();
        String sql = String.format("SELECT * FROM users WHERE email='%s'", value);
        return st.executeQuery(sql);
    }

    private String relay(String value) {
        return value;
    }
}
