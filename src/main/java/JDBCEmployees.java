import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class JDBCEmployees {
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new Driver() {
        });
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employees?allowPublicKeyRetrieval=true&useSSL=false",
                "root",
                "codeup"
        );
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT first_name FROM employees LIMIT 10");
        while(rs.next()) {
            System.out.println(rs.getString(1));
        }
    }
}
