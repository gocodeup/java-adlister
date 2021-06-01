import java.io.Serializable;

public class Author implements Serializable {
    public int id;
    public String author_first_name;
    public String author_last_name;

    public Author(){

    }

    Author(String author_first_name,int id, String author_last_name){
        this.author_first_name=author_first_name;
        this.author_last_name=author_last_name;
        this.id=id;
    }


    public void setAuthor_last_name(String author_last_name) {
        this.author_last_name = author_last_name;
    }

    public String getAuthor_last_name() {
        return author_last_name;
    }

    public void setAuthor_first_name(String author_first_name) {
        this.author_first_name = author_first_name;
    }

    public String getAuthor_first_name() {
        return author_first_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
