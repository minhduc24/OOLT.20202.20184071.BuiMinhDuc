package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Book extends Media{
	
	private int id;
	private List<String>authors = new ArrayList<String>();
	private String content;
    public List<String> contentTokens = new ArrayList<>();
    private Map<String, Integer> wordFrequency = new TreeMap<>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public Book(String title) {
		super(title);
	}
	
	public Book(String title,String category){
		super(title, category);
	}
	
	public Book(int id, String title, String category, float cost) {
		super(title, category, cost);
		this.id = id;
	}	
	
	public Book(String title,String category,List<String> authors){
		super(title, category);
		this.authors = authors;
	}

	
	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) 
			System.out.println("The author already exists");
		else {
			authors.add(authorName);
			System.out.println("Successfully added the author");
		}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("Successfully removed the author");
		} else 
			System.out.println("The author not found");
	}
	
	public void processContent() {
        contentTokens.addAll(Arrays.asList(content.split("\\s+")));
        Collections.sort(contentTokens);
        Iterator<String> iterator = contentTokens.iterator();
        while(iterator.hasNext()) {
            String string = iterator.next();
            if (!wordFrequency.containsKey(string)) {
                wordFrequency.put(string, 1);
            }else {
                int a = wordFrequency.get(string);
                a++;
                wordFrequency.put(string, a);
            }
        }
    }
	    @Override
	    public String toString() {
	    	 System.out.println("---------Book Information-----------");
	         System.out.println("- Title: " + this.getTitle());
	         System.out.println("- Catogory: " + this.getCategory());
	         System.out.println("- Cost: " + this.getCost());
	         System.out.println("- Author: " + this.getAuthors());
	         System.out.println("- Content: " + this.content);
	         System.out.println("- Content Length: " + this.contentTokens.size());
	         System.out.println("- Content Token in sorted order: " + this.contentTokens);
	         System.out.println("- Token List & Frequency: ");
	         wordFrequency.forEach((key, value) -> System.out.println("\t" + key + ": \t" + value));
	         System.out.println("------------------------------------");
	         return content;
	    }

		public int compareTo(Book o) {
			return 0;
		}

}
