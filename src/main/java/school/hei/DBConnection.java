package school.hei;

import io.github.cdimascio.dotenv.Dotenv;

public class DBConnection {
    private final Dotenv dotenv = Dotenv.load();

    public String getUrl() {
        return dotenv.get("JDBC_URL");
    }

    public String getUsername() {
        return dotenv.get("USERNAME");
    }

    public String getPassword() {
        return dotenv.get("PASSWORD");
    }

    public java.sql.Connection getConnection() throws java.sql.SQLException {
        String url = getUrl();
        String user = getUsername();
        String pass = getPassword();
        return java.sql.DriverManager.getConnection(url, user, pass);
    }
}
