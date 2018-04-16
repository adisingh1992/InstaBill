package instabill;

import java.awt.Graphics2D;
import java.awt.SplashScreen;

/**
 * @author scorpion
 */

public class InstaBill {

    public InstaBill(){
        final SplashScreen splash = SplashScreen.getSplashScreen();
        Graphics2D g = splash.createGraphics();
        try {
            Thread.sleep(3000);
        }catch(InterruptedException e){
        }
        splash.close();
    }

    public static void main(String[] args) {
        new InstaBill();
        java.awt.EventQueue.invokeLater(() -> {
            new Login();
        });
    }
}