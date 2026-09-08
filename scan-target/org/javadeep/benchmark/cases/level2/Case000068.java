package org.javadeep.benchmark.cases.level2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Case000068 {
    public Object run(Connection connection, String input) throws Exception {
        String value = input == null ? "" : input.trim();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE email=?");
        ps.setString(1, value);
        return ps.executeQuery();
    }
}
