package hust.soict.hedspi.aims.disc;

import hust.soict.hedspi.aims.media.Media;

public class Disc extends Media {
	private int length;
	private String director;
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	public Disc(String title) {
		super(title);
	}
	
	public Disc(String title, String category) {
		super(title,category);
	}
	
	public Disc(String title, String category, String director) {
		super(title, category);
		this.director = director;
	}
	
	public Disc(String title, String category, String director, int length) {
		super(title, category);
		this.director = director;
		this.length = length;
	}
	
	public Disc(String title, String category, String director,float cost, int length ) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
	}
	
	public Disc(int id, String title, String category, String director,float cost) {
		super(id, title, category, cost);
		this.director = director;
	}
	
}
