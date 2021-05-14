package AimsProject.hust.soict.hedspi.aims.media;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Book extends Media{

    private List<String> authors = new ArrayList<String>();
    private String content;
    private List<String> contenTokens = new ArrayList<String>();
    private Map<String,Integer> wordFrequency = new TreeMap<>();
    
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

    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
        this.processContent();
    }

    public List<String> getContentTokens() {
        return this.contenTokens;
    }

    public Map<String,Integer> getWordFrequency() {
        return this.wordFrequency;
    }

    private void processContent() {
        contenTokens.addAll(Arrays.asList(content.split("\\s+")));
        Collections.sort(contenTokens);
        for (String string : this.contenTokens) {
            Integer i = this.wordFrequency.get(string);
            int value;
            if (i == null) {
                value = 1;
            }
            else {
                value = i + 1;
            }
            this.wordFrequency.put(string, value);
        }
    }

    public String toString() {
        System.out.println("------Book Information------");
        System.out.println("Title: "+this.getTitle());
        System.out.println("Catogory: "+this.getCategory());
        System.out.println("Cost: "+this.getcost());
        System.out.println("Author: "+this.getAuthors());
        System.out.println("Content: "+this.content);
        System.out.println("Content Length: "+this.contenTokens.size());
        System.out.println("Content Token in sorted order: "+this.contenTokens);
        System.out.println("Token List & Frequency: ");
        wordFrequency.forEach((key, value) -> System.out.println("\t"+key+":\t"+value));
        return content;
    }
}
