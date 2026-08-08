import java.util.ArrayList;
import java.util.Iterator;

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
        Iterator<Audiobook> iterator = collection.iterator();

        while (iterator.hasNext()) {
            Audiobook item = iterator.next();

            if (item.getTitle().equalsIgnoreCase(name)) {
                iterator.remove();
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
}
