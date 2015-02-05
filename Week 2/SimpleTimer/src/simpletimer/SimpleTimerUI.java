package simpletimer;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.plaf.*;

/**
 * User interface for Simple Timer
 * This merely shows a title for the artifact, with no user interaction provided
 * @author Peter Rosner
 * @version 2.1 January 2013
 */
public class SimpleTimerUI extends Object{
    
    //The frame in which the label sits
    private JFrame frame;
    
    //The label that sits in the frame
    private JLabel title;
    
    /**
     * Constructor for objects of class SimpleTimerUI
     * Creates the JFrame, setting it up such that the program to exit 
     * when the JFrame is closed.
     * Then it creates the JLabel object which is placed onto the JFrame.
     * Then the JFrame is pack( )ed so that it takes the size of the JLabel.
     */
    public SimpleTimerUI() {
        super();
        this.setResources();
        frame = new JFrame("Simple Timer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        title = new JLabel("This is a Simple Timer");
        frame.add(title);
        frame.pack();
    }//end of constructor
    
    /**
     * Displays the frame and  its contents (i.e. the JLabel)
     */
    public void show() {
        frame.setVisible(true);
    }
    
   /**
   Used to create the default font size and colours
   */
    
    private void setResources() {
        FontUIResource  bigFont   = new FontUIResource(
                new Font( "Dialog", Font.BOLD, 18));
        ColorUIResource defaultBackground = new
                ColorUIResource( Color.white);
        ColorUIResource defaultForeground = new
                ColorUIResource( Color.black);
        
        UIManager.put( "Label.background",
                defaultBackground);
        UIManager.put( "Label.foreground",
                defaultForeground);
        UIManager.put( "Label.font", bigFont);
    } 
}//end of SimpleTimerUI
