package org.javadeep.benchmark.cases.level1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Case000063 {
    public Object run(Connection connection, String input) throws Exception {
        Statement st = connection.createStatement();
        String sql = String.format("SELECT * FROM users WHERE email='%s'", input);
        return st.executeQuery(sql);
    }
}
