
//TODO: Create a class, BeanTest, and include a main method that instantiates a few
// instances of Album, Author and Quote.

import java.util.ArrayList;

public class BeanTest {

    public static void main(String[] args) {

        Album albumOne = new Album();
        Album albumTwo = new Album();
        Author authorOne = new Author();
        Author authorTwo = new Author();
        Quote quoteOne = new Quote();
        quoteOne.setId(1);
        quoteOne.setAuthor("Rene Descartes");
        quoteOne.setContent("Cogito, ergo sum.");
        Quote quoteTwo = new Quote();
        quoteTwo.setId(2);
        quoteTwo.setAuthor("Socrates");
        quoteTwo.setContent("The unexamined life is not worth living.");
        Quote quoteThree = new Quote();
        quoteThree.setId(3);
        quoteThree.setAuthor("Winston Churchill");
        quoteThree.setContent("If you're going through hell, keep going.");

    //TODO: In BeanTest, experiment with storing multiple instances of Quote in an arraylist and iterating over it to
    // print out the content and author name of multiple quotes.

        ArrayList<Quote> quoteCollection = new ArrayList();
        quoteCollection.add(quoteOne);
        quoteCollection.add(quoteTwo);
        quoteCollection.add(quoteThree);

        for (Quote element : quoteCollection) {
            System.out.println(element.getId());
            System.out.println(element.getAuthor());
            System.out.println(element.getContent());
        }

    }
}
