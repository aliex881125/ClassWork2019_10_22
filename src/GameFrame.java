import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.TimerTask;

public class GameFrame extends JInternalFrame {
     private Container cp;
     private Timer timer;
     private Random random = new Random();
     private JButton jbtn = new JButton("Start");
     private JLabel jlb = new JLabel("分數:");
     private JLabel jlbscore = new JLabel("100");//分數顯示器
     private JLabel jlb1 = new JLabel("時間:");
     private JLabel jlbtime = new JLabel("60");//時間顯示器


     private JPanel jpn = new JPanel(new GridLayout(1,7,2,2));
     private JPanel jpnmos = new JPanel(new GridLayout(3,3,2,2));

     private JLabel jlbmos = new JLabel();
     private JLabel jlbmos1 = new JLabel();
     private JLabel jlbmos2 = new JLabel();
     private JLabel jlbmos3 = new JLabel();
     private JLabel jlbmos4 = new JLabel();
     private JLabel jlbmos5 = new JLabel();
     private JLabel jlbmos6 = new JLabel();
     private JLabel jlbmos7 = new JLabel();
     private JLabel jlbmos8 = new JLabel();
    ImageIcon img = new ImageIcon("ds.png");



    public GameFrame(String title) {
        super(title, true, true, true, true);
        init();
    }
    private void init() {
        cp = this.getContentPane();
        this.setLayout(new BorderLayout(3,3));
        this.setBounds(0, 0, 800, 800);



        jlb.setFont(new Font(null, Font.PLAIN, 24));
        jlb.setBackground(new Color(255,222,100));
        jlb.setOpaque(true);
        jlbscore.setFont(new Font(null, Font.PLAIN, 24));
        jlbscore.setBackground(new Color(255,222,100));
        jlbscore.setOpaque(true);
        jlb1.setFont(new Font(null, Font.PLAIN, 24));
        jlb1.setBackground(new Color(255,222,100));
        jlb1.setOpaque(true);
        jlbtime.setFont(new Font(null, Font.PLAIN, 24));
        jlbtime.setBackground(new Color(255,222,100));
        jlbtime.setOpaque(true);
        jbtn.setFont(new Font(null, Font.PLAIN, 24));

        jlbmos.setIcon(img);
        jlbmos1.setIcon(img);
        jlbmos2.setIcon(img);
        jlbmos3.setIcon(img);
        jlbmos4.setIcon(img);
        jlbmos5.setIcon(img);
        jlbmos6.setIcon(img);
        jlbmos7.setIcon(img);
        jlbmos8.setIcon(img);


//        jlb.setBounds(0,0,60,40);
//        jlbscore.setBounds(70,0,40,40);
//        jlb1.setBounds(100,0,60,40);
//        jlbtime.setBounds(170,0,40,40);
//        jbtn.setBounds(170,0,60,40);
//        jlbmos.setBounds(20,50,20,20);

        cp.add(jpn,BorderLayout.NORTH);
        cp.add(jpnmos,BorderLayout.CENTER);

        jpn.add(jlb);
        jpn.add(jlbscore);
        jpn.add(jlb1);
        jpn.add(jlbtime);
        jpn.add(jbtn);

        jpnmos.add(jlbmos);
        jpnmos.add(jlbmos1);
        jpnmos.add(jlbmos2);
        jpnmos.add(jlbmos3);
        jpnmos.add(jlbmos4);
        jpnmos.add(jlbmos5);
        jpnmos.add(jlbmos6);
        jpnmos.add(jlbmos7);
        jpnmos.add(jlbmos8);

//        cp.add(jlb);
//        cp.add(jlbscore);
//        cp.add(jlb1);
//        cp.add(jlbtime);
//        cp.add(jlbmos);


        jbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boolean selectFlag =false;
            }
        });


    }
}
