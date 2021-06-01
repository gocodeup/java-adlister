import java.io.Serializable;

public class Album implements Serializable {
    public int id;
    public String artist_name;
    public String record_name;
    public int release_date;
    public String genre;
    public Float sales;


    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getArtist_name(){
        return this.artist_name;
    }
    public void setArtist_name(){
        this.artist_name=artist_name;
    }
    public int getRelease_date(){
        return this.release_date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Float getSales() {
        return sales;
    }

    public void setSales(Float sales) {
        this.sales = sales;
    }

    public String getRecord_name() {
        return record_name;
    }

    public void setRecord_name(String record_name) {
        this.record_name = record_name;
    }
}
