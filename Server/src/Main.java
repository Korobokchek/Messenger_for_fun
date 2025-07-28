import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class CreateTableExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/MYSQL";
        String username = "SnrMazega";
        String password = "WTF1243";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Подключение успешно!");

            // Создание таблицы
            createTable(connection);

        } catch (SQLException e) {
            System.out.println("Ошибка подключения: " + e.getMessage());
        }
    }

    // Метод для создания таблицы
    private static void createTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "username VARCHAR(50) NOT NULL," +
                "email VARCHAR(100) UNIQUE NOT NULL," +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ")";

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Таблица успешно создана!");
            String insertSQL = "INSERT INTO users (username, email) VALUES ('john_doe', 'john@example.com')";
            int rowsAffected = statement.executeUpdate(insertSQL);
            System.out.println("Добавлено строк: " + rowsAffected);
        }
    }
    private static void
}