import java.io.Serializable;

//TODO: Referring back to the Database Design lesson, create beans for the quotes and authors tables
// (Quote and Author). Instead of including a foreign key property in the Quote class, include an Author
// property.

public class Quote implements Serializable {

    private int id;
    private String content;
    private String author;

    public Quote() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}// End Quotes Class (JavaBean)