import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EncryptorFrame extends JInternalFrame {
    private Container cp;
    private JPanel jpl = new JPanel(new GridLayout(12, 1, 3, 3));
    private JPanel jpl2 = new JPanel(new GridLayout(1, 3,2,1));

    private JLabel jlb = new JLabel("Key");
    private JTextField jtf = new JTextField();

    private JLabel jlb1 = new JLabel("Algo");
    private JComboBox<String> jcb = new JComboBox<String>();

    private JLabel jlb2 = new JLabel("File");
    private JTextField jtf2 = new JTextField();

    private JButton jbtn = new JButton("Browse");

    private ButtonGroup bg = new ButtonGroup();
    private JRadioButton jrb1= new JRadioButton("Encrypt");
    private JRadioButton jrb2= new JRadioButton("Decrypt");

    private JButton jbtn1 = new JButton("Star");
    private JButton jbtn2 = new JButton("Save");
    private JButton jbtn3 = new JButton("Exit");

    private JTextArea jta= new JTextArea();
    private JScrollPane jsb= new JScrollPane(jta);

    public EncryptorFrame(String title) {
        super(title, true, true, true, true);
        init();
    }
    private void init(){
        cp=this.getContentPane();
        this.setLayout(new BorderLayout(3,3));
        this.setBounds(10,30,600,600);
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        System.out.println("54561436546");

        cp.add(jpl, BorderLayout.EAST);
        cp.add(jsb, BorderLayout.CENTER);
        cp.add(jpl2, BorderLayout.NORTH);


        jpl.add(jlb);
        jpl.add(jtf);
        jpl.add(jlb1);
        jpl.add(jcb);
        jcb.addItem("Caesar");
        jcb.addItem("Xor");
        jpl.add(jrb1);
        jpl.add(jrb2);
        bg.add(jrb1);
        bg.add(jrb2);
        jpl.add(jbtn1);
        jpl.add(jbtn2);
        jpl.add(jbtn3);

        jpl2.add(jlb2);
        jpl2.add(jtf2);
        jpl2.add(jbtn);


        jbtn3.addActionListener(new ActionListener() {
         @Override
           public void actionPerformed(ActionEvent e) {
           EncryptorFrame.this.setVisible(false);
             }
          });
        jbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                int fileState = jfc.showOpenDialog(null);
                if(fileState == JFileChooser.APPROVE_OPTION){
                    try {
                        File selectFile = jfc.getSelectedFile();
                        jtf2.setText(selectFile.getPath());
                        FileReader fr  = new FileReader(selectFile.getPath());
                        BufferedReader buf = new BufferedReader(fr);
                        String line;
                        while ((line = buf.readLine())!=null){
                           jta.append(line);
                        }

                    }catch (IOException ioe){
                        javax.swing.JOptionPane.showMessageDialog(EncryptorFrame.this,ioe.toString());
                    }catch (Exception err){
                        javax.swing.JOptionPane.showMessageDialog(EncryptorFrame.this,err.toString());
                    }
                }


            }
        });


    }
}
