package AimsProject.hust.soict.hedspi.aims.disc;

import java.util.ArrayList;

import AimsProject.hust.soict.hedspi.aims.media.Media;

/**
 * CompactDisc
 */
public class CompactDisc extends Disc implements Playable  {

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
        for(Track track : tracks) {
            System.out.println("Playing CD: "+track.getTitle()+"CD length: "+track.getLength());
        }
    }

    public int compareTo(Media media) {
        if(media instanceof CompactDisc) {
            CompactDisc disc = (CompactDisc)media;
            if(tracks.size() == disc.tracks.size()) {
                return Integer.compare(this.length, disc.getLength());
            }
            else if(tracks.size() < disc.tracks.size()) {
                return -1;
            }
            else {
                return 1;
            }
        }   else {
            return super.compareTo(media);
        }
    }
}
