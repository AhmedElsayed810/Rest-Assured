package objects;

public class Order {
    private String id;
    private int bookId;
    private String customerName;
    private String createdBy;
    private int quantity;
    private long timestamp;

    // Getters for Order attributes

    public String getId() {
        return id;
    }


    public int getBookId() {
        return bookId;
    }


    public String getCustomerName() {
        return customerName;
    }



    public String getCreatedBy() {
        return createdBy;
    }



    public int getQuantity() {
        return quantity;
    }



    public long getTimestamp() {
        return timestamp;
    }



}
