import java.text.ParseException;


public class Main {
    public static void main(String[] args) throws ParseException {
        Conn conn = new Conn();
        conn.connection();
        News news = new News("Head", "Text text text text", "2015-02-01");
        conn.createNews(news);//1
        conn.showNews();//2
        conn.deleteNews(5);//3
        News upNews = new News("Head123", "Text123 text123 text123 text123", "2015-02-01");
        conn.updateNews(upNews, 6);//4
    }
}
