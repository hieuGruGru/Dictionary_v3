package sample;

import java.sql.*;

public class ConnectToSQLServer {
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName = Dictionary_Data;" + "integratedSecurity = true;";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "219907";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static void login(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT password FROM Login WHERE username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {

            } else {
                while (resultSet.next()) {
                    String pass = resultSet.getString("password");

                    if (pass.equals(password)) {

                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
