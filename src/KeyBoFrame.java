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
    private JButton jbtns1[] = new JButton[2];
    private JPanel jpl = new JPanel(new GridLayout(4, 3, 3, 3));
    private JPanel jpl2 = new JPanel(new GridLayout(2, 1, 3, 3));



    public KeyBoFrame() {
        //InputFrame=Input;
        init();
    }

    private void init() {
        cp = this.getContentPane();
        this.setLayout(new BorderLayout());
        this.setBounds(100, 150, 500, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        cp.add(jpl2, BorderLayout.EAST);
        cp.add(jpl, BorderLayout.CENTER);

        for (int i =0;i<2;i++){
            jbtns1[i] = new JButton(str1[i]);
            jpl2.add(jbtns1[i]);
            jbtns1[i].setFont(new Font(null, Font.PLAIN, 24));
            jbtns1[0].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    KeyBoFrame.this.setVisible(false);
                }
            });
        }

        for (int i = 0; i < 12; i++) {
            jbtns[i] = new JButton(str[i]);
            jpl.add(jbtns[i]);
            jbtns[i].setFont(new Font(null, Font.PLAIN, 24));

        }
    }
}
