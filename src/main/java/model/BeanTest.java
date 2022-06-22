package model;
import model.Album;

import java.util.ArrayList;
import java.util.Date;

public class BeanTest {
    public static void main(String[] args) {
        Date nevermind = new Date(1991, 9, 24);
        Album Nirvana = new Album(1, "Nirvana", "Nevermind", nevermind, 2.2, "Grunge");

        Quote LaoTzuQuote = new Quote(1, "The journey of a thousand miles begins with one step.", "Lao Tzu");
        Author LaoTzu = new Author(1, "Lao", "Tzu");

        Quote NietzscheQuote = new Quote(2, "This what does not kill us makes us stronger.", "Nietzsche");
        Author Nietzsche = new Author(2, "Friedrich", "Nietzche");

        Quote JoeKennedyQuote = new Quote(3, "When the going gets tough, the though get going.", "Joe Kennedy");
        Author JoeKennedy = new Author(3, "Joe", "Kennedy");

        ArrayList<Quote> quotes = new ArrayList<>();
        quotes.add(LaoTzuQuote);
        quotes.add(NietzscheQuote);
        quotes.add(JoeKennedyQuote);

        for (Quote quote : quotes){
            System.out.println(quote.getContent());
            System.out.println(quote.getAuthor());
        }
    }
}
