/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account;

import DB.CRUD;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alonzoch_sd2081
 */
public class ListOfUsers extends javax.swing.JFrame {

    CRUD c = new CRUD();
    DefaultTableModel tm;
    private static String adminPass = "Adm1n@trat0r";
    boolean admin = false;
    private static String user;
    private String data = "";
    private static String username = "";
    JFrame frame = new JFrame();
    Dimension dimension;
    boolean edit = true;
    String tableName = "users";

    /**
     * Creates new form ListOfUsers
     */
    public ListOfUsers() {
        initComponents();
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width / 2 - this.getSize().width / 2, dimension.height / 2 - this.getSize().height / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jTable1.setBackground(new java.awt.Color(240, 240, 240));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Middle Name", "Last Name", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setMinWidth(200);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(300);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("List of users");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Logout");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int row = jTable1.getSelectedRow();
        int column = jTable1.getSelectedColumn();
        username = jTable1.getValueAt(row, 3).toString();
        if (!user.equals(username)) {
            for (int i = 0; i <= column; i++) {
                data += jTable1.getValueAt(row, i) + "\n";
            }
            JOptionPane.showMessageDialog(null, data);
            data = "";
        }

        if (!jTable1.getSelectionModel().isSelectionEmpty()) {
            if (admin) {

//                String accountQuery = "DELETE FROM users WHERE Email=" + "\"" + username + "\"" + ";";
                delete(username);
            }
            if (admin == false) {

//                String accountQue = "DELETE FROM users WHERE Email=" + "\"" + user + "\"" + ";";
//                String accountQuery = "UPDATE users SET FirstName = ? ,"
//                        + "MiddleName = ? ,"
//                        + "LastName = ? ,"
//                        + "Email = ?,"
//                        + "Password = ?"
//                        + "WHERE Email =" + "\"" + username + "\"" + ";";

                JButton editbtn = new JButton("EDIT");
                editbtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (username.equals(user)) {
                            for (int i = 0; i <= column; i++) {
                                data += jTable1.getValueAt(row, i) + "\n";
                            }
                            edit(user);
                        }
                        data = "";
                    }
                });
                JButton deletebtn = new JButton("DELETE");
                deletebtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (username.equals(user)) {
                            for (int i = 0; i <= column; i++) {
                                data += jTable1.getValueAt(row, i) + "\n";
                            }
                            delete(user);
                        }
                        data = "";
                    }
                });

                frame.add(editbtn, BorderLayout.WEST);
                frame.add(deletebtn, BorderLayout.EAST);
                frame.pack();
                frame.setLocation(dimension.width / 2 - this.getSize().width / 5, dimension.height / 2 - this.getSize().height / 5);
                if (username.equals(user)) {
                    frame.setVisible(true);
                }
            }
        }


    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        Login l = new Login();
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1MouseClicked

    public void showUsers() {
//        String accountQuery = "SELECT * FROM users;";
        try {
            // for changing column and row model
            tm = (DefaultTableModel) jTable1.getModel();
            Connection connection = c.connectToDB();
            Statement statement = connection.createStatement();
            ResultSet rsAcc = c.getAllData(tableName);
            while (rsAcc.next()) {
                tm.addRow(new Object[]{rsAcc.getString(2), rsAcc.getString(3), rsAcc.getString(4), rsAcc.getString(5)});
            }
            connection.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }

    public void edit(String userN) {
        int row = jTable1.getSelectedRow();
        if (edit) {
            try {
                Connection connection = c.connectToDB();
                JTextField fname = new JTextField(20);
                fname.setText(jTable1.getValueAt(row, 0).toString());
                JTextField mname = new JTextField(20);
                mname.setText(jTable1.getValueAt(row, 1).toString());
                JTextField lname = new JTextField(20);
                lname.setText(jTable1.getValueAt(row, 2).toString());
                JTextField uname = new JTextField(20);
                uname.setText(jTable1.getValueAt(row, 3).toString());
                JPasswordField pass = new JPasswordField(20);
                JPasswordField confirmpass = new JPasswordField(20);
                Object[] message = {
                    "Edit Values",
                    "First name:", fname,
                    "Middle name:", mname,
                    "Last name:", lname,
                    "Email/Username:", uname,
                    "Password:", pass,
                    "Confirm Password:", confirmpass};
                int option = JOptionPane.showConfirmDialog(null, message, "Enter all your values",
                        JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION && fname.getText().length() >= 3 && mname.getText().length() >= 2
                        && lname.getText().length() >= 2 && uname.getText().length() >= 5 && pass.getText().equals(confirmpass.getText())) {
                    setUser(uname.getText());
                    String[] valuetoEdit = {"FirstName","MiddleName","LastName","Email","Password"};
                    String passW = pass.getText();
                    passW = new SignUp().encryptPassword(passW);
                    String[] data = {fname.getText(),mname.getText(),lname.getText(),uname.getText(),passW};
                    c.editData(tableName, valuetoEdit, data, "Email", username);
                    tm.setRowCount(0);
                    showUsers();
                    if (!pass.getText().equals(confirmpass.getText())) {
                        JOptionPane.showMessageDialog(null, "Password doesn't match.");
                    }else if(fname.getText().length() < 3 && mname.getText().length() < 2
                        && lname.getText().length() < 2 && uname.getText().length() < 5) {
                        JOptionPane.showMessageDialog(null, "Your inputs are invalid please make sure all inputs are valid!");
                    }
                } 

                connection.close();
            } catch (Exception e) {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }
        }

    }

    public void delete(String username) {
        String account = null;
        try {
            Connection connection = c.connectToDB();
            int del = JOptionPane.showConfirmDialog(null, data + "\n" + "Are you sure to delete this account/user?", "MESSAGE", JOptionPane.YES_NO_OPTION);
            if (del == JOptionPane.YES_OPTION) {
                c.deleteData("users", "Email", username);
                tm.setRowCount(0);
                showUsers();

            }
            connection.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public void setAdmin(boolean adminastrator) {
        this.admin = adminastrator;
    }

    public void setUser(String userN) {
        this.user = userN;
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
            java.util.logging.Logger.getLogger(ListOfUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListOfUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListOfUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListOfUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListOfUsers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}