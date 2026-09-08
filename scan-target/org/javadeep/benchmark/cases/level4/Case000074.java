package org.javadeep.benchmark.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Case000074 {
    public Object run(Connection connection, HttpServletRequest request) throws Exception {
        String value = request.getParameter("value");
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE name=?");
        ps.setString(1, value);
        return ps.executeQuery();
    }
}
