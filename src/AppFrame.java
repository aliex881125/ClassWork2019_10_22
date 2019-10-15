import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

public class AppFrame extends JFrame {
    //private Container cp;
    private JMenuBar jmbar = new JMenuBar();
    private JMenu jmFile = new JMenu("File");
    private JMenu jmTool = new JMenu("Tool");
    private JMenu jmHelp = new JMenu("Help");
    private JMenuItem jmexit = new JMenuItem("Exit");
    private JMenuItem jmSetting = new JMenuItem("Setting");
    private JMenuItem jmLogout = new JMenuItem("logout");
    private JMenuItem jmCalculate = new JMenuItem("Calculate");
    private JMenuItem jEncryptor = new JMenuItem("Encryptor");
    private JMenuItem jmAsk = new JMenuItem("Ask");
    private MainFrame LoginFrame;
    private JDesktopPane desktop = new JDesktopPane();
    private EncryptorFrame internalFrame = new EncryptorFrame("Encrypt tool");
    public AppFrame(MainFrame login){
        LoginFrame=login;
        init();
    }
    private void init(){
        //cp=this.getContentPane();
      //  this.setLayout(null);
        this.setBounds(1000,300,500,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("App");
        this.add(desktop);
        desktop.add(internalFrame);


        jmexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jmLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AppFrame.this.setVisible(false);
                AppFrame.this.dispose();
                LoginFrame.setVisible(true);
                LoginFrame.resetData();


            }
        });
        jmCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame1 mf1 = new MainFrame1();
                AppFrame.this.setVisible(false);
                mf1.setVisible(true);
            }
        });
        jEncryptor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                internalFrame.setVisible(true);
                System.out.println("2222222222222");
            }
        });

        this.setJMenuBar(jmbar);
        jmbar.add(jmFile);
        jmbar.add(jmTool);
        jmbar.add(jmHelp);
        jmFile.add(jmexit);
        jmFile.add(jmSetting);
        jmFile.add(jmLogout);
        jmTool.add(jmCalculate);
        jmTool.add(jEncryptor);
        jmHelp.add(jmAsk);
    }
}
