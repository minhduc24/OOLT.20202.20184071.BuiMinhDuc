package hust.soict.hedspi.aims.disc;

import hust.soict.hedspi.aims.media.Media;

/**
 * DigitalVideoDisc
 */

public class DigitalVideoDisc extends Media{
    
    private String director;
    private int length;
        
    
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }    
    
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }    
    

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category) {
        super(title, category);
    }

    public DigitalVideoDisc(String title, String category, String director) {
        super(title, category);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category);
        this.director = director;
        this.length = length;
        this.cost = cost;
        }

    public boolean search (String title) {
        String []parts = title.split("\\s");
        for (int i = 0; i < parts.length; i++) {
            if(this.title.toLowerCase().indexOf(parts[i].toLowerCase()) < 0) 
                return false;
        }
        return true;
    }



}


