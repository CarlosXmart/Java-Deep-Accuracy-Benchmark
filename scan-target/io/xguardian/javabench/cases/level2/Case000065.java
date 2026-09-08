package io.xguardian.javabench.cases.level2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Case000065 {
    public Object run(Connection connection, String input) throws Exception {
        String value = input == null ? "" : input.trim();
        Statement st = connection.createStatement();
        String sql = "SELECT * FROM users WHERE name='" + value + "'";
        return st.executeQuery(sql);
    }
}
