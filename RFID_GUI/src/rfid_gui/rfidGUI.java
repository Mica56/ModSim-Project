package rfid_gui;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import java.time.LocalDateTime;
import javax.swing.table.*;
import java.io.*;
/**
 *
 * @author mikay & angelo
 */
public class rfidGUI {
    static JFrame frmLogin, frmRegister, frmchangeUser, frmchangePW;
    static JPanel pnlLogin, pnlRegister, pnlchangeUser, pnlchangePW;
    static JButton btnLogin, btnRegister, btnCancel, btnSave1, btnSave2, btnSave3, btnLogout, btnScan, btnAdd, btnGenerate;
    static JLabel lblPass1, lblUser1, lblName, lblSection, lblStudentNum, lblnUser, lblconUser, lblconPass, lblNewPass, lblconNPass, lbltemp1, lbltemp2, lbltemp3, lbltemp4;
    static JTextField txtUser1, txtName, txtStudentNum, txtnUser, txtconUser, txtconPass, txtNewPass, txtconNPass;
    static JComboBox<String> cmbxSection;
    static JPasswordField txtPass1;
    
    static JFrame frmAccount;
    static JPanel pnlAccount;
    static JButton btnChangePass;
    static JButton btnChangeUser;
    static JLabel lblPass2;
    static JLabel lblUser2;
    
    static JFrame frmMainRecords;
    static JPanel pnlMainRecords;
    JTable tblRecords;
    DefaultTableModel model = new DefaultTableModel(0, 0);
    static JScrollPane scpRecords; 
    static String[] objRecords;
   
    static JFrame frmScan;
    static JPanel pnlScan;
    static JButton btnStop;
    
    LocalDateTime dateNow = LocalDateTime.now();

    rfidGUI(){
        Login();      
    }
    
    public void toExcel(JTable table, File file){
    try{
        TableModel model = table.getModel();
        FileWriter excel = new FileWriter(file);

        for(int i = 0; i < model.getColumnCount(); i++){
            excel.write(model.getColumnName(i) + "\t");
        }

        excel.write("\n");

        for(int i=0; i< model.getRowCount(); i++) {
            for(int j=0; j < model.getColumnCount(); j++) {
                excel.write(model.getValueAt(i,j).toString()+"\t");
            }
            excel.write("\n");
        }

        excel.close();

    }catch(IOException e){ System.out.println(e); }
    }
    
    public void Login(){
        lblUser1 = new JLabel("Username:");
        lblPass1 = new JLabel("Password:");
        txtUser1 = new JTextField();
        txtPass1 = new JPasswordField();
        btnLogin = new JButton("Login");
        btnRegister = new JButton("Register");
        
        frmLogin = new JFrame("Login");
        frmLogin.setSize(400, 400);
        frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLogin.setLocationRelativeTo(null);
        
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
        btnLogin.setBounds(100, 210, 90, 23);
        pnlLogin.add(btnRegister);
        btnRegister.setBounds(200, 210, 90, 23);
        
        frmLogin.add(pnlLogin);
        frmLogin.setVisible(true);
        
        btnRegister.addActionListener((ActionEvent objAE) ->{
            JFrame frmRegister = new JFrame("Register");
            frmRegister.setSize(300,300);
            frmRegister.setLocationRelativeTo(null);
            
            JPanel pnlRegister = new JPanel();
            pnlRegister.setLayout(null);
            
            JLabel lblUserName = new JLabel("Username: ");
            JLabel lblPassWord = new JLabel("Password: ");
            JButton btnRegister1 = new JButton("Register");
            JTextField txtUserName = new JTextField();
            JTextField txtPassWord = new JTextField();
            
            pnlRegister.add(lblUserName);
            lblUserName.setBounds(50, 50, 70, 20);
            
            pnlRegister.add(txtUserName);
            pnlRegister.add(txtPassWord);
            txtUserName.setBounds(130, 50, 100, 20);
            txtPassWord.setBounds(130, 80, 100, 20);
            
            pnlRegister.add(lblPassWord);
            lblPassWord.setBounds(50, 80, 70, 20);
            
            pnlRegister.add(btnRegister1);
            btnRegister1.setBounds(100, 130, 89, 20);
            
            frmRegister.add(pnlRegister);
            frmRegister.setVisible(true);
            
            btnRegister1.addActionListener((ActionEvent e) -> {
                try {
                    String user_name = txtUserName.getText();
                    String pass_word = txtPassWord.getText();
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmodsim","root","pop123123");
                    
                    PreparedStatement query = con.prepareStatement("insert into login_account (Username, Password) values (?, ?)");
                
                    query.setString(1, user_name);
                    query.setString(2, pass_word);
                    
                    int i = query.executeUpdate();
                    
                    System.out.println(i + " records updated.");
                    
                    JOptionPane.showMessageDialog(null, "Registered successfully.");
                    
                    con.close();
                    
                    frmRegister.dispose();
                    
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(rfidGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        });
        
        btnLogin.addActionListener((ActionEvent objAE) -> {
            String userName = txtUser1.getText();
            String passWord = String.valueOf(txtPass1.getPassword());
            String dbUserName = "";
            String dbPassWord = "";
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmodsim","root","pop123123");
                    
                Statement stmt = con.createStatement();
                String query = "select * from login_account where Username ='"+ userName +"' && Password ='"+ passWord +"'";
                
                ResultSet rs = stmt.executeQuery(query);
                
                while (rs.next())   {
                    dbUserName = rs.getString("Username");
                    dbPassWord = rs.getString("Password");
                
                    if (userName.equals(dbUserName) && passWord.equals(dbPassWord)) {
                        JOptionPane.showMessageDialog(null, "Successful Login!");
                    
                        MainRecords();
                        frmLogin.dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Incorrect login credentials. Please try again!");
                    }
                }
                
                con.close();
                    
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(rfidGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public void MainRecords(){
        String column[] = {"ID", "Name", "Student Number", "Date & Time"};
        
        model.setColumnIdentifiers(column);
        
        frmMainRecords = new JFrame("Records");
        frmMainRecords.setSize(600, 650);
        frmMainRecords.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMainRecords.setLocationRelativeTo(null);
        
        pnlMainRecords = new JPanel();
        pnlMainRecords.setLayout(null);
        
        tblRecords = new JTable();//takes objRecords
        scpRecords = new JScrollPane(tblRecords);  // for scrollpane
        cmbxSection = new JComboBox<>(new String[] { "BSCS 2-1", "BSCS 2-2", "BSCS 2-3" });
        btnLogout = new JButton("Logout");
        btnScan = new JButton("Scan");
        btnAdd = new JButton("Add");
        btnGenerate = new JButton("Generate");
        
        tblRecords.setModel(model);
        
        pnlMainRecords.add(cmbxSection);
        cmbxSection.setBounds(60, 50, 250, 20);

        pnlMainRecords.add(btnLogout);
        btnLogout.setBounds(70, 560, 80, 23);

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
        
        cmbxSection.addActionListener((ActionEvent objAE) -> {
            model.setRowCount(0);
        });
        
        btnScan.addActionListener((ActionEvent objAE) -> {
            Scan();
        });
        
        btnAdd.addActionListener((ActionEvent objAE) -> {
            Register();
        });
        
        btnLogout.addActionListener((ActionEvent objAE) -> {
            frmMainRecords.dispose();
            Login(); 
        });
        
        btnGenerate.addActionListener((ActionEvent objAE) -> {
            JFileChooser fc = new JFileChooser();
                int option = fc.showSaveDialog(tblRecords);
                if(option == JFileChooser.APPROVE_OPTION){
                    String filename = fc.getSelectedFile().getName(); 
                    String path = fc.getSelectedFile().getParentFile().getPath();

					int len = filename.length();
					String ext = "";
					String file = "";

					if(len > 4){
						ext = filename.substring(len-4, len);
					}

					if(ext.equals(".xls")){
						file = path + "\\" + filename; 
					}else{
						file = path + "\\" + filename + ".xls"; 
					}
					toExcel(tblRecords, new File(file));
                }
        });
    }
    
    public void Scan(){//should display name & stdnum from db
        frmScan = new JFrame("Scan");
        frmScan.setSize(300, 200);
        frmScan.setLocationRelativeTo(null);
        
        pnlScan = new JPanel();
        pnlScan.setLayout(null);
        
        JComboBox cmbStudent = new JComboBox();
        btnStop = new JButton("Stop");
        JButton btnAdd = new JButton("Add");
        
        pnlScan.add(btnAdd);
        btnAdd.setBounds(170, 120, 60, 20);

        pnlScan.add(btnStop);
        btnStop.setBounds(60, 120, 60, 20);
        
        pnlScan.add(cmbStudent);
        cmbStudent.setBounds(50, 60, 200, 20);
        
        frmScan.add(pnlScan);
        frmScan.setVisible(true);
        
        btnStop.addActionListener((ActionEvent objAE) -> {
            frmScan.dispose();
        });
        
        btnAdd.addActionListener((ActionEvent objAE) -> {
            String student = (String)cmbStudent.getSelectedItem();
            String rsID = "";
            String rsName = "";
            String rsStudentNo = "";
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmodsim","root","pop123123");
                
                Statement stmt = con.createStatement();
                String sql = "select * from student_info where Name = '"+ student +"'";
                
                ResultSet rs = stmt.executeQuery(sql);
                
                while (rs.next())   {
                    rsID = rs.getString("ID");
                    rsName = rs.getString("Name");
                    rsStudentNo = rs.getString("Student_Number");
                    
                    model.addRow(new Object[]{rsID, rsName, rsStudentNo, dateNow});
                }
                
            } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(rfidGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        });
        
        String sql = "select * from student_info";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmodsim","root","pop123123");
            
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())   {
                cmbStudent.addItem(rs.getString("Name"));
            }
            
            con.close();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(rfidGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void Register(){
        frmRegister = new JFrame("Add/Register");
        frmRegister.setSize(350, 250);
        frmRegister.setLocationRelativeTo(null);
        
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
        
        btnSave1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent objAE) {
                String strName = txtName.getText();
                String strStudentNum = txtStudentNum.getText();
                String strSection = (String)cmbxSection.getSelectedItem();
                
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmodsim","root","pop123123");
                    
                    PreparedStatement query = con.prepareStatement("insert into student_info (Name, Student_Number, Section) values (?, ?, ?)");
                
                    query.setString(1, strName);
                    query.setString(2, strStudentNum);
                    query.setString(3, strSection);
                    
                    int i = query.executeUpdate();
                    
                    System.out.println(i + " records updated.");
                    
                    con.close();
                    
                    frmRegister.dispose();
                    
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(rfidGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(rfidGUI::new // public void run()
        );
    }
    
}
