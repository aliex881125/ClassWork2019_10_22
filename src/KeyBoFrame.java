import jdk.internal.util.xml.impl.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class KeyBoFrame extends JFrame {
    private Container cp;
    private Random random=new Random();
    private String str[]=new String[10];
    private JButton jbtns[] = new JButton[10];
    private String str1[] = {"Exit","Sub"};
    private JPasswordField jlb = new JPasswordField("");
    private JButton jbtns1[] = new JButton[2];
    private JPanel jpl = new JPanel(new GridLayout(4, 3, 3, 3));
    private JPanel jpl2 = new JPanel(new GridLayout(2, 1, 3, 3));
    private MainFrame LoginFrame;
    private String str2 ="";



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
                    LoginFrame.setTextp(new String(jlb.getText()));
                }
            });
        }
        for(int i = 0;i<10;i++) {
            str[i] = Integer.toString(random.nextInt(10));
            for (int j = 0; j < i; j++) {
                if (str[i].equals(str[j])) {
                    i--;
                    break;
                }
            }
        }
         for (int i = 0; i < 10; i++) {
             jbtns[i] = new JButton(str[i]);
             jpl.add(jbtns[i]);
             jbtns[i].setFont(new Font(null, Font.PLAIN, 24));
             jbtns[i].addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     JButton jbt = (JButton) e.getSource();
                     str2=str2+jbt.getText();
                     jlb.setText(str2);
                 }
             });
         }
        }
    }
