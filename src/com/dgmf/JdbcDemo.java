package com.dgmf;

/* JDBC Steps :
    - Import Package
    - Load and Register
    - Create Connection
    - Create Statement
    - Execute Statement
    - Process the Result
    - Close Connection
*/

// Import Package
import java.sql.*;

public class JdbcDemo {
    // public static void main(String[] args) throws ClassNotFoundException, SQLException {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/db_jdbc_demo_project";
        String username = "root";
        String password = "*ruTuch7D7ub";
        // String sqlQuery = "SELECT sname FROM student WHERE sid = 1";
        String sqlQuery = "SELECT * FROM student";

        // Load and Register - Statement Below is Now Optional
        // Loading class `com.mysql.jdbc.Driver'==> This is deprecated.
        // The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is
        // automatically registered via the SPI and manual loading of the driver
        // class is generally unnecessary.
        // Class.forName("com.mysql.jdbc.Driver");

        // Create Connection
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connection Established");
        // Create Statement
        Statement statement = connection.createStatement();
        // Execute Statement (Fetch Data - ResultSet)
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        // FETCH ONE ROW
        /*// Process the Result (Print the Result)
        // System.out.println(resultSet.next()); // Returns true or false
        resultSet.next(); // Put the Pointer at the Start of the Result Set
        String studentName = resultSet.getString("sname");
        System.out.println("The Name of the Student is : " + studentName);*/

        // FETCH ALL ROWS
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        // System.out.println(resultSetMetaData);
        int columnsNumber = resultSetMetaData.getColumnCount();
        // System.out.println(columnsNumber);
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");

                String columnValue = resultSet.getString(i);
                System.out.print(resultSetMetaData.getColumnName(i) + " : " + columnValue);
            }
            System.out.println("");
        }

        // Close Connection
        connection.close();
        System.out.println("Connection Closed");
    }
}
