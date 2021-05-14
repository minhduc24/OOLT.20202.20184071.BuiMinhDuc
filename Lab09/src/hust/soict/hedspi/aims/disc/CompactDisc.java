package hust.soict.hedspi.aims.disc;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media;

public class CompactDisc extends Disc implements Playable {

	private String artist;
	
	
	public String getArtist() {
		return artist;
	}

	public ArrayList<Track> getTracks() {
		return tracks;
	}

	private ArrayList<Track> tracks = new ArrayList<>(); 
	
	public CompactDisc(int id, String title, String category, String director, float cost) {
        super(title, category, director);
    }
	
	public CompactDisc(int id, String title, String category, String director, String artist, float cost) {
        super(id, title, category, director, cost);
        this.artist = artist;
    }
	
	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("Already exist");
		} else {
			tracks.add(track);
			System.out.println("Track added");
		}
	}
	
	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Track removed");
		} else 
			System.out.println("Not found Track");
	}
	
	public int getLength() {
		int length = 0;
		for (Track track : tracks) {
			length += track.getLength();
		}
		return length;
	}
	
	@Override
	public void play() {
		for(Track track: tracks) {
            System.out.println("Playing CD: " + track.getTitle() + "CD length: " + track.getLength());
        }
	}
	
	public int compareTo(Media media) {
        if (media instanceof Book) 
            return 1;
        if (media instanceof CompactDisc) {
            CompactDisc disc = (CompactDisc) media;
            if (this.getTracks().size() != disc.getTracks().size()) {
                return this.getTracks().size() - disc.getTracks().size();
            }
            if (this.getLength() != disc.getLength()) {
                return this.getLength() - disc.getLength();
            }
            return this.getTitle().compareTo(disc.getTitle());
        }
        return -1;
    }
}
