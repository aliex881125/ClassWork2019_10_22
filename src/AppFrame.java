import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppFrame extends JFrame {
    private Container cp;
    private JMenuBar jmbar = new JMenuBar();
    private JMenu jmFile = new JMenu("File");
    private JMenu jmTool = new JMenu("Tool");
    private JMenu jmHelp = new JMenu("Help");
    private JMenuItem jmexit = new JMenuItem("Exit");
    private JMenuItem jmSetting = new JMenuItem("Setting");
    private JMenuItem jmLogout = new JMenuItem("logout");
    private JMenuItem jmCalculate = new JMenuItem("Calculate");
    private JMenuItem jmAsk = new JMenuItem("Ask");
    private MainFrame LoginFrame;
    public AppFrame(MainFrame login){
        LoginFrame=login;
        init();
    }
    public void init(){
        cp=this.getContentPane();
        this.setLayout(null);
        this.setBounds(1000,300,500,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("App");

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

        this.setJMenuBar(jmbar);
        jmbar.add(jmFile);
        jmbar.add(jmTool);
        jmbar.add(jmHelp);
        jmFile.add(jmexit);
        jmFile.add(jmSetting);
        jmFile.add(jmLogout);
        jmTool.add(jmCalculate);
        jmHelp.add(jmAsk);
    }
}
