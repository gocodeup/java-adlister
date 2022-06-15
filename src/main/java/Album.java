import java.io.Serializable;

public class Album implements Serializable {

    //TODO : Referring back to the MySQL Tables lesson, create a bean, Album, for the albums table.
    private int id;
    private String artist;
    private String albumName;
    private int releaseDate;
    private float sales;
    private String genre;

    public Album() {}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getArtist() {return artist;}

    public void setArtist(String artist) {this.artist = artist;}

    public String getAlbum_name() {return albumName;}

    public void setAlbum_name(String album_name) {this.albumName = albumName;}

    public int getRelease_date() {return releaseDate;}

    public void setRelease_date(int release_date) {this.releaseDate = releaseDate;}

    public float getSales() {return sales;}

    public void setSales(float sales) {this.sales = sales;}

    public String getGenre() {return genre;}

    public void setGenre(String genre) {this.genre = genre;}

} // End class Album (JavaBean)
