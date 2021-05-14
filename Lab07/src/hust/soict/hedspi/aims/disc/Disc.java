package hust.soict.hedspi.aims.disc;

import hust.soict.hedspi.aims.media.Media;

public class Disc extends Media{
    protected int length;
    protected String director;

    public int getLength() {
        return this.length;
    }

    // public void setLength(int length) {
    //     this.length = length;
    // }

    public String getDirector() {
        return this.director;
    }

    // public void setDirector(String director) {
    //     this.director = director;
    // }
    
    public Disc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public Disc(int id, String title, String category, int length, float cost) {
        super(id, title, category, cost);
        this.length = length;
    }

    public Disc(int id, String title, String category, String director,int length, float cost ) {
        super(id, title, category, cost);
        this.length = length;
        this.director =director;
    }


}
