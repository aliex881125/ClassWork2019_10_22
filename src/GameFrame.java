import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;

public class GameFrame extends JInternalFrame {
    private Container cp;
    private Random random = new Random();
    private JButton jbtn = new JButton("Start");
    private JLabel jlb = new JLabel("分數:");
    private JLabel jlbscore = new JLabel();//分數顯示器
    private JLabel jlb1 = new JLabel("時間:");
    private JLabel jlbtime = new JLabel();//時間顯示器
    private JButton jbtn1 = new JButton("Add Object");
    private Timer timer, timer1;
    private int score = 0;
    private boolean click = true;
    private int x, y;
    private JPanel jpn = new JPanel(new GridLayout(1, 9, 2, 2));
    private JPanel jpn1 = new JPanel();
    private ImageIcon img = new ImageIcon("n5GcuQTOygzMwcjN3EzNilTOxcTMwQ3Lt92Yuc2cthWcuw2cz5SMw9yL6MHc0RHa.jpg");
    private ImageIcon img2 = new ImageIcon("explosion_PNG15403.png");
    private JLabel jlbmos = new JLabel();
    private ArrayList<Gopher> arrayList = new ArrayList<Gopher>();


    public GameFrame(String title) {
        super(title, true, true, true, true);
        init();
    }

    private void init() {
        cp = this.getContentPane();
        this.setLayout(new BorderLayout(3, 3));
        this.setBounds(0, 0, 800, 800);

        Image img1 = img.getImage();
        Image newing = img1.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        img = new ImageIcon(newing);

        Image img3 = img2.getImage();
        Image newing1 = img3.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        img2 = new ImageIcon(newing1);


        x = random.nextInt(GameFrame.this.getHeight() - 300);
        y = random.nextInt(GameFrame.this.getWidth() - 300);
        jlbmos.setBounds(x, y, 100, 100);
        jlbmos.setIcon(img);


        timer = new Timer((random.nextInt(6) + 1) * 500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x = random.nextInt(GameFrame.this.getHeight() - 300);
                y = random.nextInt(GameFrame.this.getWidth() - 300);
                jlbmos.setLocation(x, y);

            }
        });
        timer1 = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jlbmos.setIcon(null);
                    x = random.nextInt(GameFrame.this.getHeight() - 300);
                    y = random.nextInt(GameFrame.this.getWidth() - 300);
                    jlbmos.setLocation(x, y);
                    timer1.stop();
                }
        });


        jlb.setFont(new Font(null, Font.PLAIN, 24));
        jlb.setBackground(new Color(255, 222, 100));
        jlb.setOpaque(true);
        jlbscore.setFont(new Font(null, Font.PLAIN, 24));
        jlbscore.setBackground(new Color(255, 222, 100));
        jlbscore.setOpaque(true);
        jlb1.setFont(new Font(null, Font.PLAIN, 24));
        jlb1.setBackground(new Color(255, 222, 100));
        jlb1.setOpaque(true);
        jlbtime.setFont(new Font(null, Font.PLAIN, 24));
        jlbtime.setBackground(new Color(255, 222, 100));
        jlbtime.setOpaque(true);
        jbtn.setFont(new Font(null, Font.PLAIN, 24));
        jbtn1.setFont(new Font(null, Font.PLAIN, 19));


        cp.add(jpn, BorderLayout.NORTH);
        cp.add(jpn1, BorderLayout.CENTER);


        jpn.add(jlb);
        jpn.add(jlbscore);
        jpn.add(jlb1);
        jpn.add(jlbtime);
        jpn.add(jbtn);
        jpn.add(jbtn1);

        jpn1.add(jlbmos);


        jbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
                jlbmos.repaint();

            }
        });
        jbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gopher tmpGopher = new Gopher(GameFrame.this);
                arrayList.add(tmpGopher);
                tmpGopher.run();
//                arrayList.add(new Gopher(GameFrame.this));
                jpn1.add(arrayList.get(arrayList.size() - 1));
                jpn1.repaint();
                timer.start();

            }
        });
        jlbmos.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                score++;
                timer.stop();
                timer1.start();
                jlbmos.setIcon(img2);
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

    }

    public void setSe(String str) {
        jlbscore.setText(str);
    }
}