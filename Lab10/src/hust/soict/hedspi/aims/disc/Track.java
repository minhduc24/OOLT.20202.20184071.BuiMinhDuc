package hust.soict.hedspi.aims.disc;

import hust.soict.hedspi.aims.PlayerException;

public class Track implements Playable, Comparable<Track> {
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	@Override
	public void play() throws PlayerException {
        if(this.getLength() > 0) {
            System.out.println("Playing Track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        }else {
            throw new PlayerException("ERROR: Track length is non-positive");
        }
    }
	
	public boolean equals(Object obj){
        if (obj instanceof Track){
            Track track = (Track)obj;
            if (this.title.equals(track.getTitle()) && this.length == track.getLength()) {
                return true;
            }
        }
        return false;
	}
	
    public int compareTo(Track track) {
        if (this.getTitle().equals(track.getTitle())) {
            return this.getLength() - track.getLength();
        }
        return this.getTitle().compareTo(track.getTitle());
    }
	
    public String getMessage() {
        return "\nPlaying Track: " + this.getTitle() + "\nTrack length: " + this.getLength();
    }
		
}
