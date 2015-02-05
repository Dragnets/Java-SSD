package simpletimer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *Listener class which demonstrates 
 * displaying a continously increasing number
 * @author Raitis
 */
public class Listener2 implements ActionListener {
    
    int nr = -1;
    
    public Listener2(){
        
    }
    
    public void actionPerformed(ActionEvent e){
        System.out.println(nr);
        nr -=1;
    }
}
