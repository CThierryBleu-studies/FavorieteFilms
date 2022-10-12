package be.ucll.favorietefilms;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmRepository {
    private final String DB_URL = "jdbc:mysql://localhost:3306/java-gevorderd";
    private final String USERNAME = "root";
    private final String PASSWORD = "Java";


    public boolean insert(String pTitle, int pYear, int pScore, String pReview) {
        Film film = new Film();
        film.setTitle(pTitle);
        film.setYear(pYear);
        film.setScore(pScore);
        film.setReview(pReview);
        String updatePositionSql = "INSERT INTO films VALUES (?, ?, ?, ?)";
        try (Connection myConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = myConnection.prepareStatement(updatePositionSql)) {
            pstmt.setString(1, film.getTitle());
            pstmt.setInt(2, film.getYear());
            pstmt.setInt(3, film.getScore());
            pstmt.setString(4, film.getReview());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(String pTitle, int pYear, int pScore, String pReview) {
        Film film = new Film();
        film.setTitle(pTitle);
        film.setYear(pYear);
        film.setScore(pScore);
        film.setReview(pReview);
        String updatePositionSql = "UPDATE films SET year = ?, score = ?, review = ? WHERE title = ?";
        try (Connection myConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = myConnection.prepareStatement(updatePositionSql)) {
            pstmt.setString(4, film.getTitle());
            pstmt.setInt(1, film.getYear());
            pstmt.setInt(2, film.getScore());
            pstmt.setString(3, film.getReview());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<String> getByTitle(String pTitle) {
        String query = "SELECT * FROM films WHERE title = ?";
        List<String> films = new ArrayList<>();
        try (Connection myConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = myConnection.prepareStatement(query)) {
            pstmt.setString(1, pTitle);
            ResultSet myResultSet = pstmt.executeQuery();
            while (myResultSet.next()) {
                String row = "";
                row += "Title: " + myResultSet.getString("title");
                row += ", Year: " + myResultSet.getInt("year");
                row += ", Score: " + myResultSet.getInt("score");
                row += ", Review: " + myResultSet.getString("review");
                films.add(row);
            }
            myResultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }

    public List<String> getAllFilms() {
        List<String> films = new ArrayList<>();
        try (Connection myConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement myStatement = myConnection.createStatement();
             ResultSet myResultSet = myStatement.executeQuery("SELECT * FROM films")) {
            while (myResultSet.next()) {
                String row = "";
                row += "Title: " + myResultSet.getString("title");
                row += ", Year: " + myResultSet.getInt("year");
                row += ", Score: " + myResultSet.getInt("score");
                row += ", Review: " + myResultSet.getString("review");
                films.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }

//   public boolean delete(String title) {
//        String updatePositionSql = "DELETE FROM film WHERE title = ?";
//        try (Connection myConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
//            PreparedStatement pstmt = myConnection.prepareStatement(updatePositionSql)) {
//            pstmt.setString(1, title);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }

}