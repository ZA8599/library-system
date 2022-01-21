package librarymanagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;

public class Librarian extends Borrower implements Serializable{
    private String librarianID; 
    private int position;
    private double dayLate;
    
    public Librarian(Books Book, String libID, String name, int position){
        this.book = Book;
        this.librarianID = libID;
        this.position = position;
        this.name = name;
    }
    
    public Librarian(String librarianID, int position, String name){
        this.librarianID = librarianID;
        this.position = position;
        this.name = name;
    }
    
    public boolean equals(Librarian lib){
        return(this.name.equals(lib.name)  && this.librarianID.equals(lib.librarianID));
    }
    
    public String getLibrarianID() {
        return librarianID;
    }

    public void setLibrarianID(String librarianID) {
        this.librarianID = librarianID;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    
    public void setDayLate(String dayLate){
        this.dayLate = Double.parseDouble(dayLate);
    }
    
    protected double calculateLateFee(String borrowDate, String returnDate){
        double lateFee = 0.00;
        long difference;
        double daysBetween = 0.0;
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
        
        if (dayLate < 1){
            lateFee = 0.00;
        }else if(dayLate < 7){
            lateFee = dayLate * 0.4;
        }else{
            lateFee = dayLate * 0.8;
        }
        
        System.out.println("Total Late Day: " + dayLate + " days");
        
        return lateFee;
    }
    
    public double getDayLate(){
        return dayLate;
    }
}
