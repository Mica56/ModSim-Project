package rfid_gui;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
/**
 *
 * @author mikay
 */
public class rfidGUI {
    static JFrame frmLogin, frmRegister, frmchangeUser, frmchangePW;
    static JPanel pnlLogin, pnlRegister, pnlchangeUser, pnlchangePW;
    static JButton btnLogin, btnCancel, btnSave1, btnSave2, btnSave3, btnLogout, btnAccount, btnScan, btnAdd, btnGenerate;
    static JLabel lblPass1, lblUser1, lblName, lblSection, lblStudentNum, lblnUser, lblconUser, lblconPass, lblNewPass, lblconNPass, lbltemp1, lbltemp2, lbltemp3, lbltemp4;
    static JTextField txtPass1, txtUser1, txtName, txtStudentNum, txtnUser, txtconUser, txtconPass, txtNewPass, txtconNPass;
    static JComboBox<String> cmbxSection;
    
    static JFrame frmAccount;
    static JPanel pnlAccount;
    static JButton btnChangePass;
    static JButton btnChangeUser;
    static JLabel lblPass2;
    static JLabel lblUser2;
    
    static JFrame frmMainRecords;
    static JPanel pnlMainRecords;
    static JList lstRecords;
    static JScrollPane scpRecords; 
    static String[] objRecords;
   
    static JFrame frmScan;
    static JPanel pnlScan;
    static JButton btnStop;

    rfidGUI(){
        Login();      
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
        
        btnLogin.addActionListener((ActionEvent objAE) -> {
            MainRecords();
            frmLogin.dispose();
        });
    }
   
    static void MainRecords(){
        frmMainRecords = new JFrame("Records");
        frmMainRecords.setSize(600, 650);
        frmMainRecords.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pnlMainRecords = new JPanel();
        pnlMainRecords.setLayout(null);
        
        lstRecords = new JList();//takes objRecords
        scpRecords = new JScrollPane(lstRecords);  // for scrollpane
        cmbxSection = new JComboBox<>(new String[] { "BSCS 2-1", "BSCS 2-2", "BSCS 2-3" });
        btnLogout = new JButton("Logout");
        btnAccount = new JButton("Account");
        btnScan = new JButton("Scan");
        btnAdd = new JButton("Add");
        btnGenerate = new JButton("Generate");
        
        pnlMainRecords.add(cmbxSection);
        cmbxSection.setBounds(60, 50, 250, 20);

        pnlMainRecords.add(btnLogout);
        btnLogout.setBounds(70, 560, 80, 23);

        pnlMainRecords.add(btnAccount);
        btnAccount.setBounds(180, 560, 80, 23);

        pnlMainRecords.add(btnScan);
        btnScan.setBounds(460, 160, 73, 23);

        pnlMainRecords.add(btnAdd);
        btnAdd.setBounds(460, 230, 73, 23);

        pnlMainRecords.add(btnGenerate);
        btnGenerate.setBounds(460, 300, 90, 23);
        
        pnlMainRecords.add(scpRecords);
        scpRecords.setBounds(60, 90, 380, 460);  // for scrollpane
        
        frmMainRecords.add(pnlMainRecords);
        frmMainRecords.setVisible(true); 
        
        btnScan.addActionListener((ActionEvent objAE) -> {
            Scan();
        });
        
        btnAdd.addActionListener((ActionEvent objAE) -> {
            Register();
        });
        
        btnAccount.addActionListener((ActionEvent objAE) -> {
            Account();
        });
        
        btnLogout.addActionListener((ActionEvent objAE) -> {
            frmMainRecords.dispose();
            Login(); 
        });
    }
    
    static void Scan(){//should display name & stdnum from db
        frmScan = new JFrame("Scan");
        frmScan.setSize(300, 200);
        frmScan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pnlScan = new JPanel();
        pnlScan.setLayout(null);
        
        lblName = new JLabel("Name:");
        lblStudentNum = new JLabel("Student no.:");
        btnStop = new JButton("Stop");
        
        pnlScan.add(lblName);
        lblName.setBounds(50, 50, 40, 14);

        pnlScan.add(lblStudentNum);
        lblStudentNum.setBounds(50, 80, 80, 14);

        pnlScan.add(btnStop);
        btnStop.setBounds(120, 120, 60, 20);
        
        frmScan.add(pnlScan);
        frmScan.setVisible(true);
        
        btnStop.addActionListener((ActionEvent objAE) -> {
            frmScan.dispose();
        });
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
        
        btnCancel.addActionListener((ActionEvent objAE) -> {
            frmRegister.dispose();
        });
    }
    
    static void Account(){//display name and pw from db
        frmAccount = new JFrame("Account");
        frmAccount.setSize(300, 200);
        frmAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pnlAccount = new JPanel();
        pnlAccount.setLayout(null);
  
        lblUser2 = new JLabel("Username:");
        lblPass2 = new JLabel("Password:");
        btnChangeUser = new JButton();
        btnChangePass = new JButton();
        lbltemp1 = new JLabel();
        lbltemp2 = new JLabel();
        lbltemp3 = new JLabel();
        lbltemp4 = new JLabel();

        pnlAccount.add(lblUser2);
        lblUser2.setBounds(50, 50, 70, 14);

        pnlAccount.add(lblPass2);
        lblPass2.setBounds(50, 80, 60, 14);

        lbltemp1.setText("Change");
        lbltemp2.setText("username");
        btnChangeUser.setLayout(new BorderLayout());
        btnChangeUser.add(BorderLayout.NORTH,lbltemp1);
        btnChangeUser.add(BorderLayout.SOUTH,lbltemp2);
        pnlAccount.add(btnChangeUser);
        btnChangeUser.setBounds(60, 110, 90, 40);

        lbltemp3.setText("Change");
        lbltemp4.setText("password");
        btnChangePass.setLayout(new BorderLayout());
        btnChangePass.add(BorderLayout.NORTH,lbltemp3);
        btnChangePass.add(BorderLayout.SOUTH,lbltemp4);
        pnlAccount.add(btnChangePass);
        btnChangePass.setBounds(163, 110, 90, 40);
        
        frmAccount.add(pnlAccount);
        frmAccount.setVisible(true);
        
        btnChangeUser.addActionListener((ActionEvent objAE) -> {
            frmAccount.dispose();
            changeUser();
        });
        
        btnChangePass.addActionListener((ActionEvent objAE) -> {
            frmAccount.dispose();
            changePW();
        });
    }
    
    static void changeUser(){
        frmchangeUser = new JFrame("Account");
        frmchangeUser.setSize(300, 200);
        frmchangeUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pnlchangeUser = new JPanel();
        pnlchangeUser.setLayout(null);
        
        lblnUser = new JLabel("New username:");
        lblconUser = new JLabel("Confirm user:");
        btnSave2 = new JButton("Save");
        txtnUser = new JTextField();
        txtconUser = new JTextField();
        
        pnlchangeUser.add(lblnUser);
        lblnUser.setBounds(50, 50, 90, 14);

        pnlchangeUser.add(lblconUser);
        lblconUser.setBounds(50, 80, 80, 14);

        pnlchangeUser.add(btnSave2);
        btnSave2.setBounds(110, 120, 65, 20);
        
        pnlchangeUser.add(txtnUser);
        txtnUser.setBounds(150, 50, 80, 20);
        
        pnlchangeUser.add(txtconUser);
        txtconUser.setBounds(150, 80, 80, 20);
        
        frmchangeUser.add(pnlchangeUser);
        frmchangeUser.setVisible(true);
        
        btnSave2.addActionListener((ActionEvent objAE) -> {
            frmchangeUser.dispose();
        });
    }
    
    static void changePW(){
        frmchangePW = new JFrame("Account");
        frmchangePW.setSize(300, 200);
        frmchangePW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pnlchangePW = new JPanel();
        pnlchangePW.setLayout(null);
        
        lblconPass = new JLabel("Confirm password:");
        lblNewPass = new JLabel("New password:");
        lblconNPass = new JLabel("Confirm new pass:");
        btnSave3 = new JButton("Save");
        txtconPass = new JTextField();
        txtNewPass = new JTextField();
        txtconNPass = new JTextField();
        
        pnlchangePW.add(lblconPass);
        lblconPass.setBounds(40, 20, 115, 14);
        
        pnlchangePW.add(lblNewPass);
        lblNewPass.setBounds(40, 50, 90, 14);

        pnlchangePW.add(lblconNPass);
        lblconNPass.setBounds(40, 80, 110, 14);

        pnlchangePW.add(btnSave3);
        btnSave3.setBounds(110, 120, 65, 20);
        
        pnlchangePW.add(txtconPass);
        txtconPass.setBounds(160, 20, 80, 20);
        
        pnlchangePW.add(txtNewPass);
        txtNewPass.setBounds(160, 50, 80, 20);
        
        pnlchangePW.add(txtconNPass);
        txtconNPass.setBounds(160, 80, 80, 20);
        
        frmchangePW.add(pnlchangePW);
        frmchangePW.setVisible(true);
        
        btnSave3.addActionListener((ActionEvent objAE) -> {
            frmchangePW.dispose();
        });
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(rfidGUI::new // public void run()
        );
    }
    
}
