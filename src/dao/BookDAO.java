package dao;

import db.DBConnection;
import model.Book;
import model.Status;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection c = DBConnection.getConnection();
             Statement s = c.createStatement();
             ResultSet r = s.executeQuery(sql)) {

            while (r.next()) {
                list.add(new Book(
                        r.getInt("id"),
                        r.getString("title"),
                        r.getString("author"),
                        Status.valueOf(r.getString("status"))
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(String title, String author) {
        String sql = "INSERT INTO books (title, author, status) VALUES (?, ?, 'AVAILABLE')";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {

            p.setString(1, title);
            p.setString(2, author);
            p.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection c = DBConnection.getConnection();
             PreparedStatement p = c.prepareStatement("DELETE FROM books WHERE id=?")) {
            p.setInt(1, id);
            p.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStatus(int id, Status status) {
        try (Connection c = DBConnection.getConnection();
             PreparedStatement p = c.prepareStatement(
                     "UPDATE books SET status=? WHERE id=?")) {
            p.setString(1, status.name());
            p.setInt(2, id);
            p.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
