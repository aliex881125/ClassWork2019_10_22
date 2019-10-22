import javax.swing.*;
import java.awt.*;

public class GameFrame extends JInternalFrame {
     private Container cp;

    public GameFrame(String title) {
        super(title, true, true, true, true);
        init();
    }
    private void init() {
        cp = this.getContentPane();
        this.setLayout(new BorderLayout(3, 3));
        this.setBounds(10, 30, 600, 600);
    }
}
