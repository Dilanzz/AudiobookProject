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


    }
}
