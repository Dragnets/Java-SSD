// StopwatchController.java
package stopwatch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


/**
 * Handles events from both the user and timer.
 * Controller part of MVC architecture,
 * contains inner classes to handle each type of event
 * @author peterrosner
 * @version 2.0 January 2013
 */
public class StopwatchController {

   
    private final static int RESET = 1;
    private final static int RUNNING = 2;
    private final static int STOPPED = 3;
    private final static int FREEZE = 4;
    
    
    //The current state
    private int theState = RESET;
    
    //The timer
    private Timer aTimer;
    
    // The Model - the object supplying the stopwatch time
    private ElapsedTimer elapsedTimer;
    
    // The View which displays the stopwatch time
    private StopwatchView theView;
   
    /**
     * Constructor sets up ElapsedTimer (Model) and StopwatchView (View)
     * and gets the View to act as observer to the Model.
     */
    public StopwatchController() {
        elapsedTimer = new ElapsedTimer();
        theView = new StopwatchView(this);
        theView.setResetState();
        elapsedTimer.addObserver(theView);
        aTimer = new Timer(50, new TimerActionListener());
    } 

    
    /**
     * Get the view to display, the ElapsedTimer to reset 
     * (to propagate to the View)
     * and the timer to start
     */
    public void start() {
        theView.show();
        elapsedTimer.reset();
        aTimer.start();
    }

    /**
     * Listener for Start button events. 
     */
    public class StartActionListener implements ActionListener {
        @Override
        /**
         * If in reset state, transition to the running state
         * setting the appropriate button sensitivities, and resetting
         * the ElapsedTimer.
         * @param event the ActionEvent from Start button triggering the listener
         */
        public void actionPerformed(ActionEvent event) {
            if (theState == RESET) {
                //added 14/2/2013
                elapsedTimer.reset();
                //
                theState = RUNNING;
                theView.setRunningState();
            }
        }
    }
    
    /**
     * Listener for Stop button events. 
     */
    public class StopActionListener implements ActionListener {
        @Override
        /**
         * If in running state, transition to the stopped state 
         * setting the appropriate button sensitivities.
         * @param event the ActionEvent from Stop button triggering the listener
         */
        public void actionPerformed(ActionEvent event) {
            if (theState == RUNNING) {
                theState = STOPPED;
                theView.setStoppedState();
            }
        }
    }

    /**
     * Listener for Reset button events
     */
    public class ResetActionListener implements ActionListener {
        @Override
        /**
         * If in stopped state, reset ElapsedTimer (to propagate change to View)
         * and transition to reset state
         * setting the appropriate button sensitivities.
         * @param event the ActionEvent from Reset button triggering the listener
         */
        public void actionPerformed(ActionEvent event) {
            if (theState == STOPPED && theState == FREEZE) {
            } else {
                theState = RESET;
                elapsedTimer.reset();
                theView.setResetState();
            }
        }
    }

    
    /**
     * Listener for Timer events
     */
    public class TimerActionListener implements ActionListener {
        @Override
        /**
         * If in running state, ask ElapsedTimer to change time
         * (will then propagate change to the View to update the display)
         * @param event the ActionEvent from the Timer triggering the listener
         */
        public void actionPerformed(ActionEvent event) {
            if (theState == RUNNING){
                elapsedTimer.changeTime();
            }
        }
    }
    /**
     * If in FREEZE state time FReezes. 
     */
    public class LapActionListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent event){
            if (theState == RUNNING){
                theState = FREEZE;
                theView.setLapstate();
                
            }else{
                theView.setRunningState();
                theState = RUNNING;
            }
                     
        }
    }/**
    public class ResumeActionListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent event){
            if (theState == FREEZE){
                theState = RUNNING;  
                theView.setRunningState();
                
            }
        }
    }
    **/
}

