//Stopwatch.java
package stopwatch;

/**
 * @author Peter Rosner
 * @version 2.0 January 2013
 * Contains main() method for artefact
 * Kicks off the Controller
 */
public class Stopwatch {
    
    /**
     * creates a StopwatchController and starts it up
     */
    public static void main(String[] args) {
        //StopwatchController sc = new StopwatchController();
        StopwatchController sc = new StopwatchController();
        sc.start();
    }
}
