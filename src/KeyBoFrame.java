import jdk.internal.util.xml.impl.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class KeyBoFrame extends JFrame {
    private Container cp;
    private Random random=new Random();
    private String str[] = {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0","00","."};
    private JButton jbtns[] = new JButton[12];
    private String str1[] = {"Exit","Sub"};
    private JPasswordField jlb = new JPasswordField("0");
    private JButton jbtns1[] = new JButton[2];
    private JPanel jpl = new JPanel(new GridLayout(4, 3, 3, 3));
    private JPanel jpl2 = new JPanel(new GridLayout(2, 1, 3, 3));
    private boolean isDotclick = false;
    private boolean isopclik = false;
    private MainFrame LoginFrame;



    public KeyBoFrame(MainFrame Login) {
        LoginFrame=Login;
        init();
    }

    private void init() {
        cp = this.getContentPane();
        this.setLayout(new BorderLayout());
        this.setBounds(100, 150, 500, 600);
       // this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        cp.add(jpl2, BorderLayout.EAST);
        cp.add(jpl, BorderLayout.CENTER);
        cp.add(jlb, BorderLayout.NORTH);
        jlb.setFont(new Font(null,Font.PLAIN,60));
        for (int i =0;i<2;i++){
            jbtns1[i] = new JButton(str1[i]);
            jpl2.add(jbtns1[i]);
            jbtns1[i].setFont(new Font(null, Font.PLAIN, 24));
            jbtns1[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    KeyBoFrame.this.setVisible(false);
                }
            });
            jbtns1[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    LoginFrame.setTextp(new String(jlb.getPassword()));
                }
            });
        }

        for (int i = 0; i < 12; i++) {
            jbtns[i] = new JButton(str[i]);
            jpl.add(jbtns[i]);
            jbtns[i].setFont(new Font(null, Font.PLAIN, 24));
            jbtns[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton jbt = (JButton) e.getSource();
                    int vx = jbt.getText().charAt(0) - '0';
                    if (vx >= 0 && vx <= 9) {
                        double v1 = Double.parseDouble(jlb.getText());
                        if (isopclik) {
                            jlb.setText(" ");
                            isopclik = false;
                        }
                        if (v1 == 0.0f) {
                            if (isopclik) {
                                jlb.setText(jlb.getText() + jbt.getText());
                            } else {
                                jlb.setText(jbt.getText());
                            }
                        } else {
                            jlb.setText(jlb.getText()+jbt.getText());
                        }
                    }
                }
            });
        }
    }
}
