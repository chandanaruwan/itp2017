package employee_manage;

import com.mysql.jdbc.Connection;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import db.Database;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import static java.lang.System.getProperty;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;


import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import db.Database;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class home extends javax.swing.JFrame {

    java.sql.Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private Boolean clock = false;

    public home() {
        initComponents();
        le8.setEnabled(false);
        Employee_Registration.setVisible(true);
        Apply_Loan_solako.setVisible(false);
        Employee_Attendance.setVisible(false);
        Employee_Attendance_Review.setVisible(false);
        Employee_Salary.setVisible(false);
        Employee_Leave.setVisible(false);
        LeaveRequest.setVisible(false);
        
        jTextField5.setText("00.00");
        jTextField6.setText("00.00");
       salary11.setText("00.00");
        conn = Database.connect();

        tableUpdate();
        tableload1();
        salarytable();
        tableload7();
        tableloaddelete();

        clock = true;
        new Thread(new Runnable() {

            public void run() {

                try {
                    while (clock) {
                   
                        Date d = new Date();
                        String date = d.toString();
                        String ar[] = date.split(" ");
                        dinaya.setText(ar[3]);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");

        Date date = new Date();

        System.out.println(dateFormat.format(date));
        dawasa.setText(dateFormat.format(date));
        lef7.setText(dateFormat.format(date));

        DateFormat dateFormat1 = new SimpleDateFormat("HH.mm ");

        Date date1 = new Date();

        System.out.println(dateFormat1.format(date1));
        t1.setText(dateFormat1.format(date1));

        out_time.setEnabled(true);
 
        clock = true;
        new Thread(new Runnable() {

            public void run() {

                try {
                    while (clock) {
                        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
                        Date d = new Date();
                        String date = d.toString();
                        String ar[] = date.split(" ");
                        t1.setText(ar[3]);
                        t2.setText(ar[3]);

                        //  Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        at.setText(dateFormat.format(date));
        
    }

    public void tableload1() {

        try {
            String q1 = "SELECT* fROM employee";
            //  String q1 = "SELECT FirstName,LastName,NIC,Dob,Sex,Nationality,Marital,position,joined,teliphone,email,address,bsalary,alowance FROM employee";
            pst = conn.prepareStatement(q1);
            rs = pst.executeQuery();

            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

            
        } catch (Exception e) {
         
        }

    }
public void tableloaddelete(){
    
     try {
            String q1 = "SELECT* fROM deleteemployee";
           
            pst = conn.prepareStatement(q1);
            rs = pst.executeQuery();

            jTable10.setModel(DbUtils.resultSetToTableModel(rs));

           
        } catch (Exception e) {
            
  
}
    
}
 
    public void insertion(String str) {
        try {

            pst = conn.prepareCall(str);
            pst.execute();
            JOptionPane.showConfirmDialog(null, "Successfully Inserted");
        } catch (SQLException | HeadlessException ex) {
            System.out.println(ex);
            JOptionPane.showConfirmDialog(null, "Error.");

        }

    }

    public void updation(String str) {
        try {
            pst = conn.prepareCall(str);
            pst.execute();
            JOptionPane.showConfirmDialog(null, "Successfully Updated");
        } catch (SQLException | HeadlessException ex) {
            System.out.println(ex);
            JOptionPane.showConfirmDialog(null, "Error");
        }
    }

    public void tableload2() {

        try {

            String id = hehe.getText();
         
            String q1 = "SELECT tdate,EmpID,intime FROM attendance where EmpID='" + id + "'";
            pst = conn.prepareStatement(q1);
            rs = pst.executeQuery();

            jTable2.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    public void tableload3() {

        try {
            String id = hehe.getText();

            String q1 = "SELECT tdate,EmpID,intime,outtime FROM attendance WHERE EmpID='" + id + "' ";
            pst = conn.prepareStatement(q1);
            rs = pst.executeQuery();

            jTable2.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }
    
   
    

    public void tableUpdate() {
        try {
            String sql = "Select * from emp_loan";

            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();

            Table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void salarytable() {

        try {

            String q1 = "SELECT*  FROM salary";
            pst = conn.prepareStatement(q1);
            rs = pst.executeQuery();

            salarytable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    public void tableload7() {

        try {
           

            String q7 = " SELECT leaveid,EmpID,Empname,Requestdate,reson,type,leavefrm,leavetill,status FROM emp_leave ";

            pst = conn.prepareStatement(q7);
            rs = pst.executeQuery();

            ltable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {

        }

    }

    public boolean usernameValid() {

        boolean value = false;
        String user = hehe.getText();
        String Sql = "select Empid from employee where Empid=?";
        try {
            pst = conn.prepareStatement(Sql);
            pst.setString(1, user);
            rs = pst.executeQuery();
            if (rs.next()) {
                value = true;

            } else {
                value = false;
            }
        } catch (Exception c) {
            System.out.println(c);
            return value;
        }

        return value;
    }

    public void salaryclear() {

        salary2.setText("");
        salary3.setText("");
        salary3.setText("");
        salary4.setText("");
        salary5.setText("");
        salary6.setText("");
        salary7.setText("");
        salary8.setText("");
        salary9.setText("");
        salary10.setText("");
        jTextField14.setText("");
        jTextField15.setText("");   
        salary15.setText("");
        salary11.setText("");
          jTextArea1.setText(null);
       

    }

    public void differennce() {

        Date stdate = dat.getDate();
        Date endate = date1.getDate();

        int diff = (int) ((endate.getTime() - stdate.getTime()) / (1000 * 60 * 60 * 24 * 365 * 12));

        System.out.println(diff);

        if (diff < 18) {
            JOptionPane.showMessageDialog(this, "Select a proper leave range", "Invalid input", JOptionPane.ERROR_MESSAGE);

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        dinaya = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        dawasa = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        sidePane = new javax.swing.JPanel();
        aabcd = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        Employee_Registration = new javax.swing.JLayeredPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        national = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        position = new javax.swing.JComboBox();
        gender = new javax.swing.JComboBox();
        status = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        dat = new com.toedter.calendar.JDateChooser();
        date1 = new com.toedter.calendar.JDateChooser();
        jLabel26 = new javax.swing.JLabel();
        depart = new javax.swing.JComboBox();
        emp12 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        jTextField7 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton37 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        search_txt = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Apply_Loan_solako = new javax.swing.JLayeredPane();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        search_txt1 = new javax.swing.JTextField();
        search_txt2 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        empi = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        ln3 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        ln2 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        ln1 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        date2 = new com.toedter.calendar.JDateChooser();
        jLabel39 = new javax.swing.JLabel();
        amount = new javax.swing.JComboBox();
        jLabel40 = new javax.swing.JLabel();
        period = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        des = new javax.swing.JTextArea();
        jLabel43 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        search_txt3 = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jTextField10 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        Employee_Attendance = new javax.swing.JLayeredPane();
        jLabel14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        at = new javax.swing.JTextField();
        hehe = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        out_time = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        t2 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        pen = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        in_time = new javax.swing.JButton();
        Employee_Attendance_Review = new javax.swing.JLayeredPane();
        jLabel25 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jButton33 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton34 = new javax.swing.JButton();
        Employee_Leave = new javax.swing.JLayeredPane();
        jLabel36 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        le4 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        ltable = new javax.swing.JTable();
        lef1 = new javax.swing.JTextField();
        lef2 = new javax.swing.JTextField();
        led2 = new com.toedter.calendar.JDateChooser();
        led3 = new com.toedter.calendar.JDateChooser();
        leavetype = new javax.swing.JComboBox();
        jScrollPane9 = new javax.swing.JScrollPane();
        lef3 = new javax.swing.JTextArea();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        LE3 = new javax.swing.JLabel();
        lef7 = new javax.swing.JTextField();
        le8 = new javax.swing.JTextField();
        Employee_Salary = new javax.swing.JLayeredPane();
        salary1 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        salarytable = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        salary10 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        salary2 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        salary3 = new javax.swing.JTextField();
        salary4 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        salary7 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        salary8 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        salary15 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        salary11 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jButton26 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jButton24 = new javax.swing.JButton();
        salary9 = new javax.swing.JTextField();
        jButton36 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel11 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        salary5 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        salary6 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        LeaveRequest = new javax.swing.JLayeredPane();
        jLabel21 = new javax.swing.JLabel();
        txtfrom = new javax.swing.JTextField();
        txtto = new javax.swing.JTextField();
        txtsubj = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextArea();
        jLabel62 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jButton35 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(204, 204, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employee_manage/logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 120));
        jLabel1.getAccessibleContext().setAccessibleName("");

        jPanel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        dinaya.setText("jLabel52");
        jPanel12.add(dinaya);

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, 230, 30));

        jPanel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        dawasa.setText("jLabel51");
        jPanel14.add(dawasa);

        jPanel1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 110, 230, 30));

        jLabel50.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("SOLAKRO PAINTS(PVT) Ltd.");
        jPanel1.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1270, 160));

        sidePane.setBackground(new java.awt.Color(0, 0, 51));
        sidePane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        sidePane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        aabcd.setText("Employee Registration");
        aabcd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aabcdActionPerformed(evt);
            }
        });
        sidePane.add(aabcd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 300, 50));

        jToggleButton4.setText("Request Leaves");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });
        sidePane.add(jToggleButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 300, 50));

        jToggleButton5.setText("Employee Attendace");
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });
        sidePane.add(jToggleButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 300, 50));

        jToggleButton2.setText("Employee Salary Calculations");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        sidePane.add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 300, 50));

        jToggleButton1.setText("Employee Attendance Review");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        sidePane.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 300, 50));

        jToggleButton3.setText("Request Leave Via Email");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        sidePane.add(jToggleButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 340, 290, 50));

        bg.add(sidePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 360, 600));

        Employee_Registration.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 0, 0));
        jTabbedPane1.setForeground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Employee ID:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 23, 99, -1));

        jLabel6.setText("Frist Name:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 61, -1, -1));

        jLabel7.setText("Last Name:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 96, -1, -1));
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 96, 150, -1));

        jLabel8.setText("NIC");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 137, 54, -1));

        jLabel9.setText("Date Of Birth:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 182, -1, -1));

        jLabel10.setText("Sex");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 227, 43, -1));

        jLabel11.setText("Joined Date:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 137, 99, -1));
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 137, 150, -1));

        jLabel15.setText("Nationality:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 23, -1, -1));

        national.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<SELECT>", "Sinhala", "Tamil", "Muslim", "Other" }));
        national.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nationalActionPerformed(evt);
            }
        });
        jPanel2.add(national, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 20, 100, -1));

        jLabel16.setText("Maritial Status:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 61, -1, -1));

        jLabel18.setText("Position:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 99, -1, -1));

        position.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<SELECT>", "Manager", "Employee", "Driver", " ", " " }));
        position.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionActionPerformed(evt);
            }
        });
        jPanel2.add(position, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 99, 100, -1));

        gender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<SELECT>", "Male", "Female" }));
        gender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                genderMouseClicked(evt);
            }
        });
        gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderActionPerformed(evt);
            }
        });
        jPanel2.add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 227, 90, -1));

        status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<SELECT>", "Married", "Unmarried" }));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        jPanel2.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 58, 100, -1));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 150, -1));

        dat.setDateFormatString("YYYY-MM-dd");
        jPanel2.add(dat, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 160, -1));

        date1.setDateFormatString("YYYY-MM-dd");
        jPanel2.add(date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 140, -1));

        jLabel26.setText("Depatment");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 60, -1));

        depart.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<SELECT>", "Sales Department", "Production Department" }));
        depart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departActionPerformed(evt);
            }
        });
        jPanel2.add(depart, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 100, -1));
        jPanel2.add(emp12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 150, -1));

        jTabbedPane1.addTab("Personal information", jPanel2);

        jLabel12.setText("Teliphone:");

        jLabel13.setText("Address:");

        address.setColumns(20);
        address.setRows(5);
        jScrollPane1.setViewportView(address);

        jLabel19.setText("Email");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel12)
                        .addGap(38, 38, 38)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel19))
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(150, 150, 150))
        );

        jTabbedPane1.addTab("Contact Information", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setText("Basic Salary");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 83, -1));
        jPanel4.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 141, 30));
        jPanel4.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 141, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Frist Name", "Last Name", "NIC", "DOB", "SEX", "Nationality", "MAritial Status", "Position", "Joined date", "Teliphone", "Email", "Address", "Basic Salary", "Allowance"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 740, 240));

        jLabel30.setText("Vehicle Allowance");
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel31.setText("Food Allowance");
        jPanel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 90, -1));
        jPanel4.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 140, 30));

        jLabel53.setText("Medical Allowance");
        jPanel4.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 100, -1));

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 140, 30));

        jTabbedPane1.addTab("Salary Information", jPanel4);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 0, 0));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Search By ID Or Name:");

        jButton37.setBackground(new java.awt.Color(102, 255, 0));
        jButton37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user-search-icon1.png"))); // NOI18N
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(jTable10);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Delete Employee Details", jPanel13);

        Employee_Registration.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 750, 460));

        jButton5.setText("SEARCH");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        Employee_Registration.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, 120, 40));
        Employee_Registration.add(search_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 220, 30));

        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Employee_Registration.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 190, 100, 60));

        jButton3.setText("UPDATE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Employee_Registration.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 380, 100, 48));

        jButton6.setText("CLEAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        Employee_Registration.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 290, 100, 51));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("EMPLOYEE REGISTRATION");
        Employee_Registration.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 890, 30));

        jButton7.setText("DELETE");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        Employee_Registration.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 450, 100, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Search by ID or name");
        Employee_Registration.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 140, -1));

        bg.add(Employee_Registration, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 920, 640));

        Apply_Loan_solako.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("APPLY LOAN");
        Apply_Loan_solako.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 830, 41));

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setText("BACK");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 630, 97, -1));

        jButton8.setText("Apply");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 330, 107, 50));

        jButton10.setText("Delete");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 550, 107, 66));

        jButton11.setText("Clear");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 400, 107, 54));
        jPanel5.add(search_txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 220, 131, -1));
        jPanel5.add(search_txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 220, 131, -1));

        jButton14.setText("Search");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 270, 107, 42));

        jButton15.setText("Apply");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 330, 107, 50));

        jButton16.setText("Clear");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 400, 107, 54));

        jButton17.setText("Update");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 470, 107, 64));

        jButton18.setText("Delete");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 550, 107, 66));

        jButton9.setText("Update");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 400, 107, 64));

        Apply_Loan_solako.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 290, 110, 80));

        jLabel37.setText("Loan ID:");
        Apply_Loan_solako.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 98, -1));
        Apply_Loan_solako.add(empi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 119, 26));

        jLabel38.setText("Employee ID:");
        Apply_Loan_solako.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));
        Apply_Loan_solako.add(ln3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 119, -1));

        jLabel41.setText("Salary");
        Apply_Loan_solako.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, -1));
        Apply_Loan_solako.add(ln2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 130, -1));

        jLabel44.setText("name");
        Apply_Loan_solako.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 64, 20));

        ln1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ln1MouseClicked(evt);
            }
        });
        ln1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ln1ActionPerformed(evt);
            }
        });
        Apply_Loan_solako.add(ln1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 119, -1));

        jLabel42.setText("Date:");
        Apply_Loan_solako.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 64, 20));

        date2.setDateFormatString("yyyy-MM-dd");
        Apply_Loan_solako.add(date2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 119, -1));

        jLabel39.setText("Amout:");
        Apply_Loan_solako.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 80, -1));

        amount.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT", "100000.00", "150000.00", "200000.00", "300000.00" }));
        amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountActionPerformed(evt);
            }
        });
        Apply_Loan_solako.add(amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 119, -1));

        jLabel40.setText("Period:");
        Apply_Loan_solako.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));

        period.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT", "15", "20", "25", "30" }));
        period.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                periodActionPerformed(evt);
            }
        });
        Apply_Loan_solako.add(period, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 119, -1));

        des.setColumns(20);
        des.setRows(5);
        jScrollPane5.setViewportView(des);

        Apply_Loan_solako.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 184, -1));

        jLabel43.setText("Description:");
        Apply_Loan_solako.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, -1, -1));

        jLabel45.setText("Search by id");
        Apply_Loan_solako.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 100, 20));
        Apply_Loan_solako.add(search_txt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 110, -1));

        jButton19.setText("Search");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        Apply_Loan_solako.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, 120, 40));

        jButton20.setText("Apply");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        Apply_Loan_solako.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 180, 110, 50));

        jButton21.setText("Clear");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        Apply_Loan_solako.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 250, 110, 50));

        jButton23.setText("Delete");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        Apply_Loan_solako.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 390, 110, 50));

        jButton22.setText("Update");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        Apply_Loan_solako.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 320, 110, 50));
        Apply_Loan_solako.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 93, -1));

        jButton12.setText("check ur installment payment");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        Apply_Loan_solako.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, -1, -1));

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "LoanID", "EmpID", "Name", "Date", "Amount", "installment", "salary", "description", "payment"
            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(Table);

        Apply_Loan_solako.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 740, 124));

        bg.add(Apply_Loan_solako, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 910, 640));

        Employee_Attendance.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("EMPLOYEE ATTENDANCE");
        Employee_Attendance.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 43));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Date:");
        Employee_Attendance.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 130, 40));

        at.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        at.setForeground(new java.awt.Color(51, 51, 255));
        at.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Employee_Attendance.add(at, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 270, 40));

        hehe.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        hehe.setForeground(new java.awt.Color(51, 51, 255));
        Employee_Attendance.add(hehe, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 270, 40));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Arrive Time:");
        Employee_Attendance.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 90, 40));

        t1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t1.setForeground(new java.awt.Color(51, 51, 255));
        t1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Employee_Attendance.add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 230, 40));

        out_time.setBackground(new java.awt.Color(204, 0, 0));
        out_time.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        out_time.setText("OUT");
        out_time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                out_timeActionPerformed(evt);
            }
        });
        Employee_Attendance.add(out_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 120, 100));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Leave Tme:");
        Employee_Attendance.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 120, 50));

        t2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        t2.setForeground(new java.awt.Color(204, 0, 0));
        t2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Employee_Attendance.add(t2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 220, 40));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date", "Employee ID ", "Arrive Time", "Leave Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable2);

        Employee_Attendance.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 780, 130));

        jLabel24.setText("Emp ID:");
        Employee_Attendance.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));
        Employee_Attendance.add(pen, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 120, -1));

        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Employee_Attendance.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, -1, -1));

        in_time.setBackground(new java.awt.Color(51, 51, 255));
        in_time.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        in_time.setText("IN");
        in_time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                in_timeActionPerformed(evt);
            }
        });
        Employee_Attendance.add(in_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 120, 100));

        bg.add(Employee_Attendance, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 920, 630));

        Employee_Attendance_Review.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("EMPLOYEE ATTENDANCE REVIEW");
        Employee_Attendance_Review.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 920, 40));
        Employee_Attendance_Review.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 180, 30));
        Employee_Attendance_Review.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 150, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 0, 255));
        jLabel27.setText("From:");
        Employee_Attendance_Review.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 50, 20));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 0, 0));
        jLabel28.setText("Till:");
        Employee_Attendance_Review.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 114, 90, 20));

        jButton33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton33.setText("Check");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        Employee_Attendance_Review.add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, 90, 50));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(204, 0, 204));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("EmpID:");
        Employee_Attendance_Review.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 124, 90, 30));

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(0, 0, 204));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        Employee_Attendance_Review.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 150, 30));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date", "Employee ID", "InTime", "OutTime"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable3);

        Employee_Attendance_Review.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 750, 200));

        jButton34.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton34.setForeground(new java.awt.Color(0, 153, 0));
        jButton34.setText("Clear");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        Employee_Attendance_Review.add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 210, -1, 40));

        bg.add(Employee_Attendance_Review, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 920, 640));

        Employee_Leave.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("REQUEST LEAVES");
        Employee_Leave.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 45));

        jLabel51.setText("Loan ID:");
        Employee_Leave.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, 20));

        le4.setText("loan Id");
        Employee_Leave.add(le4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 84, 100, 20));

        jLabel54.setText("Employee ID:");
        Employee_Leave.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel55.setText("Name:");
        Employee_Leave.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        jLabel56.setText("Requst Date:");
        Employee_Leave.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, 10));

        jLabel57.setText("Purpose:");
        Employee_Leave.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        jLabel58.setText("TYpe:");
        Employee_Leave.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, -1, 20));

        jLabel59.setText("To:");
        Employee_Leave.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, -1, -1));

        jLabel60.setText("Till:");
        Employee_Leave.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, -1, -1));

        jLabel61.setText("Status:");
        Employee_Leave.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, -1));

        ltable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "EmpID", "Name", "Request date", "purpose", "from", "till", "status", "Title 8", "Title 9"
            }
        ));
        ltable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ltableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ltableMouseEntered(evt);
            }
        });
        jScrollPane8.setViewportView(ltable);

        Employee_Leave.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 850, 110));

        lef1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lef1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lef1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lef1MouseReleased(evt);
            }
        });
        lef1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lef1ActionPerformed(evt);
            }
        });
        Employee_Leave.add(lef1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 140, -1));

        lef2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lef2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lef2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lef2MouseEntered(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lef2MouseClicked(evt);
            }
        });
        lef2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lef2ActionPerformed(evt);
            }
        });
        Employee_Leave.add(lef2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 140, -1));
        Employee_Leave.add(led2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 130, -1));
        Employee_Leave.add(led3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 130, -1));

        leavetype.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        leavetype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<SELECT>", "Full day", "Half day" }));
        leavetype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leavetypeActionPerformed(evt);
            }
        });
        Employee_Leave.add(leavetype, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 120, -1));

        lef3.setColumns(20);
        lef3.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        lef3.setRows(5);
        jScrollPane9.setViewportView(lef3);

        Employee_Leave.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 240, 120));

        jButton29.setText("APPLY");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        Employee_Leave.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, 90, 60));

        jButton30.setText("CLEAR");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        Employee_Leave.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, 90, 60));

        jButton31.setText("DELETE");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        Employee_Leave.add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 330, 90, 70));

        jButton32.setText("UPDATE");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        Employee_Leave.add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 90, 60));

        LE3.setText("********************");
        Employee_Leave.add(LE3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 120, 40));

        lef7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lef7.setForeground(new java.awt.Color(0, 0, 255));
        lef7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Employee_Leave.add(lef7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 140, -1));
        Employee_Leave.add(le8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 120, -1));

        bg.add(Employee_Leave, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 920, 640));

        Employee_Salary.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salary1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        salary1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salary1.setText("EMPLOYEE SALARY CALCULATIONS");
        Employee_Salary.add(salary1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 910, 41));

        salarytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        salarytable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salarytableMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(salarytable);

        Employee_Salary.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 690, 160));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "EMPLOYEE DETAILS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 1, 14), new java.awt.Color(153, 0, 153))); // NOI18N
        jPanel6.setToolTipText("Employee Informations");
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setText("Salary ID");
        jPanel6.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        jPanel6.add(salary10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 60, 20));

        jLabel33.setText("Emp_ ID:");
        jPanel6.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 61, 22));

        salary2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        salary2.setForeground(new java.awt.Color(0, 0, 204));
        salary2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel6.add(salary2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 110, -1));

        jButton13.setForeground(new java.awt.Color(0, 0, 255));
        jButton13.setText("CLICK");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 103, 80, 30));

        jLabel34.setText("Name:");
        jPanel6.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 40, 29));

        salary3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        salary3.setForeground(new java.awt.Color(0, 0, 204));
        salary3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        salary3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salary3MouseClicked(evt);
            }
        });
        jPanel6.add(salary3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 110, -1));

        salary4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        salary4.setForeground(new java.awt.Color(0, 0, 204));
        salary4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel6.add(salary4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 110, -1));

        jLabel52.setText("NIC:");
        jPanel6.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        Employee_Salary.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 270, 260));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "DEDUCTIONS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 1, 14), new java.awt.Color(204, 0, 204))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setText("EPF");
        jPanel7.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 40, -1));

        salary7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        salary7.setForeground(new java.awt.Color(0, 0, 204));
        salary7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        salary7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salary7MouseClicked(evt);
            }
        });
        salary7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salary7ActionPerformed(evt);
            }
        });
        jPanel7.add(salary7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 110, 30));

        jLabel49.setText("WellFare");
        jPanel7.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        salary8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        salary8.setForeground(new java.awt.Color(0, 0, 204));
        salary8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel7.add(salary8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 110, 30));

        jLabel63.setText("ETF");
        jPanel7.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 29, -1));

        salary15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        salary15.setForeground(new java.awt.Color(51, 51, 255));
        salary15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        salary15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salary15MouseClicked(evt);
            }
        });
        jPanel7.add(salary15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 110, 30));

        jLabel64.setText("Other Deductions:");
        jPanel7.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        salary11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        salary11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel7.add(salary11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 110, 30));

        Employee_Salary.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, 250, 270));

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton26.setText("ADD");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 70, 60));

        jButton25.setText("Clear");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 70, 60));

        jButton27.setText("Update");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 70, 60));

        jButton28.setText("Delete");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 70, 60));

        Employee_Salary.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 360, 110));

        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton24.setForeground(new java.awt.Color(255, 0, 0));
        jButton24.setText("Net Salary:");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        salary9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        salary9.setForeground(new java.awt.Color(255, 0, 0));
        salary9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        salary9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salary9ActionPerformed(evt);
            }
        });
        jPanel9.add(salary9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 160, 50));

        jButton36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton36.setForeground(new java.awt.Color(0, 153, 0));
        jButton36.setText("Report");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        Employee_Salary.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, 310, 110));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "REPORT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 1, 14), new java.awt.Color(204, 0, 0))); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane10.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
        );

        Employee_Salary.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 340, 180, 280));

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))), "ALLOWANCES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 1, 14), new java.awt.Color(153, 0, 153))); // NOI18N
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setText("Basic Salary:");
        jPanel11.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 20));

        salary5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        salary5.setForeground(new java.awt.Color(0, 0, 204));
        salary5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel11.add(salary5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 110, -1));

        jLabel47.setText("Vehicle Allowance");
        jPanel11.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        salary6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        salary6.setForeground(new java.awt.Color(0, 0, 204));
        salary6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel11.add(salary6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 110, -1));

        jLabel65.setText("Food Allowance");
        jPanel11.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel66.setText("Medica Allowance:");
        jPanel11.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jTextField14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField14.setForeground(new java.awt.Color(0, 0, 204));
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel11.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 110, 20));

        jTextField15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField15.setForeground(new java.awt.Color(0, 0, 255));
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel11.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 110, -1));

        Employee_Salary.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 290, 260));

        bg.add(Employee_Salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 920, 640));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("REQUESTLlEAVE VIA EMAIL");

        txt.setColumns(20);
        txt.setRows(5);
        jScrollPane12.setViewportView(txt);

        jLabel62.setText("FROM");

        jLabel67.setText("TO:");

        jLabel68.setText("SUBJECT");

        jButton35.setText("EMAIL");

        javax.swing.GroupLayout LeaveRequestLayout = new javax.swing.GroupLayout(LeaveRequest);
        LeaveRequest.setLayout(LeaveRequestLayout);
        LeaveRequestLayout.setHorizontalGroup(
            LeaveRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeaveRequestLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(LeaveRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68))
                .addGap(58, 58, 58)
                .addGroup(LeaveRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtsubj, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtto, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfrom, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(229, 229, 229))
            .addGroup(LeaveRequestLayout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jButton35)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        LeaveRequestLayout.setVerticalGroup(
            LeaveRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeaveRequestLayout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(LeaveRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeaveRequestLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(LeaveRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfrom, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(LeaveRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel67))
                        .addGap(48, 48, 48)
                        .addGroup(LeaveRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtsubj, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel68))
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 203, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeaveRequestLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton35)
                        .addGap(378, 378, 378))))
        );
        LeaveRequest.setLayer(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);
        LeaveRequest.setLayer(txtfrom, javax.swing.JLayeredPane.DEFAULT_LAYER);
        LeaveRequest.setLayer(txtto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        LeaveRequest.setLayer(txtsubj, javax.swing.JLayeredPane.DEFAULT_LAYER);
        LeaveRequest.setLayer(jScrollPane12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        LeaveRequest.setLayer(jLabel62, javax.swing.JLayeredPane.DEFAULT_LAYER);
        LeaveRequest.setLayer(jLabel67, javax.swing.JLayeredPane.DEFAULT_LAYER);
        LeaveRequest.setLayer(jLabel68, javax.swing.JLayeredPane.DEFAULT_LAYER);
        LeaveRequest.setLayer(jButton35, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bg.add(LeaveRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 920, 640));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 1285, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aabcdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aabcdActionPerformed
        aabcd.setBackground(Color.WHITE);
        Employee_Registration.setVisible(true);
        Apply_Loan_solako.setVisible(false);
        Employee_Attendance.setVisible(false);
        Employee_Attendance_Review.setVisible(false);
        Employee_Salary.setVisible(false);
        Employee_Leave.setVisible(false);
         LeaveRequest.setVisible(false);



    }//GEN-LAST:event_aabcdActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        // aabcd.setBackground(Color.WHITE);
        Employee_Registration.setVisible(false);
        Apply_Loan_solako.setVisible(false);
        Employee_Attendance_Review.setVisible(false);
        Employee_Salary.setVisible(false);
        Employee_Attendance.setVisible(false);
        Employee_Leave.setVisible(true);
         LeaveRequest.setVisible(false);

     //   leaveattendance h1 = new leaveattendance();
        //   h1.setVisible(true);
        //  this.dispose();//  
        //   applyloansolako.setVisible(true);
        // applyloansolako.setBackground(Color.WHITE);
        /// applyloansolako.setVisible(true);
        //  Attendance.setVisible(false);// TODO add your handling code here:

    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        aabcd.setBackground(Color.WHITE);
        Employee_Attendance.setVisible(true);
        Employee_Registration.setVisible(false);
        Apply_Loan_solako.setVisible(false);
        Employee_Attendance_Review.setVisible(false);
        Employee_Salary.setVisible(false);
        Employee_Leave.setVisible(false);
        LeaveRequest.setVisible(false);
   //   jLayeredPane1.setVisible(true); 
        // TODO add your handling code here:

    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        emp12.setText("");
        jTextField1.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        //jTextField5.setText("");

        //  JDateChooser date  = new JDateChooser();
        dat.setCalendar(null);
        date1.setCalendar(null);
        //date.setDate("");

        jTextField7.setText("");
        address.setText("");
        jTextField9.setText("");
        search_txt.setText("");
        jTextField11.setText("");
        jTextField12.setText("");
        jTextField5.setText("");
        jTextField6.setText("");

        national.setSelectedIndex(0);
        position.setSelectedIndex(0);
        depart.setSelectedIndex(0);

        status.setSelectedIndex(0);
        gender.setSelectedIndex(0);

        //  gender1.setSelected(false);
        //  gender2.setSelected(false);
        // status1.setSelected(false);
        //  status2.setSelected(false);
        //    tableUpdate();
        //     tableUpdate1();
        //     tableUpdate2();
        // T/ODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        //update employee
        
             boolean bool;
            Validation v = new Validation();
         
         String bb = ((JTextField)dat.getDateEditor().getUiComponent()).getText();
         String jj = ((JTextField)date1.getDateEditor().getUiComponent()).getText();
        
       if (v.isempty(emp12.getText())) {
        
             JOptionPane.showConfirmDialog(rootPane, "Employee ID field is empty", "Error", JOptionPane.ERROR_MESSAGE);       
    }
      
     else if (!v.CheckNumber(emp12.getText())) {
        
        JOptionPane.showConfirmDialog(rootPane, "EmpID field is invalid format,use only numbers", "Error", JOptionPane.ERROR_MESSAGE);       
        }
     
    else if (v.isempty(jTextField1.getText())) {
        
           JOptionPane.showConfirmDialog(rootPane, "Firstname field is empty", "Error", JOptionPane.ERROR_MESSAGE);       
        }
    else if (!v.charactercheck(jTextField1.getText())) {
        
        JOptionPane.showConfirmDialog(rootPane, "firstname field is invalid format,use only characters", "Error", JOptionPane.ERROR_MESSAGE);       
       }
    else if (v.isempty(jTextField3.getText())) {
        
             JOptionPane.showConfirmDialog(rootPane, "lastname field is empty", "Error", JOptionPane.ERROR_MESSAGE);       
          }
    else if (!v.charactercheck(jTextField3.getText())) {
        
        JOptionPane.showConfirmDialog(rootPane, "lastname field is invalid format,use only characters", "Error", JOptionPane.ERROR_MESSAGE);       
       }
         
    else  if (v.isempty(jTextField4.getText())) {
          JOptionPane.showConfirmDialog(rootPane, "nic Field is empty", "Error", JOptionPane.ERROR_MESSAGE);
        
        }
    else if (!v.validID(jTextField4.getText())) {

            JOptionPane.showConfirmDialog(rootPane, "check ur nic Field ,invalid nic", "Error", JOptionPane.ERROR_MESSAGE);       
       
        }  else if (status.getSelectedItem() == "<SELECT>") {
            JOptionPane.showConfirmDialog(rootPane, "are you married or please select !!", "Error", JOptionPane.ERROR_MESSAGE);
            bool = false;
        } else if (position.getSelectedItem() == "<SELECT>") {
            JOptionPane.showConfirmDialog(rootPane, "select ur position ??", "Error", JOptionPane.ERROR_MESSAGE);
            bool = false;
        } else if (gender.getSelectedItem() == "<SELECT>") {
            JOptionPane.showConfirmDialog(rootPane, "select ur gender ??", "Error", JOptionPane.ERROR_MESSAGE);
            bool = false;
        } else if (national.getSelectedItem() == "<SELECT>") {
            JOptionPane.showConfirmDialog(rootPane, "select ur nationality", "Error", JOptionPane.ERROR_MESSAGE);
            bool = false;
        } else if  (depart.getSelectedItem() == "<SELECT>") {
            JOptionPane.showConfirmDialog(rootPane, "select ur department", "Error", JOptionPane.ERROR_MESSAGE);
            bool = false;
        } 
         
    else if (v.isempty(jTextField7.getText())) {
        
          JOptionPane.showConfirmDialog(rootPane, "Teliphone Number field is empty", "Error", JOptionPane.ERROR_MESSAGE);       

         }       
    else if (!v.CheckNumber(jTextField7.getText())) {

               
          JOptionPane.showConfirmDialog(rootPane, "phone number field is invalid format,use only numbers ", "Error", JOptionPane.ERROR_MESSAGE);       
        
          }
    else if (!v.validTNO(jTextField7.getText())) {

          JOptionPane.showConfirmDialog(rootPane, "phone number field is invalid format,use only 10 numbers Begin with 0 ","Error", JOptionPane.ERROR_MESSAGE);       
        
            }
            
            else if (v.isempty(jTextField11.getText())) {
                
      JOptionPane.showConfirmDialog(rootPane, "Email field is empty", "Error", JOptionPane.ERROR_MESSAGE); 
                
            } else if (!v.EmailValidation(jTextField11.getText())) {

              JOptionPane.showConfirmDialog(rootPane, "Enter Valid Email", "Error", JOptionPane.ERROR_MESSAGE);    
                
            } 
      else if (v.isempty(address.getText())) {
        
           JOptionPane.showConfirmDialog(rootPane, "Address field is empty", "Error", JOptionPane.ERROR_MESSAGE);       
      
        
       }
        
           else if (v.isempty(jTextField9.getText())) {
        
             JOptionPane.showConfirmDialog(rootPane, "Basic Salary field is empty", "Error", JOptionPane.ERROR_MESSAGE);       
      
         } else if (!v.CheckNumber(jTextField9.getText())) {
        
        JOptionPane.showConfirmDialog(rootPane, "Basic Salary is invalid format,enter real Value", "Error", JOptionPane.ERROR_MESSAGE);       
        
         } else if (v.isempty(jTextField12.getText())) {
        
             JOptionPane.showConfirmDialog(rootPane, "Vehical Allowance field is empty", "Error", JOptionPane.ERROR_MESSAGE);       
      
         } else if (!v.CheckNumber(jTextField12.getText())) {
        
        JOptionPane.showConfirmDialog(rootPane, "Vehical Allowance is invalid format,use real Value ", "Error", JOptionPane.ERROR_MESSAGE);       
         }
         
         else if (v.isempty(jTextField5.getText())) {
        
           JOptionPane.showConfirmDialog(rootPane, "Food Allowance field is empty ", "Error", JOptionPane.ERROR_MESSAGE);       
               
      
         } else if (!v.CheckNumber(jTextField5.getText())) {
        
        JOptionPane.showConfirmDialog(rootPane, "Food Allowance is invalid format,use real Value ", "Error", JOptionPane.ERROR_MESSAGE);       
         }
         
         
             else if (v.isempty(jTextField6.getText())) {
        
               
             JOptionPane.showConfirmDialog(rootPane, "Medical Allowance field is Empty ", "Error", JOptionPane.ERROR_MESSAGE);          
      
         } else if (!v.CheckNumber(jTextField6.getText())) {
        
        JOptionPane.showConfirmDialog(rootPane, "Medical Allowance is invalid format,use real Value ", "Error", JOptionPane.ERROR_MESSAGE);       
         }
         
    else if (v.isempty(bb)){
        
    JOptionPane.showMessageDialog(null, "Please Select Birth Date", "Warning!", JOptionPane.ERROR_MESSAGE);

        }
    else  if (v.isempty(jj)){
        
    JOptionPane.showMessageDialog(null, "Please Select Join Date", "Warning!", JOptionPane.ERROR_MESSAGE);
    }
        
     else{
                
               
        String temp = (String) national.getSelectedItem();
        String temp1 = (String) position.getSelectedItem();
        String temp2 = (String) gender.getSelectedItem();
        String temp3 = (String) status.getSelectedItem();
        String temp4 = (String) depart.getSelectedItem();

        SimpleDateFormat newdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat newdate1 = new SimpleDateFormat("yyyy-MM-dd");

        String empid = emp12.getText();
        String fname = jTextField1.getText();
        String lname = jTextField3.getText();
        String nic = jTextField4.getText();
        String teli = jTextField7.getText();
        String email = jTextField11.getText();
        String add = address.getText();

        String sal = jTextField9.getText();
        String alo = jTextField12.getText();
        
        
         String food = jTextField5.getText();
        String medi = jTextField6.getText();


                  
        String update_employee = "UPDATE employee SET Empid='"+empid + "', Firstname='" + fname + "',Lastname='" + lname + "',Nic='" + nic + "', Dob='" + bb + "',Sex='" + temp2 + "',Nationality='" + temp + "',marital='" + temp3 + "',position='" + temp2 + "',joined='" + jj + "',teliphone='" + teli + "',email='" + email + "',address='" + add + "',bsalary='" + sal + "',alowance='" + alo + "',department='" + temp4 + "',FoodAllowance='" + food + "',MedicalAllowance='" + medi + "' where EmpID='" + empid + "'";

        try {

            updation(update_employee);

            tableload3();

            tableload1();

        } catch (Exception e) {
            System.out.println(e);

        }

        tableload1();
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//add employee
        
         
            Employee emp =new Employee();
            Validation v = new Validation();
         
             boolean bool;
            SimpleDateFormat newdate1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat newdate2 = new SimpleDateFormat("yyyy-MM-dd");

         String bb = ((JTextField)dat.getDateEditor().getUiComponent()).getText();
         String jj = ((JTextField)date1.getDateEditor().getUiComponent()).getText();
    
      
            
//Validation************************************************************************************************************************
    if (v.isempty(emp12.getText())) {
        
             JOptionPane.showConfirmDialog(rootPane, "Employee ID field is empty", "Error", JOptionPane.ERROR_MESSAGE);       
    }
      
     else if (!v.CheckNumber(emp12.getText())) {
        
        JOptionPane.showConfirmDialog(rootPane, "EmpID field is invalid format,use only numbers", "Error", JOptionPane.ERROR_MESSAGE);       
        }
     //else  if (!searchExisting(emp12.getText())){
      //   JOptionPane.showConfirmDialog(rootPane, "Entered Employee ID is already use,check table and enter employee id ", "Error", JOptionPane.ERROR_MESSAGE);       
       
    else if (v.isempty(jTextField1.getText())) {
        
           JOptionPane.showConfirmDialog(rootPane, "Firstname field is empty", "Error", JOptionPane.ERROR_MESSAGE);       
        }
    else if (!v.charactercheck(jTextField1.getText())) {
        
        JOptionPane.showConfirmDialog(rootPane, "firstname field is invalid format,use only characters", "Error", JOptionPane.ERROR_MESSAGE);       
       }
    else if (v.isempty(jTextField3.getText())) {
        
             JOptionPane.showConfirmDialog(rootPane, "lastname field is empty", "Error", JOptionPane.ERROR_MESSAGE);       
          }
    else if (!v.charactercheck(jTextField3.getText())) {
        
        JOptionPane.showConfirmDialog(rootPane, "lastname field is invalid format,use only characters", "Error", JOptionPane.ERROR_MESSAGE);       
       }
         
    else  if (v.isempty(jTextField4.getText())) {
          JOptionPane.showConfirmDialog(rootPane, "nic Field is empty", "Error", JOptionPane.ERROR_MESSAGE);
        
        }
    else if (!v.validID(jTextField4.getText())) {

            JOptionPane.showConfirmDialog(rootPane, "check ur nic Field ,invalid nic", "Error", JOptionPane.ERROR_MESSAGE);       
       
        }  else if (status.getSelectedItem() == "<SELECT>") {
            JOptionPane.showConfirmDialog(rootPane, "are you married or please select !!", "Error", JOptionPane.ERROR_MESSAGE);
            bool = false;
        } else if (position.getSelectedItem() == "<SELECT>") {
            JOptionPane.showConfirmDialog(rootPane, "select ur position ??", "Error", JOptionPane.ERROR_MESSAGE);
            bool = false;
        } else if (gender.getSelectedItem() == "<SELECT>") {
            JOptionPane.showConfirmDialog(rootPane, "select ur gender ??", "Error", JOptionPane.ERROR_MESSAGE);
            bool = false;
        } else if (national.getSelectedItem() == "<SELECT>") {
            JOptionPane.showConfirmDialog(rootPane, "select ur nationality", "Error", JOptionPane.ERROR_MESSAGE);
            bool = false;
        } else if  (depart.getSelectedItem() == "<SELECT>") {
            JOptionPane.showConfirmDialog(rootPane, "select ur department", "Error", JOptionPane.ERROR_MESSAGE);
            bool = false;
        } 
         
    else if (v.isempty(jTextField7.getText())) {
        
          JOptionPane.showConfirmDialog(rootPane, "Teliphone Number field is empty", "Error", JOptionPane.ERROR_MESSAGE);       

         }       
    else if (!v.CheckNumber(jTextField7.getText())) {

               
          JOptionPane.showConfirmDialog(rootPane, "phone number field is invalid format,use only numbers ", "Error", JOptionPane.ERROR_MESSAGE);       
        
          }
    else if (!v.validTNO(jTextField7.getText())) {

          JOptionPane.showConfirmDialog(rootPane, "phone number field is invalid format,use only 10 numbers","Error", JOptionPane.ERROR_MESSAGE);       
        
            }
            
            else if (v.isempty(jTextField11.getText())) {
                
      JOptionPane.showConfirmDialog(rootPane, "Email field is empty", "Error", JOptionPane.ERROR_MESSAGE); 
                
            } else if (!v.EmailValidation(jTextField11.getText())) {

              JOptionPane.showConfirmDialog(rootPane, "Enter Valid Email", "Error", JOptionPane.ERROR_MESSAGE);    
                
            } 
      else if (v.isempty(address.getText())) {
        
           JOptionPane.showConfirmDialog(rootPane, "Address field is empty", "Error", JOptionPane.ERROR_MESSAGE);       
      
        
       }
        
           else if (v.isempty(jTextField9.getText())) {
        
             JOptionPane.showConfirmDialog(rootPane, "Basic Salary field is empty", "Error", JOptionPane.ERROR_MESSAGE);       
      
         } else if (!v.CheckNumber(jTextField9.getText())) {
        
        JOptionPane.showConfirmDialog(rootPane, "Basic Salary is invalid format,enter real Value", "Error", JOptionPane.ERROR_MESSAGE);       
        
         } else if (v.isempty(jTextField12.getText())) {
        
             JOptionPane.showConfirmDialog(rootPane, "Vehical Allowance field is empty", "Error", JOptionPane.ERROR_MESSAGE);       
      
         } else if (!v.CheckNumber(jTextField12.getText())) {
        
        JOptionPane.showConfirmDialog(rootPane, "Vehical Allowance is invalid format,use real Value ", "Error", JOptionPane.ERROR_MESSAGE);       
         }
         
         else if (v.isempty(jTextField5.getText())) {
        
               jTextField5.setText("ho");
               
      
         } else if (!v.CheckNumber(jTextField5.getText())) {
        
        JOptionPane.showConfirmDialog(rootPane, "Food Allowance is invalid format,use real Value ", "Error", JOptionPane.ERROR_MESSAGE);       
         }
         
         
             else if (v.isempty(jTextField5.getText())) {
        
               jTextField5.setText("00");
               
      
         } else if (!v.CheckNumber(jTextField6.getText())) {
        
        JOptionPane.showConfirmDialog(rootPane, "Medical Allowance is invalid format,use real Value ", "Error", JOptionPane.ERROR_MESSAGE);       
         }
         
    else if (v.isempty(bb)){
        
    JOptionPane.showMessageDialog(null, "Please Select Birth Date", "Warning!", JOptionPane.ERROR_MESSAGE);

        }
    else  if (v.isempty(jj)){
        
    JOptionPane.showMessageDialog(null, "Please Select Join Date", "Warning!", JOptionPane.ERROR_MESSAGE);
    }
         
 //_____________________________________________________________________________________________________________________      
         
         
     else {
       
        emp.setemail( jTextField11.getText());
        emp.setEID( emp12.getText());
        emp.setFname( jTextField1.getText());
        emp.setlname( jTextField3.getText());
        emp.setnic(jTextField4.getText());
  
            
          String bbb = ((JTextField)dat.getDateEditor().getUiComponent()).getText();
           emp.setdob(bb);
            
          
         String jjj = ((JTextField)date1.getDateEditor().getUiComponent()).getText();
         emp.setjoin(jjj);
            
            
          
             
        emp.setnational((String) national.getSelectedItem()) ; 
        emp.setposition((String) position.getSelectedItem());
        emp.setgender((String) gender.getSelectedItem());
        emp.setstatus((String) status.getSelectedItem());
        emp.setdepart((String) depart.getSelectedItem());       
            
        
        
        emp.setteli( jTextField7.getText());
        emp.setemail( jTextField11.getText());
        emp.setaddress(address.getText());
        
        
        emp.setbasic( jTextField9.getText());
        emp.setallowance( jTextField12.getText());
        emp.setfood( jTextField5.getText());
        emp.setmedical( jTextField6.getText());
      
               
        
   emp.addemployee();
   
   
        // tableload1(); 
        /*
         JOptionPane.showMessageDialog(null, "Employee Add Succefully");   
      
                    }
                catch (Exception e) {
                        System.out.println(e);
                         JOptionPane.showMessageDialog(null, "Try Again");   
      
                    }
                    tableload1();
          
            */

    //*****
     
    }//GEN-LAST:event_jButton2ActionPerformed


    }
   
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String Search_name = search_txt.getText();

        try {
            String sql = "select * from employee where Firstname like '%" + Search_name + "%' or EmpID ='" + Search_name + "'";
            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();

            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
          
        } catch (Exception e) {
        }

     
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //mouse clicked update employee

        int r = jTable1.getSelectedRow();

        SimpleDateFormat dob1 = new SimpleDateFormat("yyyy-MM-dd");

        //  Date a=dob1.parse(Dob);
        //   dat.setDate(a);
        String eid = jTable1.getValueAt(r, 0).toString();

        String name = jTable1.getValueAt(r, 1).toString();
        String lname = jTable1.getValueAt(r, 2).toString();
        String nic = jTable1.getValueAt(r, 3).toString();
        String teli = jTable1.getValueAt(r, 10).toString();
        String email = jTable1.getValueAt(r, 11).toString();
        String add = jTable1.getValueAt(r, 12).toString();
        String basic = jTable1.getValueAt(r, 13).toString();
        String alo = jTable1.getValueAt(r, 14).toString();
        
        String fd = jTable1.getValueAt(r, 16).toString();
        String med = jTable1.getValueAt(r, 17).toString();
      //  String temp4 = jTable1.getValueAt(r, 8).toString();
        // String temp2= gender.setSelectedItemgetValueAt(r, 5).toString();
        //.. String temp4 = jTable1.getValueAt(r.5).toString();

        // String dob=jTable1.getValueAt(r, 4).toString();
        String tt = jTable1.getValueAt(r, 5).toString();
        String tt1 = jTable1.getValueAt(r, 6).toString();
        String tt2 = jTable1.getValueAt(r, 7).toString();
        String tt3 = jTable1.getValueAt(r, 8).toString();
        String tt4 = jTable1.getValueAt(r, 15).toString();

        String dob = jTable1.getValueAt(r, 4).toString();
        String ttt = jTable1.getValueAt(r, 9).toString();

        //  position.setSelectedItem.getValueAt(r, 5).toString());
        // national. (String) national.getSelectedItem();
        // String temp1 = (String) position.getSelectedItem();
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate;
        Date newDate2;
        try {
            newDate = simple.parse(dob);
            dat.setDate(newDate);
            newDate2 = simple.parse(ttt);
            date1.setDate(newDate2);

        } catch (ParseException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }

        depart.setSelectedItem(tt4);
        position.setSelectedItem(tt3);
        status.setSelectedItem(tt2);
        national.setSelectedItem(tt1);
        gender.setSelectedItem(tt);

        emp12.setText(eid);
        jTextField1.setText(name);
        jTextField3.setText(lname);
        jTextField4.setText(nic);

        jTextField7.setText(teli);
        jTextField11.setText(email);

        address.setText(add);
        jTextField9.setText(basic);
        jTextField12.setText(alo);
        jTextField5.setText(fd);
        jTextField6.setText(med);
        
        
       // position.setText(posi);

        //      position.setSelectedItem(posi);
// TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        //boolean bool;
        //      if(status.getSelectedItem()=="<SELECT>")
        //         {
        //            JOptionPane.showConfirmDialog(rootPane, "are you married or ??", "Error", JOptionPane.ERROR_MESSAGE);
        //            bool =false;
        //        }
    }//GEN-LAST:event_statusActionPerformed

    private void genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderActionPerformed
        //  boolean bool;
        //    if(gender.getSelectedItem()=="<SELECT>")
        //       {
        //          JOptionPane.showConfirmDialog(rootPane, "Select a gender", "Error", JOptionPane.ERROR_MESSAGE);
        //          bool =false;
        //      }
        // TODO add your handling code here:
    }//GEN-LAST:event_genderActionPerformed

    private void positionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionActionPerformed
        //     boolean bool;
        //    if(position.getSelectedItem()=="<SELECT>")
        //       {
        //            JOptionPane.showConfirmDialog(rootPane, "Select a position", "Error", JOptionPane.ERROR_MESSAGE);
        //           bool =false;
        //       } 
    }//GEN-LAST:event_positionActionPerformed

    private void nationalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nationalActionPerformed
  //        boolean bool;
        //      if(national.getSelectedItem()=="<SELECT>")
        //          {
        //              JOptionPane.showConfirmDialog(rootPane, "Select your national", "Error", JOptionPane.ERROR_MESSAGE);
        //              bool =false;
        //          } //boolean result = false;
        //if (national.getSelectedIndex() > 0) {`

        //    result = true;
    }//GEN-LAST:event_nationalActionPerformed
    //}
    
    public boolean CheckOutToday(String eid,String date){
    
        boolean ans = false;
        String sql = "SELECT outtime FROM attendance WHERE EmpID='"+ eid +"' AND tdate = '" + date + "'";
        
        try {
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                
                String Date1 = rs.getString("outtime");
                if (Date1 == null) {
                    ans = true;
                }
                
            }
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null,e);
        }
        System.out.println(ans);    
        return ans;
    }
    
    private void out_timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_out_timeActionPerformed

        in_time.setEnabled(true);
        out_time.setEnabled(true);

        String tt = hehe.getText();
        String ment = t2.getText();
        String D1 = at.getText();
        
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss"); 

        String updateatt = " UPDATE attendance SET outtime='" + ment + "' where EmpID='" + tt + "'";

        if (!tt.isEmpty()) {
        
         if (searchExisting(hehe.getText())) {
            
      
           if (CheckOutToday(tt,D1)) {
              
                updation(updateatt);

                tableload3();
             
                hehe.setText("");
           }
           
           
              else{
            
                    JOptionPane.showMessageDialog(null, "Customer Already Off");
       
        }}
         else {
                  JOptionPane.showMessageDialog(null, "Please Enter Existing Employee Number");   
                   
         }}  
        
           else{
         
                  JOptionPane.showMessageDialog(null, "Emplyee Field Empty!!!");  
              
        }
    }//GEN-LAST:event_out_timeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        SimpleDateFormat newdate3 = new SimpleDateFormat("yyyy-MM-dd");

        String to = newdate3.format(pen.getCalendar().getTime());

        try {
            String sql = "select tdate,EmpID,intime from attendance where tdate ='" + to + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            //pst.execute();

            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            //tax_tableload();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "not anyone");
            //       JOptionPane.showMessageDialog(null,e);
        }
        pen.setCalendar(null);
        /*
         try {
    
         // SimpleDateFormat newdate3= new SimpleDateFormat("yyyy-MM-dd");
            
         //       String to = newdate3.format(pen.getCalendar().getTime());
         String sq ="select count(tdate) from attendance where tdate ='"+to+ "'  " ;                   
         pst =conn.prepareStatement(sq);
         rs = pst.executeQuery();
            
         jj.setText(rs.getString(sq));
            
         } 
         catch (Exception e) 
         {
            
         JOptionPane.showMessageDialog(null,"Error Searching");
         JOptionPane.showMessageDialog(null,e);
         }
    
    
         */

    }//GEN-LAST:event_jButton1ActionPerformed


    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

   //Employee Delete
        
        
        String temp = (String) national.getSelectedItem();
        String temp1 = (String) position.getSelectedItem();
        String temp2 = (String) gender.getSelectedItem();
        String temp3 = (String) status.getSelectedItem();
        String temp4 = (String) depart.getSelectedItem();
    
        SimpleDateFormat newdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat newdate1 = new SimpleDateFormat("yyyy-MM-dd");
       
        String empi = emp12.getText();
        String fname = jTextField1.getText();
        String lname = jTextField3.getText();
        String nic = jTextField4.getText();
        String teli = jTextField7.getText();
        String email = jTextField11.getText();
        String add = address.getText();

        String sal = jTextField9.getText();
        String alo = jTextField12.getText();

        String dob = newdate.format(dat.getCalendar().getTime());
        String join = newdate1.format(date1.getCalendar().getTime());
      
     
        
        
        
        
        
     //88888888888888888888888888888888888   
        
      int row = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        String selected = model.getValueAt(row, 0).toString();

        if (row >= 0) {
            
          

              
     String insert_Staff = "INSERT INTO deleteemployee(Empid,FirstName,LastName,NIC,Dob,Sex,Nationality,Marital,position,joined,teliphone,email,address,bsalary,alowance,department) VALUES ('"+ empi + "', '" + fname + "','" + lname + "','" + nic + "','" + dob + "','" + temp2 + "','" + temp + "','" + temp3 + "','" + temp1 + "','" + join + "','" + teli + "','" + email + "','" + add + "','" + sal + "','" + alo + "','" + temp4 + "')";

       
                try {
                      
                        insertion(insert_Staff);
       
         tableloaddelete(); 
        
        
            
            
//hhhhhhhhhhhhhhhhhhhhhhhhh
            model.removeRow(row);

                
               
                
                // Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "hey");
                PreparedStatement ps = conn.prepareStatement("delete from employee where EmpID='" + selected + "' ");
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "DELETED");
            } catch (SQLException | HeadlessException w) {
                JOptionPane.showMessageDialog(this, "Connection Error!");
            }
        
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        String temp = (String) amount.getSelectedItem();
        String temp1 = (String) amount.getSelectedItem();

        // String temp3 = (String)status.getSelectedItem();
        SimpleDateFormat newdate = new SimpleDateFormat("yyyy-MM-dd");
        //  SimpleDateFormat newdate1 = new SimpleDateFormat("yyyy-MM-dd");
        // SimpleDateFormat newdate2 = new SimpleDateFormat("yyyy-MM-dd");

        String id = ln3.getText();
        String name = jTextField3.getText();
        String salary = ln2.getText();
        String payment = jTextField9.getText();

        String add = des.getText();

        String apply_date = newdate.format(dat.getCalendar().getTime());

        //    String Item_name = jTextField2.getText();
        //   String sql = "select * from employee where empID '"+Item_name+"'";
        // if(id==sql);
        String loan = "INSERT INTO emp_loan(empID,empname,fullamount,installment,dat,salary,description,payment) VALUES ('" + id + "','" + name + "','" + temp + "','" + temp1 + "','" + apply_date + "','" + salary + "','" + add + "','" + payment + "')";

        try {

            insertion(loan);

        } catch (Exception e) {
            System.out.println(e);
        }

        // insertion(insertStaff);
        // tableUpdate();
        // tableUpdate1();
        // tableUpdate2();
        //  tableUpdate1();
        tableUpdate();

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        SimpleDateFormat newdate = new SimpleDateFormat("yyyy-MM-dd");

        String temp2 = (String) amount.getSelectedItem();
        String temp = (String) period.getSelectedItem();

        int x = JOptionPane.showConfirmDialog(null, "Do you really want to update?");

        if (x == 0) {
            String ln = empi.getText();

            String id = ln3.getText();
            String name = jTextField3.getText();
            String salary = ln2.getText();
            String payment = jTextField9.getText();

            String add = des.getText();

            String apply_date = newdate.format(dat.getCalendar().getTime());

            //     String regex = "^[a-zA-Z,.() ]+$";
            String updateloan = "UPDATE emp_leave SET empID='" + id + "',empname='" + name + "',fullamount='" + temp2 + "',installment='" + temp + "',dat='" + apply_date + "',salary='" + salary + "'description ='" + add + "',payment='" + payment + "' where loanid='" + ln + "'";

            try {

                updation(updateloan);
                // tableUpdate();

            } catch (Exception e) {
                System.out.println(e);

                //       tableUpdate();
            }

            //        tableUpdate();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        int row = Table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) Table.getModel();

        String selected = model.getValueAt(row, 0).toString();

        if (row >= 0) {

            model.removeRow(row);

            try {
                // Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "hey");
                PreparedStatement ps = conn.prepareStatement("delete from emp_loan where loanID='" + selected + "' ");
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "DELETED");
            } catch (SQLException | HeadlessException w) {
                JOptionPane.showMessageDialog(this, "Connection Error!");
            }
        }
        // tableUpdate();// TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        //clear         jTextField1.setText("");
        jTextField3.setText("");
        ln2.setText("");

        ln3.setText("");
        jTextField9.setText("");
        des.setText("");

        dat.setCalendar(null);

        amount.setSelectedIndex(0);
        period.setSelectedIndex(0);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountActionPerformed

    private void periodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_periodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_periodActionPerformed

    private void ln1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ln1MouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_ln1MouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        Integer temp = (Integer) amount.getSelectedItem();
        Integer temp2 = (Integer) period.getSelectedItem();

        //double number = -895.25;
        //Double doubleInstance = new Double(temp);
        //String abc = doubleInstance.toString();
        //Double num1 = Double.parseDouble(jTextField7.getText());
        //    Double num2 = Double.parseDouble(jTextField6.getText());
        String bal = Integer.toString(temp / temp2);
        jTextField9.setText(bal);

    }//GEN-LAST:event_jButton12ActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked

        //     DefaultTableModel model =(DefaultTableModel)jTable1.getModel();
        int r = Table.getSelectedRow();

        String lid = Table.getValueAt(r, 0).toString();

        String id = Table.getValueAt(r, 1).toString();
        String name = Table.getValueAt(r, 2).toString();
        String sal = Table.getValueAt(r, 6).toString();
        String dest = Table.getValueAt(r, 7).toString();
        String ins = Table.getValueAt(r, 8).toString();
        //  String pDate =  Table.getV
        String dt = Table.getValueAt(r, 3).toString();

        String pDate = Table.getValueAt(r, 4).toString();

        empi.setText(lid);
        ln3.setText(id);
        jTextField3.setText(name);
        ln2.setText(sal);
        jTextField9.setText(ins);
        des.setText(dest);

        //    date.setDateFormatString(dt);
        date2.setDateFormatString(pDate);
        //   date.setText(dt);
        //  amount.setText(ins);
        //    period.setText(dest);

        // jTextField9.setText(ins);
        // TODO add your handling code here:
    }//GEN-LAST:event_TableMouseClicked

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        String Item_name = search_txt.getText();

        try {
            String sql = "select * from emp_loan where empID like '%" + Item_name + "%'";
            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();

            Table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {

        }

        // tableUpdate();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed

        String temp = (String) amount.getSelectedItem();
        String temp1 = (String) amount.getSelectedItem();

        // String temp3 = (String)status.getSelectedItem();
        SimpleDateFormat newdate = new SimpleDateFormat("yyyy-MM-dd");
        //  SimpleDateFormat newdate1 = new SimpleDateFormat("yyyy-MM-dd");
        // SimpleDateFormat newdate2 = new SimpleDateFormat("yyyy-MM-dd");

        String id = ln3.getText();
        String name = jTextField3.getText();
        String salary = ln2.getText();
        String payment = jTextField9.getText();

        String add = des.getText();

        String apply_date = newdate.format(dat.getCalendar().getTime());

        //    String Item_name = jTextField2.getText();
        //   String sql = "select * from employee where empID '"+Item_name+"'";
        // if(id==sql);
        String loan = "INSERT INTO emp_loan(empID,empname,fullamount,installment,dat,salary,description,payment) VALUES ('" + id + "','" + name + "','" + temp + "','" + temp1 + "','" + apply_date + "','" + salary + "','" + add + "','" + payment + "')";

        try {

            insertion(loan);

        } catch (Exception e) {
            System.out.println(e);
        }


    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        //clear         jTextField1.setText("");
        jTextField3.setText("");
        ln2.setText("");

        ln3.setText("");
        jTextField9.setText("");
        des.setText("");

        dat.setCalendar(null);

        amount.setSelectedIndex(0);
        period.setSelectedIndex(0);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed

        SimpleDateFormat newdate = new SimpleDateFormat("yyyy-MM-dd");

        String temp2 = (String) amount.getSelectedItem();
        String temp = (String) period.getSelectedItem();

        int x = JOptionPane.showConfirmDialog(null, "Do you really want to update?");

        if (x == 0) {
            String ln = empi.getText();

            String id = ln3.getText();
            String name = jTextField3.getText();
            String salary = ln2.getText();
            String payment = jTextField9.getText();

            String add = des.getText();

            String apply_date = newdate.format(dat.getCalendar().getTime());

            //     String regex = "^[a-zA-Z,.() ]+$";
            String updateloan = "UPDATE emp_loan SET empID='" + id + "',empname='" + name + "',fullamount='" + temp2 + "',installment='" + temp + "',dat='" + apply_date + "',salary='" + salary + "'description ='" + add + "',payment='" + payment + "' where loanid='" + ln + "'";

            try {

                updation(updateloan);
                //   tableUpdate();

            } catch (Exception e) {
                System.out.println(e);

                //    tableUpdate();
            }

            //   tableUpdate();
            // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed
    }
    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        int row = Table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) Table.getModel();

        String selected = model.getValueAt(row, 0).toString();

        if (row >= 0) {

            model.removeRow(row);

            try {
                // Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "hey");
                PreparedStatement ps = conn.prepareStatement("delete from emp_loan where loanID='" + selected + "' ");
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "DELETED");
            } catch (SQLException | HeadlessException w) {
                JOptionPane.showMessageDialog(this, "Connection Error!");
            }
        }
        // tableUpdate();// TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        String Item_name = search_txt.getText();

        try {
            String sql = "select * from emp_loan where empID like '%" + Item_name + "%'";
            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();

            Table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {

        }


    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed

        String temp = (String) amount.getSelectedItem();
        String temp1 = (String) amount.getSelectedItem();

        // String temp3 = (String)status.getSelectedItem();
        SimpleDateFormat newdate = new SimpleDateFormat("yyyy-MM-dd");
        //  SimpleDateFormat newdate1 = new SimpleDateFormat("yyyy-MM-dd");
        // SimpleDateFormat newdate2 = new SimpleDateFormat("yyyy-MM-dd");

        String id = ln3.getText();
        String name = ln1.getText();
        String salary = ln2.getText();
        String payment = jTextField10.getText();

        String add = des.getText();

        String apply_date = newdate.format(dat.getCalendar().getTime());

        String loan = "INSERT INTO emp_loan(empID,empname,fullamount,installment,dat,salary,description,payment) VALUES ('" + id + "','" + name + "','" + temp + "','" + temp1 + "','" + apply_date + "','" + salary + "','" + add + "','" + payment + "')";

        try {

            insertion(loan);

        } catch (Exception e) {
            System.out.println(e);
        }

        tableUpdate();

    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        //clear         jTextField1.setText("");
        jTextField3.setText("");
        ln2.setText("");
        ln1.setText("");
        ln3.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        des.setText("");

        dat.setCalendar(null);

        amount.setSelectedIndex(0);
        period.setSelectedIndex(0);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed

        SimpleDateFormat newdate = new SimpleDateFormat("yyyy-MM-dd");

        String temp2 = (String) amount.getSelectedItem();
        String temp = (String) period.getSelectedItem();

        int x = JOptionPane.showConfirmDialog(null, "Do you really want to update?");

        if (x == 0) {
            String ln = empi.getText();

            String id = ln3.getText();
            String name = jTextField3.getText();
            String salary = ln2.getText();
            String payment = jTextField9.getText();

            String add = des.getText();

            String apply_date = newdate.format(dat.getCalendar().getTime());

            //     String regex = "^[a-zA-Z,.() ]+$";
            String updateloan = "UPDATE emp_leave SET empID='" + id + "',empname='" + name + "',fullamount='" + temp2 + "',installment='" + temp + "',dat='" + apply_date + "',salary='" + salary + "'description ='" + add + "',payment='" + payment + "' where loanid='" + ln + "'";

            try {

                updation(updateloan);
                tableUpdate();

            } catch (Exception e) {
                System.out.println(e);

                tableUpdate();

            }

            tableUpdate();

            // TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed
    }
    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        int row = Table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) Table.getModel();

        String selected = model.getValueAt(row, 0).toString();

        if (row >= 0) {

            model.removeRow(row);

            try {
                // Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "hey");
                PreparedStatement ps = conn.prepareStatement("delete from emp_loan where loanID='" + selected + "' ");
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "DELETED");
            } catch (SQLException | HeadlessException w) {
                JOptionPane.showMessageDialog(this, "Connection Error!");
            }
        }
        tableUpdate();// TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void ln1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ln1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ln1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
//salii
        aabcd.setBackground(Color.WHITE);
        Employee_Attendance.setVisible(false);
        Employee_Registration.setVisible(false);
        Apply_Loan_solako.setVisible(false);
        Employee_Attendance_Review.setVisible(false);
        Employee_Leave.setVisible(false);
        Employee_Salary.setVisible(true);
         LeaveRequest.setVisible(false);

// TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        //employee click Salary;

        if (salary2.getText().length() != 0) {

            if (searchExisting(salary2.getText())) {

              
                try {

                    String Search_name = salary2.getText();

                    String sql = "select * from employee where  EmpID ='" + Search_name + "'";
                    pst = conn.prepareStatement(sql);

                    rs = pst.executeQuery();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                try {
                    String sql = "select Firstname,Nic,bsalary,alowance,FoodAllowance,MedicalAllowance  FROM employee where Empid = ?";

                    pst = conn.prepareStatement(sql);
                    pst.setString(1, salary2.getText());
                    rs = pst.executeQuery();

                    if (rs.next()) {
                        String add1 = rs.getString("Firstname");
                        salary3.setText(add1);

                        String add2 = rs.getString("nic");
                        salary4.setText(add2);

                        String add3 = rs.getString("bsalary");
                        salary5.setText(add3);

                        String add4 = rs.getString("alowance");
                        salary6.setText(add4);
                        
                        String add5 = rs.getString("FoodAllowance");
                        jTextField14.setText(add5);

                        String add6= rs.getString("MedicalAllowance");
                        jTextField15.setText(add6);
                    
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            } else {

                JOptionPane.showMessageDialog(null, "Please Enter Existing Employee ID");
            }
        } else {

            JOptionPane.showMessageDialog(null, "EmplyeeID Field Empty!!!");

        }
        String Search_name = salary2.getText();

        try {
            String sql = "select * from employee where  EmpID ='" + Search_name + "'";
            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    

    }//GEN-LAST:event_jButton13ActionPerformed

    private void salary7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salary7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salary7ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
//net salary
        {
            Double num1 = Double.parseDouble(salary5.getText());
            Double num2 = Double.parseDouble(salary6.getText());
            
            
            Double num7 = Double.parseDouble(jTextField14.getText());
            Double num8 = Double.parseDouble(jTextField15.getText());
            
      
           
            Double y= (num1+num2+num7+num8);
            
            Double x=  (num1/100)*8  ;
            
        //    String bal = Double.toString(((num1 / 100) * 8));
       //     
        //    salary7.setText(bal);
            
            Double num3 = Double.parseDouble(salary11.getText());
            Double num4 = Double.parseDouble(salary8.getText());
            
            Double z=num3+num4;
            
            Double a = z+x;;
            
            Double p= y-x;
         
            
            
            String bal = Double.toString(y-x);
                      
            salary9.setText(bal);    
            
            
            
            
            
            
            
            

      //    String balance = Double.toString(( y ) - (num1 / 100) * 8);

        //   Double balance = hhhh;
           
           
         //   salary9.setText(balance);

        }

// TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void salary7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salary7MouseClicked

        //salary etf
        {
            Double num1 = Double.parseDouble(salary5.getText());
            Double num2 = Double.parseDouble(salary6.getText());
            String bal = Double.toString(((num1 / 100) * 12));
            salary7.setText(bal);

        }


    }//GEN-LAST:event_salary7MouseClicked

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        //salary bln clear

        salaryclear();

// TODO add your handling code here:
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
//salary add  

        String temp = (String) national.getSelectedItem();

        SimpleDateFormat newdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat newdate1 = new SimpleDateFormat("yyyy-MM-dd");

        String sid = salary2.getText();
        String sname = salary3.getText();
        String snic = salary4.getText();
        String sbasic = salary5.getText();
        String salo = salary6.getText();
        String sepf = salary7.getText();
        
        
        String sfood= jTextField14.getText();
        String smedi =jTextField15.getText();
        String setf = salary11.getText();
        String swell = salary15.getText();


        String sddd = salary8.getText();
        String snet = salary9.getText();
        if (salary2.getText().length() != 0) {

            if (searchExisting(salary2.getText())) {

                String insert_salary = "INSERT INTO salary(EmpID,name,nic,basic,Vehicle,Food,Medical,EPF,ETF,Wellfare,deduction,netsalary) VALUES ('" + sid + "','" + sname + "','" + snic + "','" + sbasic + "','" + salo + "','" + sfood + "','" + smedi+ "','" + sepf + "','" + swell + "','" + sddd+ "','" + setf + "','" + snet + "')";

                //    String insert_attendance=   "INSERT INTO attendance(tdate,EmpID,intime) VALUES('" +dy + "','" + id+ "','" + in+ "')" ;
                insertion(insert_salary);
                
            } else {

                JOptionPane.showMessageDialog(null, "Please Enter Existing Employee ID");
            }
        } else {

            JOptionPane.showMessageDialog(null, "EmplyeeID Field Empty!!!");

        }

        salarytable();

// TODO add your handling code here:
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        //Delete salary

        int row = salarytable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) salarytable.getModel();

        String selected = model.getValueAt(row, 0).toString();

        if (row >= 0) {

            model.removeRow(row);

            try {
                // Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "hey");
                PreparedStatement ps = conn.prepareStatement("delete from salary  where salaryID='" + selected + "' ");
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "DELETED");
            } catch (SQLException | HeadlessException w) {
                JOptionPane.showMessageDialog(this, "Connection Error!");
            }
        }

// TODO add your handling code here:
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        //salary update

        int x = JOptionPane.showConfirmDialog(null, "Do you really want to update?");

        if (x == 0) {
            String sid = salary10.getText();
            String siid = salary2.getText();
            String sname = salary3.getText();
            String snic = salary4.getText();
            String sbac = salary5.getText();
            String sal = salary6.getText();
            String seepf = salary7.getText();
            String dedu = salary8.getText();
            String snet1 = salary9.getText();

            String updatesal = "UPDATE salary  SET EmpID='" + siid + "',name='" + sname + "',nic='" + snic + "',basic='" + sbac + "',alowance='" + sal + "',Epf='" + seepf + "',deduction ='" + dedu + "',netsalary='" + snet1 + "' where salaryID='" + sid + "'";

            try {

                updation(updatesal);
                salarytable();

            } catch (Exception e) {
                System.out.println(e);

                salarytable();

            }

        }
// TODO add your handling code here:
    }//GEN-LAST:event_jButton27ActionPerformed

    private void salarytableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salarytableMouseClicked
//mouse clicked salary update   

        int r = salarytable.getSelectedRow();

        String sid = salarytable.getValueAt(r, 0).toString();

        String siid = salarytable.getValueAt(r, 1).toString();
        String sname = salarytable.getValueAt(r, 2).toString();
        String snic = salarytable.getValueAt(r, 3).toString();
        String sbac = salarytable.getValueAt(r, 4).toString();
        String saa = salarytable.getValueAt(r, 11).toString();
        String snet = salarytable.getValueAt(r, 12).toString();
        
        String salow = salarytable.getValueAt(r, 5).toString();
        String scc = salarytable.getValueAt(r, 6).toString();
        String sdd = salarytable.getValueAt(r, 7).toString();
          String sdedu = salarytable.getValueAt(r, 10).toString();
   

        
        
        
        String sbb = salarytable.getValueAt(r, 9).toString();
        
        
        
    
        String sepf = salarytable.getValueAt(r, 8).toString();
        
        
      
   
        
        

        salary11.setText(saa);
        salary15.setText(sbb);
        jTextField15.setText(scc);
        jTextField14.setText(sdd);
        
        
        salary10.setText(sid);
        salary2.setText(siid);
        salary3.setText(sname);
        salary4.setText(snic);
        salary5.setText(sbac);
        salary6.setText(salow);
        salary7.setText(sepf);
        salary8.setText(sdedu);
        salary9.setText(snet);

    }//GEN-LAST:event_salarytableMouseClicked

    public boolean CheckToday(String date, String eid) {

        boolean ans = false;

        String sql = "SELECT tdate,EmpID FROM attendance WHERE EmpID='" + eid + "' AND tdate='" + date + "'";

        try {

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
               
                String Date1 = rs.getString("tdate");
                String Eid = rs.getString("EmpID");
                
                if ((Date1.equalsIgnoreCase(date)) && (Eid.equalsIgnoreCase(eid))) {
                    System.out.println("@@@@");
                    ans = true;
                }
                        

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }
        
        System.out.println("Answer is: " + ans);
        return ans;
    }


    private void in_timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_in_timeActionPerformed
//attendance in 

        String dy = at.getText();
        String id = hehe.getText();
        String in = t1.getText();
        String ot = t2.getText();

        if (hehe.getText().length() != 0) {

            if (searchExisting(hehe.getText())) {

                if (!CheckToday(dy, id)) {

                    String insert_attendance = "INSERT INTO attendance(tdate,EmpID,intime) VALUES('" + dy + "','" + id + "','" + in + "')";
                    insertion(insert_attendance);
                    tableload2();
                    hehe.setText("");

                } else {

                    JOptionPane.showMessageDialog(null, "Customer Alredy Enterd Today");
                }

            } else {

                JOptionPane.showMessageDialog(null, "Please Enter Existing Employee Number");
            }
        } else {

            JOptionPane.showMessageDialog(null, "Emplyee Field Empty!!!");

        }

    }//GEN-LAST:event_in_timeActionPerformed

    private void lef1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lef1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lef1ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed

        //add      
        String abcde = (String) leavetype.getSelectedItem();

        SimpleDateFormat newdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat newdate1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat newdate3 = new SimpleDateFormat("yyyy-MM-dd");

        String status = LE3.getText();
        String lid = lef1.getText();
        String lname = lef2.getText();
        String add = lef3.getText();

        String abc1 = lef7.getText();

        String abc2 = newdate1.format(led2.getCalendar().getTime());
        String abc3 = newdate1.format(led3.getCalendar().getTime());

        boolean bool;
        if (leavetype.getSelectedItem() == "<SELECT>") {
            JOptionPane.showConfirmDialog(rootPane, "select ur type !!", "Error", JOptionPane.ERROR_MESSAGE);
            bool = false;
        } else if (lef1.getText().length() != 0) {

            if (searchExisting(lef1.getText())) {

                // String reg="[Full day]||[Half day]" ;   
                String insert_leave = "INSERT INTO emp_leave (EmpID,Empname,Requestdate,reson,type,leavefrm,leavetill,status) VALUES ('" + lid + "','" + lname + "','" + abc1 + "','" + add + "','" + abcde + "','" + abc2 + "','" + abc3 + "','" + status + "' )";

                // String insert_attendance=   "INSERT INTO attendance(tdate,EmpID,intime) VALUES('" +dy + "','" + id+ "','" + in+ "')" ;
                insertion(insert_leave);

                lef1.setText("");

                tableload7();
                le8.setEnabled(true);
            } else {

                JOptionPane.showMessageDialog(null, "Please Enter Existing Employee Number");
            }
        } else {

            JOptionPane.showMessageDialog(null, "Emplyee Field Empty!!!");

        }

        //     String insert_leave = "INSERT INTO emp_leave (EmpID,Requestdate,reson,type,leavefrm,leavetill,status) VALUES ('" + lid + "','" + abc1+ "','" + add + "','" + abcde + "','" + abc2+ "','" + abc3+  "','" + status+  "' )";
        //   tableload7();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        //clear

        le4.setText("");
        lef1.setText("");
        lef2.setText("");
        lef3.setText("");
        LE3.setText("");

        //   led1.setCalendar(null);
        led2.setCalendar(null);
        led3.setCalendar(null);

        leavetype.setSelectedIndex(0);
        le8.setEnabled(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed

        int row = ltable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) ltable.getModel();

        String selected = model.getValueAt(row, 0).toString();

        if (row >= 0) {

            model.removeRow(row);

            try {
                // Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "hey");
                PreparedStatement ps = conn.prepareStatement("delete from emp_leave where leaveid='" + selected + "' ");
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "DELETED");
            } catch (Exception w) {
                JOptionPane.showMessageDialog(this, "Connection Error!");
            }

            tableload7();
        }

        tableload7();

// TODO add your handling code here:
    }//GEN-LAST:event_jButton31ActionPerformed

    private void lef2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lef2ActionPerformed

// TODO add your handling code here:
    }//GEN-LAST:event_lef2ActionPerformed

    private void salary3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salary3MouseClicked

// TODO add your handling code here:
    }//GEN-LAST:event_salary3MouseClicked

    private void lef2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lef2MouseClicked
        /*
         try{
         String sql = "select Firstname  from employee where EmpID = ?";
            
         pst=conn.prepareStatement(sql);
         pst.setString(1,lef1.getText());
         rs=pst.executeQuery();
            
         if(rs.next()){
         String add1 = rs.getString("Firstname");
         lef2.setText(add1);
                
               
         }   
            
         }
         catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
         }

        
         */

// TODO add your handling code here:
    }//GEN-LAST:event_lef2MouseClicked

    private void lef1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lef1MouseReleased
        //mouse released

    }//GEN-LAST:event_lef1MouseReleased

    private void lef2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lef2MouseEntered

        try {
            String sql = "select Firstname  from employee where EmpID = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, lef1.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                String add1 = rs.getString("Firstname");
                lef2.setText(add1);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_lef2MouseEntered

    private void ltableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ltableMouseEntered
        //reson update
      /*     le8.setEnabled(true);
        
           
         int r = ltable.getSelectedRow();

         SimpleDateFormat sel = new SimpleDateFormat("yyyy-MM-dd");
         // SimpleDateFormat reg = new SimpleDateFormat("yyyy-MM-dd");
         //  Date a=dob.parse();
         //   dat.setDate(a);

         String lid = ltable.getValueAt(r, 0).toString();

         String llid = ltable.getValueAt(r, 1).toString();
         String lname = ltable.getValueAt(r, 2).toString();
         String lreq   = ltable.getValueAt(r, 3).toString();
         String lres  = ltable.getValueAt(r, 4).toString();
         // String email = ltable.getValueAt(r, 5).toString();
         //   String add   = ltable.getValueAt(r, 6).toString();
         //   String basic = ltable.getValueAt(r, 7).toString();
         String lstt   = ltable.getValueAt(r, 8).toString();

      
         le4.setText(lid);
         lef1.setText(llid);
         lef2.setText(lname);
         lef7.setText(lreq);

         lef3.setText(lres);
  
         le8.setText(lstt);
       
         */
// TODO add your handling code here:
    }//GEN-LAST:event_ltableMouseEntered

    private void genderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_genderMouseClicked

        boolean anr = true;
        try {
            if (gender.getSelectedIndex() == 0) {

                anr = false;
            } else {
                anr = true;

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO

// TODO add your handling code here:
    }//GEN-LAST:event_genderMouseClicked

    private void departActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departActionPerformed
//     boolean bool;
//        if(depart.getSelectedItem()=="<SELECT>")
        //           {
        //               JOptionPane.showConfirmDialog(rootPane, "Select a department", "Error", JOptionPane.ERROR_MESSAGE);
        //              bool =false;
        //           }      // TODO add your handling code here:
    }//GEN-LAST:event_departActionPerformed

    private void leavetypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leavetypeActionPerformed
        boolean bool;
        if (depart.getSelectedItem() == "SELECT") {
            bool = false;
        }         // TODO add your handling code here:
    }//GEN-LAST:event_leavetypeActionPerformed

    private void ltableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ltableMouseClicked

        le8.setEnabled(true);
        LE3.setEnabled(false);

        int r = ltable.getSelectedRow();

        SimpleDateFormat sel = new SimpleDateFormat("yyyy-MM-dd");
        // SimpleDateFormat reg = new SimpleDateFormat("yyyy-MM-dd");
        //  Date a=dob.parse();
        //   dat.setDate(a);

        String lid = ltable.getValueAt(r, 0).toString();

        String llid = ltable.getValueAt(r, 1).toString();
        String lname = ltable.getValueAt(r, 2).toString();
        String lreq = ltable.getValueAt(r, 3).toString();
        String lres = ltable.getValueAt(r, 4).toString();
        String ltype = ltable.getValueAt(r, 5).toString();
        String lstt = ltable.getValueAt(r, 8).toString();
        String todate = ltable.getValueAt(r, 6).toString();
        String frmdate = ltable.getValueAt(r, 7).toString();

        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate;
        Date newDate2;
        try {
            newDate = simple.parse(todate);
            led2.setDate(newDate);
            newDate2 = simple.parse(frmdate);
            led3.setDate(newDate);

        } catch (ParseException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }

        leavetype.setSelectedItem(ltype);

        le4.setText(lid);
        lef1.setText(llid);
        lef2.setText(lname);
        lef7.setText(lreq);
        lef3.setText(lres);
        le8.setText(lstt);

// TODO add your handling code here:
    }//GEN-LAST:event_ltableMouseClicked

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
//  update query leaves 

        LE3.setEnabled(false);
        String temp1 = (String) leavetype.getSelectedItem();
        SimpleDateFormat newdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat newdate1 = new SimpleDateFormat("yyyy-MM-dd");

        String llid = le4.getText();
        String lid = lef1.getText();
        String lname = lef2.getText();
        String lreq = lef7.getText();
        String lpur = lef3.getText();
        String ledit = le8.getText();

        String aaa = newdate.format(led2.getCalendar().getTime());
        String bbb = newdate1.format(led3.getCalendar().getTime());

        //   String updateatt = " UPDATE employee SET outtime='"+ment+"' where EmpID='"+tt+"'" ;                //   String updateatt = " UPDATE employee SET outtime='"+ment+"' where EmpID='"+tt+"'" ;           //   String updateatt = " UPDATE employee SET outtime='"+ment+"' where EmpID='"+tt+"'" ;
        String update_employeeleave = "UPDATE emp_leave SET  EmpID='" + lid + "',empname='" + lname + "',Requestdate='" + lreq + "', leavefrm='" + aaa + "',leavetill='" + bbb + "',type='" + temp1 + "',reson='" + lpur + "',status='" + ledit + "' where leaveid='" + llid + "'";

        try {

            updation(update_employeeleave);

            tableload7();
        } catch (Exception e) {
            System.out.println(e);

        }

        tableload7();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton32ActionPerformed

    private void salary9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salary9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salary9ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
   
     
        
           Validation v = new Validation();
        
   SimpleDateFormat newdate3 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat newdate4 = new SimpleDateFormat("yyyy-MM-dd");

      //  String frm = newdate3.format(jDateChooser1.getCalendar().getTime());
      //  String till = newdate4.format(jDateChooser2.getCalendar().getTime());
        String emp=  jTextField2.getText();  
           String s = ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
            String p = ((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText();
   
   
            
            
      if (v.isempty(emp)){
        
    JOptionPane.showMessageDialog(null, "Employee ID Field Empty.", "Warning!", JOptionPane.ERROR_MESSAGE);
        
           
      } else if (v.isempty(s)){
        
    JOptionPane.showMessageDialog(null, "Please Select Date", "Warning!", JOptionPane.ERROR_MESSAGE);

 
      } else  if (v.isempty(p)){
        
    JOptionPane.showMessageDialog(null, "Please Select Date", "Warning!", JOptionPane.ERROR_MESSAGE);
    
   }
      else if (searchExisting( jTextField2.getText())) { 
      
        try {
            
            
          String frm = newdate3.format(jDateChooser1.getCalendar().getTime());
         String till = newdate4.format(jDateChooser2.getCalendar().getTime());
     
            String sql = "select tdate,EmpID,intime,outtime from attendance where EmpID='" + emp + "' AND  tdate > '" + frm + "' AND  tdate< '"+till +"' ";
            
    
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
           
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "not anyone");
        }
       // jDateChooser2.setCalendar(null);
      //  jDateChooser1.setCalendar(null);
      //  jTextField2 .setText("");

        
    }
      else {

                JOptionPane.showMessageDialog(null, "Please Enter Existing Employee Number");
            }
        
     
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed

        
        Employee_Registration.setVisible(false);
        Apply_Loan_solako.setVisible(false);
        Employee_Attendance_Review.setVisible(true);
        Employee_Salary.setVisible(false);
        Employee_Attendance.setVisible(false);
        Employee_Leave.setVisible(false);
        LeaveRequest.setVisible(false);
    //    Employee_Leave.setVisible(true);
        







// TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
  
      jDateChooser2.setCalendar(null);
      jDateChooser1.setCalendar(null);
      jTextField2 .setText("");  

// TODO add your handling code here:
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void salary15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salary15MouseClicked
   
        
  {
            Double num1 = Double.parseDouble(salary5.getText());
            Double num2 = Double.parseDouble(salary6.getText());
            String bal = Double.toString(((num1 / 100) * 8));
            salary15.setText(bal);

        }










// TODO add your handling code here:
    }//GEN-LAST:event_salary15MouseClicked

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
   
    
     DefaultTableModel model = (DefaultTableModel) salarytable.getModel();
     int r = salarytable.getSelectedRow();

        String sid = salarytable.getValueAt(r, 0).toString();

        String siid = salarytable.getValueAt(r, 1).toString();
        String sname = salarytable.getValueAt(r, 2).toString();
        String snic = salarytable.getValueAt(r, 3).toString();
        String sbac = salarytable.getValueAt(r, 4).toString();
        String saa = salarytable.getValueAt(r, 11).toString();
        String snet = salarytable.getValueAt(r, 12).toString();
        
        String salow = salarytable.getValueAt(r, 5).toString();
        String scc = salarytable.getValueAt(r, 6).toString();
        String sdd = salarytable.getValueAt(r, 7).toString();
        String sdedu = salarytable.getValueAt(r, 10).toString();
        String sbb = salarytable.getValueAt(r, 9).toString();
        
        String sepf = salarytable.getValueAt(r, 8).toString();
        
        
        
  
    
   jTextArea1.append("Solakro Paint Company (Pvt)Ltd\n\n"+"Salary ID:\t"+sid+"\nEmployee ID:\t"+siid+"\nEmployee Name:\t"+sname+"\nNIC:^\t"+snic+"\n\nBasic:\t"+sbac+"\nVehicle Alowance:\t"+salow+"\nFood Allowance:\t"+
            sdd+"\nMedical Allowance:\t"+scc+"\n\nEPF:\t"+sepf+"\nETF:\t"+sbb+"\nwellfare:\t"+sdedu+"\nOther Deductions:\t"+saa+"\n\n Total:\t"+snet+"");
                                     
    

/*

DefaultTableModel model = (DefaultTableModel) recieptTable.getModel();

        int row;
        row = recieptTable.getSelectedRow();

        String sid;
        sid = recieptTable.getModel().getValueAt(row,0).toString();

        String date;
        date = recieptTable.getModel().getValueAt(row, 1).toString();

        String noitems;
        noitems = recieptTable.getModel().getValueAt(row, 2).toString();

        String totamount;
        totamount = recieptTable.getModel().getValueAt(row, 3).toString();
        
        String dis;
        dis = recieptTable.getModel().getValueAt(row, 4).toString();
        
        String disamount;
        disamount = recieptTable.getModel().getValueAt(row, 5).toString();
        
        String sub;
        sub = recieptTable.getModel().getValueAt(row, 6).toString();
        
        String cname;
        cname = recieptTable.getModel().getValueAt(row, 7).toString();
        
        String cphone;
        cphone = recieptTable.getModel().getValueAt(row, 8).toString();
        
        String cadd;
        cadd = recieptTable.getModel().getValueAt(row, 9).toString();
        
        String ordetail;
        ordetail = recieptTable.getModel().getValueAt(row, 10).toString();
        
        String sale;
        sale = recieptTable.getModel().getValueAt(row, 11).toString();

     

        jTextArea2.append("Solakro Paint Company (Pvt)Ltd\n\n"+"Sales ID:\t\t"+sid+"\nDate:\t\t"+date+"\nCompany Name:\t"+cname+"\nPhone:\t\t"+cphone+"\nDelivery Address:\t"+cadd+"\nSale Items:\t"+ordetail+"\nNo of Items:\t\t"+
            noitems+"\nTotal Total:\t\t"+totamount+"\nDiscount:\t\t"+dis+"\nDiscount Amount:\t"+disamount+"\nSub Total:\t\t"+sub+"");
    }                                   



























*/


// TODO add your handling code here:
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
     
       String Search_name = jTextField8.getText();

        try {
            String sql = "select * from deleteemployee where Firstname like '%" + Search_name + "%' or EmpID ='" + Search_name + "'";
            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();

            jTable10.setModel(DbUtils.resultSetToTableModel(rs));
          
        } catch (Exception e) {
        }
   jTextField8.setText("");


// TODO add your handling code here:
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
    Employee_Registration.setVisible(false);
        Apply_Loan_solako.setVisible(false);
        Employee_Attendance_Review.setVisible(false);
        Employee_Salary.setVisible(false);
        Employee_Attendance.setVisible(false);
        Employee_Leave.setVisible(false);
        LeaveRequest.setVisible(true);     // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    
    
    //*******************************************************************************************************
    public boolean searchExisting(String id) {

        String query = "SELECT Empid FROM employee WHERE Empid='" + id + "'";
        boolean ans = false;
        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();

            if (rs.next()) {
                ans = true;
            } else {

                ans = false;
                //JOptionPane.showMessageDialog(null,"!!! Employee Does not existing !!!");
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

        return ans;

    }
    //*********************************************************************************************************

    public boolean Duplicate(String nic) {

        String query = "SELECT NIC FROM employee WHERE NIC='" + nic + "'";
        boolean ans = false;
        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();

            if (rs.next()) {
                ans = false;
            } else {

                ans = true;

            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

        return ans;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane Apply_Loan_solako;
    private javax.swing.JLayeredPane Employee_Attendance;
    private javax.swing.JLayeredPane Employee_Attendance_Review;
    private javax.swing.JLayeredPane Employee_Leave;
    private javax.swing.JLayeredPane Employee_Registration;
    private javax.swing.JLayeredPane Employee_Salary;
    private javax.swing.JLabel LE3;
    private javax.swing.JLayeredPane LeaveRequest;
    private javax.swing.JTable Table;
    private javax.swing.JToggleButton aabcd;
    private javax.swing.JTextArea address;
    private javax.swing.JComboBox amount;
    private javax.swing.JTextField at;
    private javax.swing.JPanel bg;
    private com.toedter.calendar.JDateChooser dat;
    private com.toedter.calendar.JDateChooser date1;
    private com.toedter.calendar.JDateChooser date2;
    private javax.swing.JLabel dawasa;
    private javax.swing.JComboBox depart;
    private javax.swing.JTextArea des;
    private javax.swing.JLabel dinaya;
    private javax.swing.JTextField emp12;
    private javax.swing.JLabel empi;
    private javax.swing.JComboBox gender;
    private javax.swing.JTextField hehe;
    private javax.swing.JButton in_time;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JLabel le4;
    private javax.swing.JTextField le8;
    private javax.swing.JComboBox leavetype;
    private com.toedter.calendar.JDateChooser led2;
    private com.toedter.calendar.JDateChooser led3;
    private javax.swing.JTextField lef1;
    private javax.swing.JTextField lef2;
    private javax.swing.JTextArea lef3;
    private javax.swing.JTextField lef7;
    private javax.swing.JTextField ln1;
    private javax.swing.JTextField ln2;
    private javax.swing.JTextField ln3;
    private javax.swing.JTable ltable;
    private javax.swing.JComboBox national;
    private javax.swing.JButton out_time;
    private com.toedter.calendar.JDateChooser pen;
    private javax.swing.JComboBox period;
    private javax.swing.JComboBox position;
    private javax.swing.JLabel salary1;
    private javax.swing.JLabel salary10;
    private javax.swing.JTextField salary11;
    private javax.swing.JTextField salary15;
    private javax.swing.JTextField salary2;
    private javax.swing.JTextField salary3;
    private javax.swing.JTextField salary4;
    private javax.swing.JTextField salary5;
    private javax.swing.JTextField salary6;
    private javax.swing.JTextField salary7;
    private javax.swing.JTextField salary8;
    private javax.swing.JTextField salary9;
    private javax.swing.JTable salarytable;
    private javax.swing.JTextField search_txt;
    private javax.swing.JTextField search_txt1;
    private javax.swing.JTextField search_txt2;
    private javax.swing.JTextField search_txt3;
    private javax.swing.JPanel sidePane;
    private javax.swing.JComboBox status;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextArea txt;
    private javax.swing.JTextField txtfrom;
    private javax.swing.JTextField txtsubj;
    private javax.swing.JTextField txtto;
    // End of variables declaration//GEN-END:variables

   


}