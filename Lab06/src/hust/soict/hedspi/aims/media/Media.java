package hust.soict.hedspi.aims.media;

public class Media {
    protected String title;
    protected String category;
    protected float cost;
    protected int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getcost() {
        return this.cost;
    }

    public void setcost(float cost) {
        this.cost = cost;
    }
    
    public Media() {

    }

    public Media (String title) {
        this.title = title;
    }

    public Media(String title, String category){
        this(title);
        this.category = category;
    }


}
