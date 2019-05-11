import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ExitSwitch implements KeyListener {

    private KeyListener keyListener;

    public boolean isExit = false;

    public  ExitSwitch (KeyListener ki) {
        this.keyListener = ki;
    }

    public void keyTyped(KeyEvent e) {
        this.keyListener.keyTyped(e);
    }

    public void keyPressed (KeyEvent e) {
        this.keyListener.keyPressed(e);

        if (e.getKeyCode() == KeyEvent.VK_Q) {
            System.exit(0);
        }
    }

    public void keyReleased(KeyEvent e) {

    }

}
