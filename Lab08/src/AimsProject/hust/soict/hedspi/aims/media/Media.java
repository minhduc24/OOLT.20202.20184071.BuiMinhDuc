package AimsProject.hust.soict.hedspi.aims.media;

import AimsProject.hust.soict.hedspi.aims.disc.CompactDisc;
import AimsProject.hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public abstract class  Media {
    protected String title;
    protected String category;
    protected float cost;
    protected int id;

    public int getId() {
        return this.id;
    }

    // public void setId(int id) {
    //     this.id = id;
    // }

    public String getTitle() {
        return this.title;
    }

    // public void setTitle(String title) {
    //     this.title = title;
    // }

    public String getCategory() {
        return this.category;
    }

    // public void setCategory(String category) {
    //     this.category = category;
    // }

    public float getcost() {
        return this.cost;
    }

    // public void setcost(float cost) {
    //     this.cost = cost;
    // }
    
    public Media() {

    }

    public Media (String title) {
        this.title = title;
    }

    public Media( String title, String category){
        this.title = title;
        this.category = category;
    }

    public Media (int id, String title, String category) {
        this.id = id;
        this.title = title;
        this.category = category;
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public boolean equals(Object object) {
        Media media = (Media) object;
        if (this.id == media.getId()) {
            return true;
        }
        return false;
    }

    public int compareTo(Media media) {
        if (this instanceof Book && (media instanceof DigitalVideoDisc || media instanceof CompactDisc))
            return -1;
        if(this instanceof DigitalVideoDisc && media instanceof CompactDisc)
            return -1;
        if(this instanceof CompactDisc && (media instanceof DigitalVideoDisc || media instanceof Book))
            return 1;
        if(this instanceof DigitalVideoDisc && media instanceof Book)
            return 1;
        return 0;
    }
}
