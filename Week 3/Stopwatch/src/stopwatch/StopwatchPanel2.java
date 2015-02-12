//StopwatchPanel.java
package stopwatch;

/**
 * @author Peter Rosner
 * @version 2.0 January 2013
 * Class embodying the panel on which the components of the stopwatch UI sit.
 * Components of the panel set up using drag and drop in NetBeans
 */
public class StopwatchPanel2 extends javax.swing.JPanel  {

    /**
     * Constructor creates new form StopwatchPanel2 (code generated by drag and drop)
     * and registers inner classes of
     * the StopwatchController as listeners for the buttons.
     * @param controller the StopwatchController instance containing inner classes 
     * that act as listeners for the buttons.
     */
    public StopwatchPanel2(StopwatchController controller) {
        initComponents(); //execute initialization code generated by drag and drop
        startButton.addActionListener(controller.new StartActionListener());
        stopButton.addActionListener(controller.new StopActionListener());
        resetButton.addActionListener(controller.new ResetActionListener());
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        timerLabel = new javax.swing.JLabel();

        startButton.setText("Start");

        stopButton.setText("Stop");

        resetButton.setText("Reset");

        timerLabel.setText("         ");
        timerLabel.setMinimumSize(new java.awt.Dimension(100, 16));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(38, 38, 38)
                        .add(startButton)
                        .add(18, 18, 18)
                        .add(stopButton)
                        .add(18, 18, 18)
                        .add(resetButton))
                    .add(layout.createSequentialGroup()
                        .add(143, 143, 143)
                        .add(timerLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(14, 14, 14)
                .add(timerLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(startButton)
                    .add(stopButton)
                    .add(resetButton))
                .add(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton resetButton;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JLabel timerLabel;
    // End of variables declaration//GEN-END:variables
}