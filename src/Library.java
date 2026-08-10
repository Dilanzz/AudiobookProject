import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Library {

    private ArrayList<Audiobook> collection = new ArrayList<>();

    public void addToCollection(Audiobook audiobook) {
        collection.add(audiobook);
    }

    public Audiobook getAudiobook(String name) {
        for (Audiobook item: collection) {
            if (item.getTitle().equalsIgnoreCase(name)) {
                return item;
            }
        }
        System.out.println("Item not found");
        return null;
    }

    public void removeAudiobook(String name) {
        ArrayList<Audiobook> listOfMatchingNames = new ArrayList<>();

        for (Audiobook item: collection) {
            if (item.getTitle().equalsIgnoreCase(name)) {
                listOfMatchingNames.add(item);
            }
        }

        if (listOfMatchingNames.size() > 1) {
            System.out.println("There is more than one item with the same title," +
                    " which book do you want to remove? (Select by ID)");
            for (Audiobook item: listOfMatchingNames) {
                System.out.println(item.getBookInfo());
            }

            boolean removed = false;
            do {
                Scanner scanner = new Scanner(System.in);

                int input = scanner.nextInt();

                if (scanner.hasNextInt()) {
                    for (Audiobook item : listOfMatchingNames) {
                        if (item.getID() == input) {
                            collection.remove(item);
                            System.out.println("Removed the book " + item.getBookInfo());
                            removed = true;
                        }
                    }
                }

                if (!removed) {
                    System.out.println("Invalid ID or datatype, try again");
                }

            } while (!removed);
        }
    }

    public int getNumberOfAudiobooks() {
        return collection.size();
    }

    public int getNumberListening() {
        int i = 0;

        for (Audiobook item: collection) {
            if (Audiobook.listeningStatus.LISTENING == item.getStatus()) {
                i++;
            }
        }

        return i;
    }
}
