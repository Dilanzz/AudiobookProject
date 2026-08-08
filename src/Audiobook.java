import java.util.Scanner;

public  class Audiobook {

    public static int ID = 0;
    private int bookID;
    private String title;
    private String author;
    private double duration; //In minutes

    public enum genre {
        FICTION,
        NONFICTION,
        HORROR,
        ROMANCE,
    }

    public enum listeningStatus {
        NOT_STARTED,
        LISTENING,
        COMPLETED,
    }

    private genre category;
    private listeningStatus status;

    public Audiobook(String title, String author, double duration, genre category) {
        this.title = title;
        this.author = author;
        this.duration = duration;
        this.category = category;
        this.status = listeningStatus.NOT_STARTED;
        bookID = ID;
        ID++;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getDuration() {
        return duration;
    }

    public int getID() {
        return bookID;
    }

    public void play() {
        this.status = listeningStatus.LISTENING;
    }

    public void complete() {
        this.status = listeningStatus.COMPLETED;
    }

}
