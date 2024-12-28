package main.taskApp.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TasksRepository {

    private static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:tasks.db";
            conn = DriverManager.getConnection(url);
        }
        catch (SQLException e) {
            throw new RuntimeException("Exception with SQL");
        }
        return conn;
    }

    public void createdatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS utasks (" +
                                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "taskname TEXT NOT NULL," +
                                "type TEXT NOT NULL," +
                                "date TEXT NOT NULL," +
                                "time TEXT NOT NULL);";
        try (Connection connection = connect(); Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void adddata(Task newtask) {
        String sql = "INSERT INTO utasks(taskname, type, date, time) VALUES(?,?,?,?)";
        try(Connection connection  = connect(); PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, newtask.taskname);
            pstmt.setString(2, newtask.type);
            pstmt.setString(3, newtask.date);
            pstmt.setString(4, newtask.time);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e); }
    }

    public List<Task> returndata() {
        createdatabase();
        String sql = "SELECT * FROM utasks";
        List<Task> tasks = new ArrayList<>();
        Task task;
        try (Connection connection = connect(); PreparedStatement pstmt = connection.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                task = new Task(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
                tasks.add(task);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return tasks;
    }
}
