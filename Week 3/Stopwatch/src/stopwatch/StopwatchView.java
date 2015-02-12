// StopwatchView.java
package stopwatch;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
//import org.apache.commons.beanutils.BeanUtils;

/** Presentation class for a system simulating a stopwatch with Start,
 * Stop and Reset buttons. This it the View part of the MVC architecture
 * @author Pete Rosner
 * @version 2.1 February 2015
 */

public class StopwatchView implements Observer {
    private StopwatchPanel stopwatchPanel;
    //private StopwatchPanel2 stopwatchPanel;
    private JFrame frame;

    /**
     * The constructor creates the frame and places a panel containing
     * all of the stopwatch components inside it
     */
    public StopwatchView(StopwatchController controller) {

        super();
        this.setResources();

        frame = new JFrame("Stopwatch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stopwatchPanel = new StopwatchPanel(controller);
        //stopwatchPanel = new StopwatchPanel2(controller);

        frame.add(stopwatchPanel);
        frame.pack();
    } 

    /**
     * Displays the frame and  its contents
     */
    public void show() {
        frame.setVisible(true);
    }

    /**
     * if the arg is the string corresponding to time
     * get the value of the time from the Observable object and get the
     * stopwatch panel to display it.
     * @param observable - the Model from which the formatted time is obtained
     * @param arg - the string representing the time property
     */
    @Override
    public void update(Observable observable, Object arg){
        if (arg.equals(Properties.TIME)) {
            stopwatchPanel.setTime(((ElapsedTimer)observable).getTime());
        }
    }

    /**
     * Sets the appropriate sensitivities for the reset state for the stopwatch
     */
    public void setResetState() {
        stopwatchPanel.setButtons(true,false,false);
    } 

    /**
     * Sets the appropriate sensitivities for the running state for the stopwatch
     */
    public void setRunningState() {
        stopwatchPanel.setButtons(false,true,false);
    } 

    /**
     * Sets the appropriate sensitivities for the stopped state for the stopwatch
     */
    public void setStoppedState() {
        stopwatchPanel.setButtons(false,false,true);
    } 

    /**
     * set up the default display properties for fonts and Swing components
     */
    private void setResources() {

        ColorUIResource defaultBackground = new ColorUIResource(Color.white);
        ColorUIResource defaultForeground = new ColorUIResource(Color.black);
        ColorUIResource disabledColor = new ColorUIResource(Color.lightGray);

        FontUIResource smallFont = new FontUIResource(
                new Font("Dialog", Font.BOLD, 12));
        FontUIResource bigFont = new FontUIResource(
                new Font("Dialog", Font.BOLD, 18));

        UIManager.put("Button.background",
                defaultBackground);
        UIManager.put("Button.foreground",
                defaultForeground);
        UIManager.put("Button.disabledText",
                disabledColor);
        UIManager.put("Button.font", smallFont);


        UIManager.put("Label.background",
                defaultBackground);
        UIManager.put("Label.foreground",
                defaultForeground);
        UIManager.put("Label.font", bigFont);

        UIManager.put("Panel.background",
                defaultBackground);
        UIManager.put("Panel.foreground",
                defaultForeground);
    } 
} 

