import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private Container cp;
    private JLabel jlb = new JLabel("ID");
    private JLabel jlb1 = new JLabel("PW123");
    private JTextField EDT = new JTextField();
    private JPasswordField EDT1 = new JPasswordField();
    private JButton jbtn = new JButton("Login");
    private JButton jbtn1 = new JButton("Exit");



    public MainFrame (){
        init();
    }

    private void init(){
        cp=this.getContentPane();
        this.setLayout(null);
        this.setBounds(1200,200,500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        jlb.setBounds(50,100,50,40);
        jlb1.setBounds(50,150,50,40);
        EDT.setBounds(100,100,200,40);
        EDT1.setBounds(100,150,200,40);
        jbtn.setBounds(320,100,100,40);
        jbtn1.setBounds(320,150,100,40);


        jbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pwd = new String(EDT1.getPassword());
                if("h304".equals(EDT.getText())&&"23323456".equals(pwd)){
                    javax.swing.JOptionPane.showMessageDialog(MainFrame.this,"Successful ! !");
                    //MainFrame1 mf1=new MainFrame1();
                    //mf1.setVisible(true);
                    AppFrame af = new AppFrame(MainFrame.this);
                    af.setVisible(true);
                    MainFrame.this.setVisible(false);
                }else {
                    javax.swing.JOptionPane.showMessageDialog(null,"Error! !");
                }
            }
        });

        jbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        cp.add(jlb);
        cp.add(jlb1);
        cp.add(EDT);
        cp.add(EDT1);
        cp.add(jbtn);
        cp.add(jbtn1);
    }
    public void resetData(){
        EDT.setText("");
        EDT1.setText("");
    }
}
