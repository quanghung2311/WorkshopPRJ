package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Quang Hung
 */
public class BookDB {
    //--------------------------------------------------------------------

    public static Book getBook(String aBookID) {
        Book book = null;
        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            String sql = "Select * from Books where BookID ='" + aBookID + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String bookID = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String category = rs.getString(4);
                String keyword = rs.getString(5);
                book = new Book(bookID, title, author, category, keyword);

            }
            conn.close();
           

        } catch (Exception ex) {
            
        }
        return book;
    }
    //-------------------------------------------------------------------- 

    public static void addNewBook(Book book) {

        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            String sql = "INSERT INTO Books VALUES(?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, book.getBookID());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            stmt.setString(4, book.getCategory());
            stmt.setString(5, book.getKeyword());
            stmt.execute();
            conn.close();
           
        } catch (Exception ex) {
            
        }

    }
    //--------------------------------------------------------------------   

    public static void updateBook(String id, Book book) {
        Connection conn;
        String sql = "Update Books Set BookID=?, Title = ?, Author = ?, Category =? , Keyword = ? Where BookID =  ?";
        try {
            conn = ConnectDB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, book.getBookID());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            stmt.setString(4, book.getCategory());
            stmt.setString(5, book.getKeyword());
            stmt.setString(6, id);
            stmt.execute();
            conn.close();
            
        } catch (Exception e) {
            
        }

    }

    //-------------------------------------------------------------------- 
    public static Book searchByBookID(String bookID1) {
        try {
            Book book = null;
            Connection conn;
            conn = ConnectDB.getConnection();
            String sql = "Select * from Books where BookID = '" + bookID1 + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String bookID = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String category = rs.getString(4);
                String keyword = rs.getString(5);
                book = new Book(bookID, title, author, category, keyword);
            }

            conn.close();
           
            return book;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
//-------------------------------------------------------------------- 

    public static ArrayList<Book> searchByTittle(String tit) {
        ArrayList<Book> allBooks = new ArrayList<>();
        try {
            Book book = null;
            Connection conn;
            conn = ConnectDB.getConnection();
            String sql = "Select * from books where Title = N'" + tit + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String bookID = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String category = rs.getString(4);
                String keyword = rs.getString(5);
                book = new Book(bookID, title, author, category, keyword);
                allBooks.add(book);
            }
            conn.close();
            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return allBooks;
    }

    //-------------------------------------------------------------------- 
    public static ArrayList<Book> searchByAuthor(String aut) {
        ArrayList<Book> authorBooks = new ArrayList<>();
        try {
            Book book = null;
            Connection conn;
            conn = ConnectDB.getConnection();
            String sql = "Select * from books where Author =  N'" + aut + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String bookID = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String category = rs.getString(4);
                String keyword = rs.getString(5);
                book = new Book(bookID, title, author, category, keyword);
                authorBooks.add(book);
            }
            conn.close();
            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return authorBooks;
    }
    //-------------------------------------------------------------------- 

    public static ArrayList<Book> searchByCategory(String cat) {
        ArrayList<Book> categoryBooks = new ArrayList<>();
        try {
            Book book = null;
            Connection conn;
            conn = ConnectDB.getConnection();
            String sql = "Select * from books where Category = '" + cat + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String bookID = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String category = rs.getString(4);
                String keyword = rs.getString(5);
                book = new Book(bookID, title, author, category, keyword);
                categoryBooks.add(book);
            }
            conn.close();
           

        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        return categoryBooks;
    }
    //-------------------------------------------------------------------- 

    public static ArrayList<Book> searchByKeyword(String key) {
        ArrayList<Book> keyBooks = new ArrayList<>();
        try {
            Book book = null;
            Connection conn;
            conn = ConnectDB.getConnection();
            String sql = "Select * from books where Keyword = '" + key + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String bookID = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String category = rs.getString(4);
                String keyword = rs.getString(5);
                Book keyBook = new Book(bookID, title, author, category, keyword);
                keyBooks.add(keyBook);
            }
            conn.close();
           
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return keyBooks;
    }
    //--------------------------------------------------------------------     

    public static ArrayList<Book> display() {
        ArrayList<Book> list = new ArrayList<>();
        Book book = null;
        try {
            Connection conn = ConnectDB.getConnection();
            String sql = "Select * from Books";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String bookID = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String category = rs.getString(4);
                String keyword = rs.getString(5);
                book = new Book(bookID, title, author, category, keyword);
                list.add(book);
              
            }
            conn.close();
        } catch (Exception ex) {
            
            ex.printStackTrace();
        }
        return list;
    }
    //--------------------------------------------------------------------  

    public static void delete(String id) {
        Connection conn;
        conn = ConnectDB.getConnection();
        String sql = "Delete from books where BookID = '" + id + "'";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            

        } catch (Exception ex) {
          
        }
    }

    public static ArrayList<Book> getlist() {
        ArrayList<Book> list = new ArrayList();

        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            String sql = "Select * from Books";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String bookID = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String category = rs.getString(4);
                String keyword = rs.getString(5);
                list.add(new Book(bookID, title, author, category, keyword));
            }
            conn.close();
            
        } catch (Exception ex) {
            
        }
        return list;
    }
}
