package org.javadeep.benchmark.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Case000073 {
    public Object run(Connection connection, HttpServletRequest request) throws Exception {
        String value = request.getParameter("value");
        Statement st = connection.createStatement();
        String sql = "SELECT * FROM users WHERE name='" + value + "'";
        return st.executeQuery(sql);
    }
}
