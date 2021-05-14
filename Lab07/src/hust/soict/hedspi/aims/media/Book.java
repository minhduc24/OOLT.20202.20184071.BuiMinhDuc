package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{

    private List<String> authors = new ArrayList<String>();

    public List<String> getAuthors() {
        return this.authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }


   public void addAuthor(String authorName) {
       if (authors.contains(authorName)) {
           System.out.println("Already has an author's name !!!");
       } else {
           authors.add(authorName);
           System.out.println("The authors has been added !!!");
       }
   }

   public void removeAuthor(String authorName) {
       if (authors.contains(authorName)) {
           authors.remove(authorName);
           System.out.println("Delete done !!!");
       }
       else {
           System.out.println("The authors not found !!!");
       }
   }

   public Book() {

   };

   public Book(String title){
    super(title);
    }
    
    public Book(String title, String category){
    super(title, category);
    }

    public Book(int id, String title, String category){
        super(id ,title, category);
    }
    
    public Book(int id, String title, String category, float cost) {
        super(id ,title, category, cost);
    }

    public Book(int id, String title, String category, float cost, List<String> authors){
    super(id, title, category, cost);
    this.authors = authors;
    }

}
