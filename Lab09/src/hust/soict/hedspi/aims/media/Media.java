package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.disc.CompactDisc;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public abstract class Media {
	protected String title;
	protected String category;
	protected float cost;
	private int id;
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}
	
	public Media(String title) {
		super();
		this.title = title;
	}
	
	public Media(String title, String category) {
		super();
		this.title = title;
		this.category = category;
	}
	
	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public Media(int id, String title, String category, float cost) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (obj instanceof Media){
            Media media = (Media)obj;
            if (this.id == media.getId()) {
                return true;
            }
        }
        return false;
    }
	
	public int compareTo(Media media) {
        if (this instanceof Book && (media instanceof DigitalVideoDisc || media instanceof CompactDisc)) {
            return -1;
        }
        if(this instanceof DigitalVideoDisc && media instanceof CompactDisc)
            return -1;
        if(this instanceof CompactDisc && (media instanceof DigitalVideoDisc || media instanceof Book))
            return 1;
        if(this instanceof DigitalVideoDisc && media instanceof Book)
            return 1;
        return 0;
    }
	
}
