import javax.swing.*;
import java.awt.*;

public class EncryptorFrame extends JInternalFrame {
    private Container cp;
    private JPanel jpl = new JPanel(new GridLayout(5, 1, 3, 3));
    private JPanel jpl2 = new JPanel(new GridLayout(1, 3, 3, 3));

    private JLabel jlb = new JLabel("Key");
    private JTextField jtf = new JTextField();

    private JLabel jlb1 = new JLabel("Algo");
    private JComboBox<String> jcb = new JComboBox<String>();

    private ButtonGroup bg = new ButtonGroup();
    private JRadioButton jrb1= new JRadioButton("Encrypt");
    private JRadioButton jrb2= new JRadioButton("Decrypt");

    private JTextArea jta= new JTextArea();
    private JScrollPane jsb= new JScrollPane(jta);


    public EncryptorFrame(String title) {
        super(title, true, true, true, true);
        init();
    }
    private void init(){
        cp=this.getContentPane();
        this.setLayout(new BorderLayout(3,3));
        this.setBounds(10,30,300,200);
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        System.out.println("54561436546");

        cp.add(jpl2, BorderLayout.EAST);
        cp.add(jta, BorderLayout.CENTER);
        cp.add(jpl, BorderLayout.NORTH);

        jpl.add(jlb);
        jpl.add(jtf);
        jpl.add(jlb1);
        jcb.addItem("Caesar");
        jcb.addItem("Xor");
        jpl.add(jcb);
        bg.add(jrb1);
        bg.add(jrb2);

    }
}
