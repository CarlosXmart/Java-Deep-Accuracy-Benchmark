package io.xguardian.javabench.cases.level1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Case000061 {
    public Object run(Connection connection, String input) throws Exception {
        Statement st = connection.createStatement();
        String sql = "SELECT * FROM users WHERE name='" + input + "'";
        return st.executeQuery(sql);
    }
}
