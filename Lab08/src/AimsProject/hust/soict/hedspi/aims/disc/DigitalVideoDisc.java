package AimsProject.hust.soict.hedspi.aims.disc;

import AimsProject.hust.soict.hedspi.aims.media.Media;

public class DigitalVideoDisc extends Disc implements Playable {
    
    
    
    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost){
        super(id, title, category, director, length, cost);
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
        
    }

    public int compareTo(Media media) {
        if (media instanceof DigitalVideoDisc) {
            if (this.getcost() < media.getcost())
                return -1;
            else
                return 1;
        } else 
            return super.compareTo(media);
    }

}

