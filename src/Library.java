import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Library {

    private ArrayList<Audiobook> collection = new ArrayList<>();

    public void addToCollection(Audiobook audiobook) {
        collection.add(audiobook);
    }

    public ArrayList<Audiobook> getCollection() {
        return collection;
    }

    public ArrayList<Audiobook> getAudiobook(String name) {
        ArrayList<Audiobook> listOfMatchingNames = new ArrayList<>();

        for (Audiobook item: collection) {
            if (item.getTitle().equalsIgnoreCase(name)) {
                listOfMatchingNames.add(item);
            }
        }

        return listOfMatchingNames;
    }

    public ArrayList<Audiobook> searchByAuthor(String author) {
        ArrayList<Audiobook> listOfMatchingAuthor = new ArrayList<>();

        for (Audiobook item: collection) {
            if  (item.getAuthor().equalsIgnoreCase(author)) {
                listOfMatchingAuthor.add(item);
            }
        }

        return listOfMatchingAuthor;
    }

    public ArrayList<Audiobook> searchByGenre(Audiobook.genre genre) {
        ArrayList<Audiobook> listOfMatchingGenre = new ArrayList<>();

        for (Audiobook item: collection) {
            if (item.getGenre().equals(genre)) {
                listOfMatchingGenre.add(item);
            }
        }

        return listOfMatchingGenre;
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
            boolean notInt = false;
            Scanner scanner = new Scanner(System.in);
            do {

                if (scanner.hasNextInt()) {
                    int input = scanner.nextInt();
                    for (Audiobook item : listOfMatchingNames) {
                        if (item.getID() == input) {
                            collection.remove(item);
                            System.out.println("Removed the book " + item.getBookInfo());
                            removed = true;
                        }
                    }
                } else {
                    notInt = true;
                }


                if (notInt) {
                    System.out.println("Please enter an integer");
                    notInt = false;
                } else if (!removed) {
                    System.out.println("Please enter one of the IDs listed");
                }

            } while (!removed);
        } else {
            Iterator<Audiobook> iterator = collection.iterator();

            while (iterator.hasNext()) {
                Audiobook item = iterator.next();

                if (item.getTitle().equalsIgnoreCase(name)) {
                    iterator.remove();
                }
            }
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

    public void UpdateListeningStatus(Audiobook audiobook) {
        if (audiobook.getStatus().equals(Audiobook.listeningStatus.LISTENING)) {
            audiobook.complete();
        } else if (audiobook.getStatus().equals(Audiobook.listeningStatus.NOT_STARTED)) {
            audiobook.play();
        }
    }
}
