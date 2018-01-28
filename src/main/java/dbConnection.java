import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class dbConnection {
    /**
     * Connect to a sample database
     */

    public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/sqlite/db/svettsvett.sqlite";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            String sql = ("SELECT * from users where username = 'trill'");
            st.getResultSet().getRow();
            conn.close();
            System.out.println("Connection to SQLite has been established.");
            System.out.println(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connect();
    }
}
