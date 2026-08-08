import java.util.ArrayList;

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
        for (Audiobook item: collection) {
            if (item.getTitle().equalsIgnoreCase("name")) {
                collection.remove(item);
            }
        }
    }
}
