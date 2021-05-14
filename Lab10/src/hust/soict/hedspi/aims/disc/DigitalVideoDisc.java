package hust.soict.hedspi.aims.disc;

import hust.soict.hedspi.aims.PlayerException;
import hust.soict.hedspi.aims.media.Media;

public class DigitalVideoDisc extends Disc implements Playable{

	
	public DigitalVideoDisc(String title) {
		super(title);
	}
	public DigitalVideoDisc(String title, String category) {
		super(title,category);
	}
	
	public DigitalVideoDisc(String title, String category, String director) {
		super(title, category, director);
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length) {
		super(title, category, director, length);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost, int length) {
		super(title, category, director, cost, length);
	}
	
	public boolean search(String title) {
		String	[]parts = title.split("\\s");
		for (int i = 0; i <parts.length; i++) {
			if (this.title.toLowerCase().indexOf(parts[i].toLowerCase()) < 0)
				return false;
		}
		return true;
	}
	
	@Override
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		} else 
		throw new PlayerException("ERROR: DVD length is non-positive!");
		}
	
	public int compareTo(Media media) {
        if (media instanceof DigitalVideoDisc) {
            DigitalVideoDisc disc = (DigitalVideoDisc) media;
            if (this.getCost() != disc.getCost()) {
                if (this.getCost() > disc.getCost()) {
					return 1;
				}
				return -1;
            }
            if (this.getLength() != disc.getLength()) {
                return this.getLength() - disc.getLength();
            }
            return this.getTitle().compareTo(disc.getTitle());
        }
        return 1;
    }
}
