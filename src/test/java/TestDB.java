import main.DBClass;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDB {
    public static Connection connection;
    public static Statement statement;

    @Before
    public void connect() throws SQLException, ClassNotFoundException{
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:jcp12_db.db");
        connection.setAutoCommit(false);
        statement = connection.createStatement();
    }

    @Test
    public void testDelete(){
        Assert.assertEquals(true, DBClass.checkDB(statement, "DELETE FROM students WHERE score < 45;"));
    }

    @Test
    public void testInsert(){
        Assert.assertEquals(true, DBClass.checkDB(statement, "INSERT INTO students(surname, score) VALUES ('Morty', 45);"));
    }

    @Test
    public void testUpdate(){
        Assert.assertEquals(true, DBClass.checkDB(statement,"UPDATE students SET score = 66 WHERE surname = 'Ivanov_1';"));
    }

    @After
    public void disconnect(){
        try{
            statement.close();
            connection.rollback();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
