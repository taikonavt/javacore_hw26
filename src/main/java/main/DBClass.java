package main;

import java.sql.*;

public class DBClass {
    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {
        try {
            connect();
            createTable();
            clearTable();
            preparedStatementBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:jcp12_db.db");
        statement = connection.createStatement();
    }

    public static void createTable() throws SQLException{
        statement.execute("CREATE TABLE IF NOT EXISTS students (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "surname STRING, " +
                "score INTEGER);");
    }

    public static void dropTable() throws SQLException {
        statement.execute("DROP TABLE goods");
    }

    public static void clearTable() throws SQLException{
        statement.execute("DELETE FROM students");
    }

    public static void preparedStatementBatch() throws SQLException{
        connection.setAutoCommit(false);
        PreparedStatement ps = connection.prepareStatement("INSERT INTO students(surname, score) VALUES(?, ?)");
        for (int i = 0; i < 10; i++) {
            ps.setString(1, "Ivanov_" + i);
            ps.setInt(2, i * 10);
            ps.executeUpdate();
        }
        connection.commit();
    }

    public static boolean checkDB(Statement statement, String string){
        int i = 0;
        try{
            i = statement.executeUpdate(string);
        }catch(SQLException e){
            return false;
        }
        return i != 0;
    }
}
