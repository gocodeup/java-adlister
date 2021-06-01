//import com.sun.org.apache.xpath.internal.operations.Quo;

import java.util.ArrayList;

public class BeanTest {

    public static void main(String[] args) {

        Author kelvon = new Author();

        kelvon.id=1;
        kelvon.author_first_name="Kelvon";
        kelvon.author_last_name="Patterson";


        Author amirah =  new Author();
        amirah.id=2;
        amirah.author_first_name = "Amirah";
        amirah.author_last_name = "Beal";

        Author todd = new Author();
        todd.id= 3;
        todd.author_first_name = "Todd";
        todd.author_last_name = "Patterson";


        Quote quote1 = new Quote();
        quote1.id=1;
        quote1.content = "Every minute you're not coding, you're not a developer";
        quote1.setAuthor_id(2);


        Quote quote2 = new Quote();
        quote2.id=2;
        quote2.content= "i have to do my makeup first";
        quote2.setAuthor_id(1);


        Quote quote3 = new Quote();
        quote3.id=3;
        quote3.content = "Do what makes you happy";
        quote3.setAuthor_id(3);
// ('Michael Jackson', 'Thriller', 1982, 'Pop, Rock, R&B', 47.3),
        Album thriller = new Album();
        thriller.artist_name = "Michael Jackson";
        thriller.id=1;
        thriller.record_name= "Thriller";
        thriller.release_date= 1982;
        thriller.genre= "Pop, Rock, Rock, R&B";
        thriller.sales= 47.3F;

        Album bad = new Album();
        bad.id=2;
        bad.record_name= "Michael Jackson";
        bad.sales= 19.3F;
        bad.record_name= "Bad";
        bad.genre= "Pop, Funk, Rock";
        bad.release_date= 1987;

        Album twentyOne = new Album();
        twentyOne.id=3;
        twentyOne.release_date = 2011;
        twentyOne.record_name= "21";
        twentyOne.sales= 25.3F;
        twentyOne.genre= "Pop, Soul";
        twentyOne.artist_name= "Adele";

        ArrayList<Quote> quotes = new ArrayList<>();
        quotes.add(quote1);
        quotes.add(quote2);
        quotes.add(quote3);

        for(Quote quote:quotes){
            System.out.println(quote.getContent());
        }


    }
}
