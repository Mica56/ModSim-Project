package rfid_gui;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author mikay
 */
public class rfidGUI {
    static JButton btnLogin;
    static JLabel lblPass;
    static JLabel lblUser;
    static JFrame frmLogin;
    static JTextField txtPass;
    static JTextField txtUser;
    static JPanel pnlLogin;

    rfidGUI(){
        Login();
    }
    static void Login(){
        lblUser = new JLabel("Username:");
        lblPass = new JLabel("Password:");
        txtUser = new JTextField();
        txtPass = new JTextField();
        btnLogin = new JButton("Login");
        
        frmLogin = new JFrame();
        frmLogin.setSize(400, 400);
        frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pnlLogin = new JPanel();
        //pnlLogin.setLayout(new FlowLayout());
        //pnlLogin.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pnlLogin.setLayout(null);
        
        pnlLogin.add(lblUser);
        lblUser.setBounds(120, 130, 70, 14);
        pnlLogin.add(txtUser);
        lblPass.setBounds(120, 160, 80, 14);
        pnlLogin.add(lblPass);
        txtUser.setBounds(190, 130, 70, 20);
        pnlLogin.add(txtPass);
        txtPass.setBounds(190, 160, 70, 20);
        pnlLogin.add(btnLogin);
        btnLogin.setBounds(160, 210, 70, 23);
        
        frmLogin.add(pnlLogin);
        frmLogin.setVisible(true);
    }
   
    static void MainRecords(){
        
    }
    static void Scan(){
        
    }
    static void Register(){
        
    }
    static void Account(){
        
    }
    static void changeUser(){
        
    }
    static void changePW(){
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(rfidGUI::new // public void run()
        );
    }
    
}
