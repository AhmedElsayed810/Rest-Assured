package objects;

public class Book {
    private int id;
    private String name;
    private String type;
    private boolean available;

    // Getters for Book attributes
    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getType() {
        return type;
    }


    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
