package com.studentlogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginDAO {

    public boolean insert(user use) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement st = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/swetha"; // Database name, not table name
            String userName = "Arithadass";
            String passWord = "Ari@17";
            String query = "INSERT INTO sis(username, password) VALUES (?, ?)";

            // Establishing the connection
            con = DriverManager.getConnection(url, userName, passWord);
            st = con.prepareStatement(query);

            // Setting parameters
            st.setString(1, use.getUsername());
            st.setString(2, use.getPassword());

            // Executing the update
            int rowsInserted = st.executeUpdate();
            return rowsInserted>0 ;
        } 
        finally {
            // Closing resources
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
      
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    }
}

	


