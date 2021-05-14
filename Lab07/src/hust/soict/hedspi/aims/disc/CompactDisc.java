package hust.soict.hedspi.aims.disc;

import java.util.ArrayList;

/**
 * CompactDisc
 */
public class CompactDisc extends Disc implements Playable {

    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();


    public String getArtist() {
        return this.artist;
    }

    // public void setTracks(ArrayList<Track> tracks) {
    //     this.tracks = tracks;
    // }

    public CompactDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, director, length, cost);
    }

    public CompactDisc(int id, String title, String category, String director, String artist,int length, float cost) {
        super(id, title, category, director, length, cost);
        this.artist = artist;
    }
    
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track has been existed !!!");
        } else
            tracks.add(track);
    }

    public void remoteTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Removed !!!");
        } else {
            System.out.println("Not found track !!!");
        }
    }

    public int getLength() {
        int sum = 0;
            for (Track track : tracks) {
                sum += track.getLength();
            }
        return sum;
    }

    @Override
    public void play() {
        
    }
}
