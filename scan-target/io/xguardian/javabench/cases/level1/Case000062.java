package io.xguardian.javabench.cases.level1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Case000062 {
    public Object run(Connection connection, String input) throws Exception {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE name=?");
        ps.setString(1, input);
        return ps.executeQuery();
    }
}
