package hust.soict.hedspi.aims.disc;

public class Track implements Playable {
    private String title;
    private int length;

    public String getTitle() {
        return this.title;
    }

    // public void setTitle(String title) {
    //     this.title = title;
    // }

    public int getLength() {
        return this.length;
    }

    // public void setLength(int length) {
    //     this.length = length;
    // }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    @Override
    public void play() {
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
    
}
