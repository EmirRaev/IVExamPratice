import java.sql.*;

public class Conn {

    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "admin";
    public Connection connection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return conn;
    }

    public void createNews(News news) {
        String sqlInsertNews = "insert into news (heading, text, date) values (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection().prepareStatement(sqlInsertNews);
            preparedStatement.setString(1, news.getHading());
            preparedStatement.setString(2, news.getText());
            preparedStatement.setDate(3, Date.valueOf(news.getDate()));
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void showNews() {
        String sqlSelectNews = "select heading, text, date from news";
        try {
            Statement statement = connection().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelectNews);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("heading")
                        + " " + resultSet.getString("text")
                        + " " + resultSet.getString("date"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void deleteNews(int id) {
        String sqlDeleteNews = "delete from news where id = ?";
        try {
            PreparedStatement prSt = connection().prepareStatement(sqlDeleteNews);
            prSt.setInt(1, id);
            prSt.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void updateNews(News news, int id) {
        String sqlUpdateNews = "update news set heading = ?, text = ?, date = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection().prepareStatement(sqlUpdateNews);
            preparedStatement.setInt(4, id);
            preparedStatement.setString(1, news.getHading());
            preparedStatement.setString(2, news.getText());
            preparedStatement.setDate(3, Date.valueOf(news.getDate()) );
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}



