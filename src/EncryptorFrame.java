import sun.java2d.Disposer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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
    private JButton jbtn4 = new JButton("Clean");
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
        jpl.add(jbtn4);
        jpl.add(jbtn2);
        jpl.add(jbtn3);

        jpl2.add(jlb2);
        jpl2.add(jtf2);
        jpl2.add(jbtn);



        jbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jrb1.isSelected()) {
                    switch (jcb.getSelectedIndex()) {
                        case 0:
                            char data[] = jta.getText().toCharArray();
                            int key = Integer.parseInt(jtf.getText());
                            for (int i = 0; i < data.length; i++) {
                                data[i] = (char) (data[i] + key);
                            }
                            jta.setText(new String(data));
                            break;
                        case 1:
                            char data1[] = jta.getText().toCharArray();
                            char key1[]=jtf.getText().toCharArray();
                            for (int i = 0; i < data1.length; i++) {
                                data1[i]=(char)(data1[i]^key1[i%key1.length]);
                            }
                            jta.setText(new String(data1));
                            break;
                    }
                } else {
                        switch (jcb.getSelectedIndex()) {
                            case 0:
                                char data[] = jta.getText().toCharArray();
                                int key = Integer.parseInt(jtf.getText());
                                for (int i = 0; i < data.length; i++) {
                                    data[i] = (char) (data[i] - key);
                                }
                                jta.setText(new String(data));
                                break;
                            case 1:
                                char data1[] = jta.getText().toCharArray();
                                char key1[] =jtf.getText().toCharArray();
                                for (int i = 0; i < data1.length; i++) {
                                    data1[i] = (char)((data1[i]^key1[i%key1.length]));
                                }
                                jta.setText(new String(data1));
                                break;
                        }

                }
            }
        });
        jbtn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               jta.setText("");
               jtf2.setText("");
            }
        });


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
                jfc.setCurrentDirectory(new File("./"));
                int fileState = jfc.showOpenDialog(null);
                if(fileState == JFileChooser.APPROVE_OPTION){
                    try {
                        File selectFile = jfc.getSelectedFile();
                        jtf2.setText(selectFile.getPath());
                        FileInputStream fis = new FileInputStream(selectFile.getPath());
                        InputStreamReader isr = new InputStreamReader(fis,"UTF8");
//                        FileReader fr  = new FileReader(selectFile.getPath());
                        BufferedReader buf = new BufferedReader(isr);
                        String line;
                        while ((line = buf.readLine())!=null){
                           jta.append(line +"\n");
                        }
                        buf.close();
                        isr.close();
                        fis.close();

                    }catch (IOException ioe){
                        javax.swing.JOptionPane.showMessageDialog(EncryptorFrame.this,ioe.toString());
                    }catch (Exception err){
                        javax.swing.JOptionPane.showMessageDialog(EncryptorFrame.this,err.toString());
                    }
                }


            }
        });
        jbtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setCurrentDirectory(new File("./"));
                int fileState = jfc.showSaveDialog(EncryptorFrame.this);
                if(fileState == JFileChooser.APPROVE_OPTION){
                    try {
                        File outFile = jfc.getSelectedFile();
                        if(!outFile.exists()){
                            outFile.createNewFile();
                        }
                        FileWriter fw = new FileWriter(outFile);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(jta.getText());
                        bw.close();
                        fw.close();

                    }catch (IOException ioe){
                        JOptionPane.showMessageDialog(EncryptorFrame.this,ioe.toString());
                    }catch (Exception err){
                        JOptionPane.showMessageDialog(EncryptorFrame.this,err.toString());
                    }
                }
            }
        });


    }
}
