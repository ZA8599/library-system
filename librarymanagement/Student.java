package librarymanagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
public class Student extends Borrower implements Serializable{

    private String matricID; 
    private  int  faculty;
    private double dayLate;
    
    public Student(Books Book, String matricID, String name, int faculty){
        this.book = Book;
        this.matricID = matricID;
        this.faculty = faculty;
        this.name = name;
    }
    
    public boolean equals(Student student){
        return(this.name.equals(student.name)  && this.matricID.equals(student.matricID));
    }
    
    public Student(String matricID, String name, int faculty){
        this.matricID = matricID;
        this.faculty = faculty;
        this.name = name;
    }
    
    public String getMatricID() {
        return matricID;
    }

    public void setMatricID(String matricID) {
        this.matricID = matricID;
    }

    public int getFaculty() {
        return faculty;
    }

    public void setFaculty(int faculty) {
        this.faculty = faculty;
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
            lateFee = dayLate * 0.3;
        }else{
            lateFee = dayLate * 0.5;
        }
        
        //System.out.println("Total Late Day: " + dayLate + "days");
        
        return lateFee;
    }
   
    public double getDayLate(){
        return dayLate;
    }
}
