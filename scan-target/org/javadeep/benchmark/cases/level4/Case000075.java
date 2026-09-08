package org.javadeep.benchmark.cases.level4;

import jakarta.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Case000075 {
    public Object run(Connection connection, HttpServletRequest request) throws Exception {
        String value = request.getParameter("q");
        Statement st = connection.createStatement();
        String sql = String.format("SELECT * FROM users WHERE email='%s'", value);
        return st.executeQuery(sql);
    }
}
