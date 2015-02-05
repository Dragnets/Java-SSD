
package simpletimer;

/**
 *Display message in consol
 * @author Raitis
 */
public class Logger {
    
    //Constructor
    public Logger(){
        
    }
    
    
    //This int will be displayet on screen
    private int NumberToDisplay = 1;
    
    public void log(){
        System.out.println(NumberToDisplay);
        this.NumberToDisplay +=1;
    }
    
}
