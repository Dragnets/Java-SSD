// StopwatchPanel.java

package stopwatch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** Presentation class for a system simulating a stopwatch with start,
 * stop and reset buttons. All components are set up programmatically without
 * drag and drop
 * @version 1.0, Dec 1998
 * @author Fintan Culwin
 * @version 2.0, January 2013
 * @author Pete Rosner
 */
public class StopwatchPanel extends JPanel{
    
    //fields
    private JLabel title;
    private JLabel timerLabel;
    private JLabel entry;
    private JPanel  timerPanel;
    private JPanel  controlPanel;
    private JPanel entryPanel;
    
    private JButton  startButton;
    private JButton  stopButton;
    private JButton  resetButton;
    private JButton  lapButton;
    
   
    /**
     * Constructor creates new StopwatchPanel
     * and registers inner classes of
     * the StopwatchController as listeners for the buttons.
     * @param controller the StopwatchController instance containing inner classes 
     * that act as listeners for the buttons.
     */
    public StopwatchPanel(StopwatchController controller ) {
        initComponents();
        startButton.addActionListener(controller.new StartActionListener());
        stopButton.addActionListener(controller.new StopActionListener());
        resetButton.addActionListener(controller.new ResetActionListener());
        lapButton.addActionListener(controller.new LapActionListener());
        
  
    } 
    
    /**
     * Sets the appropriate sensitivities for the buttons for the stopwatch
     * @param startEnabled Start button enabled/disabled
     * @param stopEnabled Stop button enabled/disabled
     * @param resetEnabled Reset button enabled/disabled
     */
    public void setButtons(boolean startEnabled, boolean stopEnabled, 
            boolean resetEnabled){
        startButton.setEnabled(startEnabled);
        stopButton.setEnabled(stopEnabled);
        resetButton.setEnabled(resetEnabled);
    }
    
    /**
     * passes the time on to the label to display it
     * @param time the time to be displayed
     */
    public void setTime(String time){
        timerLabel.setText(time);
    }
    
    /**
     * Create the subpanels (with their associated layout managers), 
     * label and buttons place them on the subpanels 
     */
    private void initComponents(){
        
        this.setLayout(new BorderLayout());
        //Changed 14/2/2012 to cope with full window not appearing
        title = new JLabel("My Stopwatch");
        timerLabel = new JLabel();
        timerLabel = new JLabel("dummy");//will be immediately overwritten
        timerLabel.setBackground(Color.red);
        timerLabel.setOpaque(true);
        timerPanel    = new JPanel();
        timerPanel.setLayout(new GridLayout(2,1));
        timerPanel.add(title);
        timerPanel.add( timerLabel);
        //controlPanel = new JPanel();
        
        startButton = new JButton(     "Start");
        stopButton = new JButton(     "Stop");
        resetButton = new JButton(     "Reset");
        lapButton = new JButton(        "Lap");
        
        controlPanel    = new JPanel();
        controlPanel.setLayout(new GridLayout(1,4));
        controlPanel.add( startButton);
        controlPanel.add( stopButton);
        controlPanel.add( resetButton);
        controlPanel.add(lapButton);
        
        entry = new JLabel("HELLO");
        entryPanel =new JPanel();
        entryPanel.add(entry);
        
        
        //controlPanel.add(lapButton);
        
        this.add( timerPanel, BorderLayout.NORTH);
        this.add( controlPanel, BorderLayout.WEST);
        this.add( entryPanel, BorderLayout.SOUTH);
    }
} 
