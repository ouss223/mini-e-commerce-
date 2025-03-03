import com.example.dao.DatabaseConnection;
import java.sql.Connection;

public class test {
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            System.out.println("Connection successful!");
            conn.close();
        } catch (Exception e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}