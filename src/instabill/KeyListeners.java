package instabill;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;

/**
 *
 * @author scorpion
 */
public class KeyListeners implements KeyListener{
    
    private JButton jbutton = null;
    
    public KeyListeners(Object object){
        if(object instanceof JButton){
            this.jbutton = (JButton) object;
        }
    }
        
    public void keyTyped(KeyEvent e) {
        // Invoked when a key has been typed.
    }
    
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
        else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if(jbutton != null){
                jbutton.doClick();
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        // Invoked when a key has been released.
    }
}