package rfid_gui;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author mikay
 */
public class rfidGUI {
    static JButton btnLogin;
    static JLabel lblPass1;
    static JLabel lblUser1;
    static JFrame frmLogin;
    static JTextField txtPass1;
    static JTextField txtUser1;
    static JPanel pnlLogin;
    
    static JFrame frmRegister;
    static JPanel pnlRegister;
    static JButton btnCancel;
    static JButton btnSave1;
    static JComboBox<String> cmbxSection;
    static JLabel lblName;
    static JLabel lblSection;
    static JLabel lblStudentNum;
    static JTextField txtName;
    static JTextField txtStudentNum;
    
    static JFrame frmAccount;
    static JPanel pnlAccount;

    rfidGUI(){
        Login();
        Register();
    }
    static void Login(){
        lblUser1 = new JLabel("Username:");
        lblPass1 = new JLabel("Password:");
        txtUser1 = new JTextField();
        txtPass1 = new JTextField();
        btnLogin = new JButton("Login");
        
        frmLogin = new JFrame("Login");
        frmLogin.setSize(400, 400);
        frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pnlLogin = new JPanel();
        pnlLogin.setLayout(null);
        
        pnlLogin.add(lblUser1);
        lblUser1.setBounds(120, 130, 70, 14);
        pnlLogin.add(txtUser1);
        lblPass1.setBounds(120, 160, 80, 14);
        pnlLogin.add(lblPass1);
        txtUser1.setBounds(190, 130, 70, 20);
        pnlLogin.add(txtPass1);
        txtPass1.setBounds(190, 160, 70, 20);
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
        frmRegister = new JFrame("Add/Register");
        frmRegister.setSize(350, 250);
        frmRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pnlRegister = new JPanel();
        pnlRegister.setLayout(null);
        
        lblName = new JLabel("Name:");
        lblStudentNum = new JLabel("Student no.:");
        lblSection = new JLabel("Section:");
        txtName = new JTextField();
        txtStudentNum = new JTextField();
        cmbxSection = new JComboBox<>(new String[] { "BSCS 2-1", "BSCS 2-2", "BSCS 2-3" });
        btnCancel = new JButton("Cancel");
        btnSave1 = new JButton("Save");
        
        pnlRegister.add(lblName);
        lblName.setBounds(30, 40, 60, 14);
        pnlRegister.add(lblStudentNum);
        lblStudentNum.setBounds(30, 70, 70, 14);
        pnlRegister.add(lblSection);
        lblSection.setBounds(30, 100, 50, 14);        
        pnlRegister.add(txtName);
        txtName.setBounds(70, 40, 120, 20);
        pnlRegister.add(txtStudentNum);
        txtStudentNum.setBounds(100, 70, 120, 20);
        pnlRegister.add(cmbxSection);
        cmbxSection.setBounds(100, 100, 80, 20);
        pnlRegister.add(btnCancel);
        btnCancel.setBounds(60, 150, 80, 20);
        pnlRegister.add(btnSave1);
        btnSave1.setBounds(150, 150, 80, 20);
        
        frmRegister.add(pnlRegister);
        frmRegister.setVisible(true);
    }
    static void Account(){
        frmAccount = new JFrame("Account");
        frmAccount.setSize(300, 200);
        frmAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pnlAccount = new JPanel();
        pnlAccount.setLayout(null);
        
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
