package io.xguardian.javabench.cases.level3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Case000070 {
    public Object run(Connection connection, String input) throws Exception {
        String value = relay(input);
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE name=?");
        ps.setString(1, value);
        return ps.executeQuery();
    }

    private String relay(String value) {
        return value;
    }
}
