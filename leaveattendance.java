/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee_manage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import db.Database;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author USER
 */
public class leaveattendance extends javax.swing.JFrame {
    
    
    java.sql.Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

   
     
    public leaveattendance() {
        
        
        
        initComponents();
        
        
          conn = Database.connect();
       tableload7();
    }
    
    
    public void tableload7() {

        try {
        //   String q1="SELECT* fROM employee";
       //  String q1 = "SELECT FirstName,LastName,NIC,Dob,Sex,Nationality,Marital,position,joined,teliphone,email,address,bsalary,alowance FROM employee";
         
          String q1=" SELECT leaveid,EmpID,Requestdate,reson,type,leavefrm,leavetill,status FROM emp_leave ";
            
            pst = conn.prepareStatement(q1);
            rs = pst.executeQuery();

            lTable.setModel(DbUtils.resultSetToTableModel(rs));

            
        } catch (Exception e) {
        
        }

    }
    
     
    public void insertion(String str) {
        try {

            pst = conn.prepareCall(str);
            pst.execute();
            JOptionPane.showConfirmDialog(null, "Successfully Inserted");
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showConfirmDialog(null, "Error.");

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
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        le1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        led1 = new com.toedter.calendar.JDateChooser();
        lef1 = new javax.swing.JTextField();
        lef2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        le4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lef3 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        lTable = new javax.swing.JTable();
        leavetype = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        led2 = new com.toedter.calendar.JDateChooser();
        led3 = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        le3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(204, 204, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employee_manage/logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 120));

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

        jToggleButton3.setText("Apply Loans");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        sidePane.add(jToggleButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 300, 50));

        jToggleButton4.setText("Apply Leaves");
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
        sidePane.add(jToggleButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 290, 50));

        jToggleButton1.setText("View Employee Attendance Details");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        sidePane.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 290, 50));

        bg.add(sidePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 360, 550));

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        le1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        le1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        le1.setText("APPLY LEAVES");
        jLayeredPane1.add(le1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 894, 33));

        jLabel2.setText("Employee ID:");
        jLayeredPane1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 80, 80, 37));

        jLabel3.setText("Date");
        jLayeredPane1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 201, 56, 29));

        jLabel4.setText("Employee Name:");
        jLayeredPane1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 149, -1, -1));
        jLayeredPane1.add(led1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 201, 135, -1));

        lef1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lef1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lef1ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(lef1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 88, 109, -1));

        lef2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLayeredPane1.add(lef2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 146, 109, -1));

        jLabel5.setText("leave ID:");
        jLayeredPane1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 48, 94, -1));

        le4.setText("leaveid:");
        jLayeredPane1.add(le4, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 48, 109, -1));

        jLabel7.setText("Purpose");
        jLayeredPane1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 264, 80, -1));

        lef3.setColumns(20);
        lef3.setRows(5);
        jScrollPane1.setViewportView(lef3);

        jLayeredPane1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 264, -1, -1));

        lTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Name", "Date", "purpose", "to", "till", "Title 7"
            }
        ));
        lTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lTable);

        jLayeredPane1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 432, 703, 135));

        leavetype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT", "Full day", "half day", " " }));
        jLayeredPane1.add(leavetype, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 90, -1));

        jLabel8.setText("TO:");
        jLayeredPane1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 55, -1));
        jLayeredPane1.add(led2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, -1, -1));
        jLayeredPane1.add(led3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, -1, -1));

        jLabel9.setText("TILL");
        jLayeredPane1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, -1, -1));

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 180, 71, 37));

        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, -1, 43));

        jButton3.setText("CLEAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 310, 71, 38));

        jButton4.setText("DELETE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 380, -1, 39));

        jLabel10.setText("Type:");
        jLayeredPane1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 40, 20));

        jLabel6.setText("Status:");
        jLayeredPane1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, -1, -1));

        le3.setText("p");
        jLayeredPane1.add(le3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 100, -1));

        bg.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 910, 550));

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
    home ho1=new home();
       ho1.setVisible(true);
       this.dispose();
       
    }//GEN-LAST:event_aabcdActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        

    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
       
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
       
       
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        
       
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
   
        
  int row = lTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) lTable.getModel();

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
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 //add      
        
        
        String abcde = (String) leavetype.getSelectedItem();
       
       
        SimpleDateFormat newdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat newdate1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat newdate3 = new SimpleDateFormat("yyyy-MM-dd");

        String status;
        status="pending";
  
        String lid = lef1.getText();
        
        String lname = lef2.getText();
      //  String lid = le1.getText();
        String add =lef3.getText();
        
       
        String abc1 = newdate.format(led1.getCalendar().getTime());
        String abc2 = newdate1.format(led2.getCalendar().getTime());
        String abc3 = newdate1.format(led3.getCalendar().getTime());
        
       

        String insert_leave = "INSERT INTO emp_leave (EmpID,Requestdate,reson,type,leavefrm,leavetill,status) VALUES ('" + lid + "','" + abc1+ "','" + add + "','" + abcde + "','" + abc2+ "','" + abc3+  "','" + status+  "' )";
 
      try {

                insertion(insert_leave);
               
                } catch (Exception e) {
                    System.out.println(e);
                }
        
        
        
        
        
        tableload7();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//clear
        

        le4.setText("");
        lef1.setText("");
        lef2.setText("");
        lef3.setText("");
        le3.setText("");
       
        led1.setCalendar(null);
        led2.setCalendar(null);
        led3.setCalendar(null);
      
        leavetype.setSelectedIndex(0);
       

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void lTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lTableMouseClicked
  
    //mouse clicked
        
        int r=lTable.getSelectedRow();

        String lid =  lTable.getValueAt(r,0).toString();

        String llid =  lTable.getValueAt(r,1).toString();
     //   String lname =  lTable.getValueAt(r,2).toString();
        String res =  lTable.getValueAt(r,3).toString();
        String status=  lTable.getValueAt(r,7).toString();
   //     String ins=  lTable.getValueAt(r,8).toString();
        //  String pDate =  Table.getV
      //  String dt=  lTable.getValueAt(r,3).toString();

        String pDate =  lTable.getValueAt(r,2).toString();
        String ppDate =  lTable.getValueAt(r,5).toString();
        String pppDate =  lTable.getValueAt(r,6).toString();

        le4.setText(lid);
        lef1.setText(llid);
   //     lef2.setText(lname);
        lef3.setText(res);
         le3.setText(status);
    
        led1.setDateFormatString(pDate);
        led2.setDateFormatString(ppDate);
        led3.setDateFormatString(pppDate);



// TODO add your handling code here:
    }//GEN-LAST:event_lTableMouseClicked

    private void lef1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lef1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lef1ActionPerformed

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
            java.util.logging.Logger.getLogger(leaveattendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(leaveattendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(leaveattendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(leaveattendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new leaveattendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton aabcd;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel dawasa;
    private javax.swing.JLabel dinaya;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JTable lTable;
    private javax.swing.JLabel le1;
    private javax.swing.JLabel le3;
    private javax.swing.JLabel le4;
    private javax.swing.JComboBox leavetype;
    private com.toedter.calendar.JDateChooser led1;
    private com.toedter.calendar.JDateChooser led2;
    private com.toedter.calendar.JDateChooser led3;
    private javax.swing.JTextField lef1;
    private javax.swing.JTextField lef2;
    private javax.swing.JTextArea lef3;
    private javax.swing.JPanel sidePane;
    // End of variables declaration//GEN-END:variables
}
