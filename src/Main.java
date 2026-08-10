import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Library lib = new Library();

        Audiobook book = new Audiobook("The_Life", "Dilan", 80.0,
                Audiobook.genre.NONFICTION);

        Audiobook bookTwo = new Audiobook("Stars_and_sky", "Dilan",
                57.0, Audiobook.genre.NONFICTION);

        Audiobook bookThree = new Audiobook("The_Life", "Greg", 76.0,
                 Audiobook.genre.ROMANCE);

        lib.addToCollection(book);
        lib.addToCollection(bookTwo);
        lib.addToCollection(bookThree);

        System.out.println("Number of audiobooks: " + lib.getNumberOfAudiobooks());

        book.play();

        System.out.println("Number listening: " + lib.getNumberListening());

        lib.removeAudiobook("The_Life");

        System.out.println("Number of audiobooks: " + lib.getNumberOfAudiobooks());

        Audiobook bookFour = new Audiobook("The_Life", "Greg", 76.0,
                Audiobook.genre.ROMANCE);

        lib.addToCollection(bookFour);

        lib.removeAudiobook("Stars_and_sky");

        Audiobook bookFive = new Audiobook("Stars_and_sky", "Dilan",
                57.0, Audiobook.genre.NONFICTION);

        lib.addToCollection(bookFive);

        System.out.println("Number of audiobooks: " + lib.getNumberOfAudiobooks());

        ArrayList<Audiobook> books = new ArrayList<Audiobook>();

        books = lib.searchByAuthor("Dilan");

        for (Audiobook a : books) {
            System.out.println(a.getTitle());
        }
    }
}
