
public class News {
    private String hading;
    private String text;
    private String date;


    public News(String hading, String text, String sdate) {
        this.hading = hading;
        this.text = text;
        if (sdate.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            this.date = sdate;
        } else {
            this.date = "2022-01-01";
        }
    }

    public String getHading() {
        return hading;
    }

    public void setHading(String hading) {
        this.hading = hading;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}