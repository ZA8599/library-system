package librarymanagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;

public class Staff extends Borrower implements Serializable{
    private String staffID;
    private int department;
    private double dayLate;
    
    public Staff(Books Book, String staffID, String name, int department){
        this.book = Book;
        this.staffID = staffID;
        this.department = department;
        this.name = name;
    }
    
    public boolean equals(Staff staff){
        return(this.name.equals(staff.name)  && this.staffID.equals(staff.staffID));
    }
    
    public Staff(String staffID, String name, int department){
        this.staffID = staffID;
        this.name = name;
        this.department = department;
    }
    
    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
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
            lateFee = dayLate * 0.5;
        }else{
            lateFee = dayLate * 1.0;
        }
        
        System.out.println("Total Late Day: " + dayLate + " days");
        
        return lateFee;
    }
    
    public double getDayLate(){
        return dayLate;
    }
}
