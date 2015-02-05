package simpletimer;

/**
 * Artefact for displaying an incrementing number in the console window
 * prompted by an event regularly sent by a Swing Timer
 * @author Peter Rosner
 * @version 1.1 September 2007
 */
public class SimpleTimer {
  /**
   creates a SimpleTimerController and kicks it off
   */
  public static void main(String[] args) {
    SimpleTimerController stc = new SimpleTimerController();
    stc.start();
  }
}
