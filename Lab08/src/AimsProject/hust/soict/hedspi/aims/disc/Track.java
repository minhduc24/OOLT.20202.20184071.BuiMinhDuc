package AimsProject.hust.soict.hedspi.aims.disc;

public class Track implements Playable, Comparable<Track> {
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
    
    public boolean equals (Object object) {
        Track track = (Track) object;
        if (title.equals(track.title) && length == track.length)
            return true;
        else
            return false;
    }

    public int compareTo(Track track) {
        if (this.getTitle().equals(track.getTitle())) {
            return this.getLength() - track.getLength();
        }
        return this.getTitle().compareTo(track.getTitle());
    }
}