package com.dgmf;

/* JDBC Steps :
    - Import Package
    - Load and Register
    - Create Connection
    - Create Statement
    - Execute Statement
    - Process the Result
    - Close
*/

// Import Package
import java.sql.*;

public class JdbcDemo {
    // public static void main(String[] args) throws ClassNotFoundException, SQLException {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/db_jdbc_demo_project";
        String username = "root";
        String password = "*ruTuch7D7ub";

        // Load and Register - Statement Below is Now Optional
        // Loading class `com.mysql.jdbc.Driver'==> This is deprecated.
        // The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is
        // automatically registered via the SPI and manual loading of the driver
        // class is generally unnecessary.
        // Class.forName("com.mysql.jdbc.Driver");

        // Create Connection
        Connection con = DriverManager.getConnection(url, username, password);

        System.out.println("Connection Established");
    }
}
