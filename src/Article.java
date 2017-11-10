/**
 * Created by luoluyao on 2017/11/9.
 */
/**
 * Created by luoluyao on 2017/11/9.
 */
public class Article {
    private String title;
    private String author;
    private String content;
    private int id;
    public Article(int id, String title, String author, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.id = id;
    }

    @Override
    public String toString() {
        return "\nid:" + id + "\ntitle:" + title + "\nauthor:" + author + "\n" + "content:" + content;
    }
}

