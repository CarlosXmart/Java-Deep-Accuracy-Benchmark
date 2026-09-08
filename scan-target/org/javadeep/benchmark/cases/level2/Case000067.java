package org.javadeep.benchmark.cases.level2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Case000067 {
    public Object run(Connection connection, String input) throws Exception {
        String value = input == null ? "" : input.trim();
        Statement st = connection.createStatement();
        String sql = String.format("SELECT * FROM users WHERE email='%s'", value);
        return st.executeQuery(sql);
    }
}
