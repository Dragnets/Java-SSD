package simpletimer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


/** 
 * Timer class which demonstrates receiving 
 * ActionEvents from a source and displaying a continously increasing
 * number in the console output.
 * @author Fintan Culwin
 * @version 1.0, December 1998
 * @author Pete Rosner
 * @version 2.0, January 2013

 */

public class SimpleTimerController implements ActionListener {
 
    //The Swing Timer that generates the events
    private Timer           aTimer;
    
    //The UI class that displays the label
    private SimpleTimerUI   ui;
    
    /**
     * Constructor 
     * creates the UI.
     * Then creates the the Timer object to "tick" every 50 milliseconds and
     * to send an ActionEvent to the actionPerformed() method of this class
     * when the operation phase starts.
     */
    public SimpleTimerController() {
        super();
        ui = new SimpleTimerUI();
        aTimer = new Timer( 500, this);
    }
    
    /**
     *show the UI and kick off the timer to initiate the operation phase
     */
    public void start() {
        ui.show();
        aTimer.start();
    }
    
    /**
     * Method causes the next number to be displayed on the console output 
     * when Timer object "ticks"
     * @param event the ActionEvent created and dispatched
     * by the Timer object (not used for this artifact)
     */
    public void actionPerformed( ActionEvent event) { 
        System.out.println("*");
    } 
    
   
}// end of SimpleTimerController
