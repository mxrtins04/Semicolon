package data.models;

public class Book {
    private int id;
    private String title;
    private String author;
    private int edition;
    private int quantity;
    private String description;
    private String isbn;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getEdition() {
        if(edition <= 13 && edition >= 11)return edition + "th edition";
        if(edition % 10 == 1) return edition + "st edition";
        if(edition % 10 == 2) return edition + "nd edition";
        if(edition % 10 == 3) return edition + "rd edition";
        return edition + "th edition";
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}