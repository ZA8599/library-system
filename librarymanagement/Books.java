package librarymanagement;
import java.io.*;
public class Books extends Shelf implements Donor, Serializable{
    private String ISBN;
    private String title;
    private String author;
    private Genre genre;
    private String status;
    private int quantity;
    
    public Books(String ISBN, String title, String author, String shelfCode, String position, int quantity){
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.shelfCode = shelfCode;
        this.position = position;
        status = "available";
        this.quantity = quantity;
        genre = new Genre();
    }
    
    public boolean equal(Books book){
        return(this.title.equals(book.title));
    }
    
    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public void setAuthor(String author){
        this.author = author;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public void setQty(int quantity){
        this.quantity = quantity;
    }
    
    public String getISBN(){
        return ISBN;
    }
    
    protected String getTitle(){
        return title;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public String getStatus(){
        return status;
    }
    
    public int getQty(){
        return quantity;
    }
    
    public Genre getGenre(){
        return genre;
    }
    
    protected void Borrow(int quantity){
        this.quantity = quantity - 1;
        if(this.quantity == 0){
            status = "not available";
        }else{
            status = "available";
        }
        System.out.println("Balance Quantity: " + this.quantity);
        System.out.println("Status: " + this.status);
    }
    
    
    protected void Return(int quantity){
        this.quantity = quantity + 1;
        status = "available";
        System.out.println("Balance Quantity: " + this.quantity);
        System.out.println("Status: " + this.status);
    }
    
    public String getDonorSource(String donor){
        String donorSource;
        donorSource = donor;
        
        return donorSource;
    }
    
    public int donateQuantity(int donorQty){
        this.quantity = donorQty;
        return quantity;
    }
    
}
