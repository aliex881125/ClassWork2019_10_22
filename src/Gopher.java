import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Gopher extends JLabel {
    private ImageIcon img = new ImageIcon("ds.png");
    private ImageIcon img2 = new ImageIcon("explosion_PNG15401.png");
    private Random random = new Random();
    private int x, y;
    private Timer timer, timer1;
    private GameFrame gFrame;
    private int score =0;
    private JLabel jlbscore = new JLabel();//分數顯示器

    public Gopher(GameFrame gframe) {
        gFrame = gframe;

        Image img1 = img.getImage();
        Image newing = img1.getScaledInstance(120,120, Image.SCALE_SMOOTH);
        img =new ImageIcon(newing);

        Image img3 = img2.getImage();
        Image newing1 = img3.getScaledInstance(120,120, Image.SCALE_SMOOTH);
        img2 =new ImageIcon(newing1);

        this.setIcon(img);
        x=random.nextInt(500);
        y=random.nextInt(600);
        this.setBounds(x,y,img.getIconWidth(),img.getIconHeight());

        timer = new Timer((random.nextInt(6)+1)*500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x = random.nextInt(gFrame.getHeight() - 300);
                y = random.nextInt(gFrame.getWidth() - 300);
                Gopher.this.setLocation(x,y);

            }
        });
        timer.start();
        timer1=new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gopher.this.setIcon(null);
                x = random.nextInt(gFrame.getHeight() - 300);
                y = random.nextInt(gFrame.getWidth() - 300);
                Gopher.this.setLocation(x, y);
            }
        });
        Gopher.this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                score++;
                gFrame.setSe(new String(Integer.toString(score)));
                timer.stop();
                timer1.start();
                Gopher.this.setIcon(img2);
                timer.start();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

//       timer.start();
    }
}