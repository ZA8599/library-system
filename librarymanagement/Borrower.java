package librarymanagement;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.*;

public class Borrower implements Serializable {
    protected String name;
    protected String borrowDate;
    protected String returnDate;
    protected Books book;
    protected int bookID;
    public Borrower() {
        name = "";
        borrowDate = "";
        returnDate = "";
    }

    public Borrower(Books book) {
        this.book = book;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getBorrowDate() {
        return borrowDate;
    }

    protected void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    protected String getReturnDate() {
        return returnDate;
    }

    protected void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    protected Books getBook() {
        return book;
    }
    
    protected void setBook(Books book) {
        this.book = book;
    }

    protected double calculateLateFee(String borrowDate, String returnDate){
        double lateFee = 0.00;
        long difference;
        double daysBetween = 0.0;
        double dayLate = 0.0;
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        
        try {
	       Date dateBefore = myFormat.parse(borrowDate);
	       Date dateAfter = myFormat.parse(returnDate);
	       difference = dateAfter.getTime()- dateBefore.getTime();
	       daysBetween = (difference / (1000*60*60*24));
               
	       //System.out.println("Number of Days between dates: "+daysBetween);
	 } catch (Exception e) {
	       e.printStackTrace();
	 }
        
        dayLate = daysBetween - 7;
        //System.out.println("DayLate: " + dayLate);
        
        lateFee = 0.00;
        
        return lateFee;
    }
}
