//ElapsedTimer.java
package stopwatch;

import java.util.Observable;


/** 
 * Class for supplying an elapsed time since reset. Model part of 
 * MVC architecture
 *@author Fintan Culwin 
 *@version 0.1 1998
 *@version 2.0 January 2013 Pete Rosner - now extends Observable
 */
public class ElapsedTimer extends Observable {
    
    
    //The time that the stopwatch was last reset
    private long resetTime = 0;

    //The current time
    private int timeNow = 0; 


    private static final int TENTHS_PER_SECOND = 10;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final int SECONDS_PER_HOUR = 3600;

    /**
     * No argument Constructor 
     */
    public ElapsedTimer() {
        super();
    }

    /**
     * stores the reset time to be the current 
     * system time, notify Observers
     */
    public void reset() {
        resetTime = System.currentTimeMillis();
        timeNow = 0;
        this.setChanged();
        this.notifyObservers(Properties.TIME);
    } // End reset.

    /**
     * returns the elapsed time as the difference between 
     * the current system time and the reset time
     */
    public void changeTime() {
        timeNow = (int)((System.currentTimeMillis()
                - resetTime));
        this.setChanged();
        this.notifyObservers(Properties.TIME);

    } 

    /**
     * Gets the current time for stopwatch
     * formatted according to hours:minutes:seconds:tenths
     * @return the formatted time as String
     */
    public String getTime() {
        long timeNowInTenths = timeNow/100;
        long seconds = (timeNowInTenths / TENTHS_PER_SECOND)
                % SECONDS_PER_MINUTE;
        long tenths = timeNowInTenths % TENTHS_PER_SECOND;
        long minutes = (timeNowInTenths
                / (TENTHS_PER_SECOND * SECONDS_PER_MINUTE))
                % SECONDS_PER_HOUR;
        long hours = timeNowInTenths
                / (TENTHS_PER_SECOND * SECONDS_PER_HOUR);
        String timeString = new String(hours + ":"
                + minutes + ":"
                + seconds + ":"
                + tenths);
        return timeString;
    } 

} // End ElapsedTimer

