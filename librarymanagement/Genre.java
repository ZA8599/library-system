package librarymanagement;
import java.io.*;
public class Genre implements Serializable{
    private String genreName;
    private String description;
    
    
    public String getGenreName() {
        return genreName;
    }
    
    
    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String genreName) {
        if(genreName.equals("Fiction")){
            this.description = "Books usually set in the future or in another world or planet";
        }else if (genreName.equals("Romance")){
            this.description = "It's a romance-tinged story about the pitfalls of addiction. It kicks off at a fairground with someone being allergic to cats.\n" +
                    "(Note that: someone in the story has a reputation to salvage.)\n" +
                    "\n" +
                    "And there's a twist! You should tell the story in the form of a diary.";
        }else if (genreName.equals("Action")){
            this.description = "It's a thriller story about a serial killer on the loose again. It kicks off in Arizona with the discovery of a strange cult.\n" +
                    "(Note that: the story takes place in a location where phone calls cannot be made.)\n" +
                    "\n" +
                    "And there's a twist! An unexpected gift will change the direction of the plot.";
        }else{
            this.description="As far as plots go, there are hundreds of different types of plots with a wide range of varieties for each plot. But many stories have a similar plot, even if the story, its universe and the characters are completely different.\n" +
                    "In this generator I mainly focused on the rough ideas of a plot type, like 'gaining a super power of sorts', rather than going very specific, " +
                    "like 'a Latina boy living in a suburban area gains the power of super human strength and uses it to save the world'. You will need to fill in specific details like that yourself.";
        }
        
    }
}
