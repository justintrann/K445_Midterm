/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Superk445;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;  
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Justin
 */
public class Office extends javax.swing.JFrame {

    /**
     * Creates new form OfficeStyle
     */
    public Office() {
        initComponents();
        Connect();
        Office();
        Office_Load();
    }
    
    public class StyleItem
    {
        int id;
        String name;
        
        public StyleItem(int id, String name)
        {
            this.id = id;
            this.name = name;
        }
        
        public String toString()
        {
            return name;
        }
    }
    
    //Connect with Database.
    Connection conn;
    PreparedStatement pst;
    ResultSet rs; //rs is for Load jTable
    
    
    public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/k445","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Office.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Office.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Office()
    {
        try {
            pst = conn.prepareStatement("select * from ostyle");
            rs = pst.executeQuery();
            cboxStyle.removeAllItems(); //Make sure clear 
            
            while (rs.next())
            {
                cboxStyle.addItem(new StyleItem (rs.getInt(1),rs.getString(2))); // 1 means row 1 of ostyle table
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Office.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    // HET GIONG NOTEPAD
    
    //Load
    /*
     public void Office_Load()
    {
        int c;
        try {
            pst = conn.prepareStatement("SELECT ostyle.stylename, office.id, office.name, office.style, office.description, office.price FROM office JOIN ostyle ON office.style = ostyle.id "); //query SQL
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            c= rsd.getColumnCount(); //get ColumnCount from database
            
            DefaultTableModel d = (DefaultTableModel)jTable1.getModel(); //DefaultTableModel must import from swing
            d.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2 = new Vector(); //Vector like ArrayList
                
                for(int i=1;i<=c;i++)
                {
                    v2.add(rs.getString("office.id"));
                     v2.add(rs.getString("ostyle.stylename"));
                      v2.add(rs.getString("office.name"));
                       v2.add(rs.getString("office.style"));
                        v2.add(rs.getString("office.description"));
                         v2.add(rs.getString("office.price"));
                          
                           
                   
                }
                d.addRow(v2); // d represent for row o. jTable . c is row o. database
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OfficeStyle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    public void Office_Load()
    {
        int c;
        try {
            pst = conn.prepareStatement("SELECT office.id,office.name,ostyle.stylename,office.description,office.price FROM office JOIN ostyle ON office.style = ostyle.id "); //query SQL
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            c= rsd.getColumnCount(); //get ColumnCount from database
            
            DefaultTableModel d = (DefaultTableModel)jTable1.getModel(); //DefaultTableModel must import from swing
            d.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2 = new Vector(); //Vector like ArrayList
                
                for(int i=1;i<=c;i++)
                {
                    v2.add(rs.getString("office.id"));
                    v2.add(rs.getString("office.name"));
                    v2.add(rs.getString("ostyle.stylename"));
                    v2.add(rs.getString("office.description"));
                    v2.add(rs.getString("office.price"));
                }
                d.addRow(v2); // d represent for row o. jTable . c is row o. database
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OfficeStyle.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        cboxStyle = new javax.swing.JComboBox();
        btxUpdate = new javax.swing.JButton();
        btxAdd = new javax.swing.JButton();
        btxCancel = new javax.swing.JButton();
        btxDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        txtPrice = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Office(s)");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Style");

        btxUpdate.setText("Update");
        btxUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btxUpdateActionPerformed(evt);
            }
        });

        btxAdd.setText("Add");
        btxAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btxAddActionPerformed(evt);
            }
        });

        btxCancel.setText("Cancel");
        btxCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btxCancelActionPerformed(evt);
            }
        });

        btxDelete.setText("Delete");
        btxDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btxDeleteActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Style", "Description", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Description");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Price per month");

        txtDesc.setColumns(20);
        txtDesc.setRows(5);
        jScrollPane2.setViewportView(txtDesc);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btxAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btxDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btxCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btxUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPrice))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(48, 48, 48))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cboxStyle, javax.swing.GroupLayout.Alignment.LEADING, 0, 200, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cboxStyle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btxAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btxUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btxDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btxCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    
    //Add button
    private void btxAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btxAddActionPerformed
        String name = txtName.getText();
        StyleItem sitem = (StyleItem) cboxStyle.getSelectedItem();
        String desc = txtDesc.getText();
        int price = Integer.parseInt(txtPrice.getText());

        //pst is for calling query SQL
        try {
            pst = conn.prepareStatement("insert into office(name,style,description,price)values(?,?,?,?)");
            pst.setString(1, name); //Row 1=>4
            pst.setInt(2, sitem.id);
            pst.setString(3, desc);
            pst.setInt(4, price);
            int k=pst.executeUpdate();
            
            if (k==1) //Successfully
            {
                JOptionPane.showMessageDialog(this, "A New Office has created");
                
                txtName.setText("");
                cboxStyle.setSelectedIndex(-1); //Set width (size of combobox)
                txtDesc.setText("");
                txtPrice.setText(""); //FLAGGG
               // txtName.requestFocus();
               // OfficeStyle_Load(); //Refresh jTable for new data
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Error. Please try again");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Office.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btxAddActionPerformed

    //MouseClick jTable
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int slctIndex = jTable1.getSelectedRow();
        
        int id = Integer.parseInt(d1.getValueAt(slctIndex, 0).toString());
        txtName.setText(d1.getValueAt(slctIndex, 1).toString());
        cboxStyle.setSelectedItem(d1.getValueAt(slctIndex, 2).toString());
                
        btxAdd.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    //Update button
    private void btxUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btxUpdateActionPerformed
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int slctIndex = jTable1.getSelectedRow();
        
        int id = Integer.parseInt(d1.getValueAt(slctIndex, 0).toString());
        
        
        
        String name = txtName.getText();
        StyleItem sitem= (StyleItem) cboxStyle.getSelectedItem();
        String desc = txtDesc.getText();
        int price = Integer.parseInt(txtPrice.getText());
        
        
        //pst is for calling query SQL
        try {
            pst = conn.prepareStatement("update office set name = ?,style = ?,description = ?,price = ? where id = ?");
            pst.setString(1, name);
            pst.setInt(2, sitem.id);
            pst.setString(3, desc); //Need ID to identity e. which need to be update
            pst.setInt(4,price);
            pst.setInt(5, id);
            int k=pst.executeUpdate();
            
            if (k==1) //Successfully
            {
                JOptionPane.showMessageDialog(this, "Updated Successfully");
                txtName.setText("");
                cboxStyle.setSelectedIndex(-1); //Set width (size of combobox)
                txtDesc.setText("");
                txtPrice.setText("");
               // OfficeStyle_Load(); //Refresh jTable for new data
                
                
                btxAdd.setEnabled(true); //Hide when click on jTable
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Error. Please try again");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Office.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btxUpdateActionPerformed
    
    //Delete Button
    private void btxDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btxDeleteActionPerformed
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int slctIndex = jTable1.getSelectedRow();
        
        int id = Integer.parseInt(d1.getValueAt(slctIndex, 0).toString());
        
        //pst is for calling query SQL
        try {
            pst = conn.prepareStatement("delete from ostyle where id = ?");
            pst.setInt(1, id); //Just need ID for delete function
            int k=pst.executeUpdate();
            
            if (k==1) //Successfully
            {
                JOptionPane.showMessageDialog(this, "Deleted Successfully");
                txtName.setText("");
                cboxStyle.setSelectedIndex(-1); //Set width (size of combobox)
                txtName.requestFocus();
                OfficeStyle_Load(); //Refresh jTable for new data
                btxAdd.setEnabled(true);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Error. Please try again");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Office.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btxDeleteActionPerformed

    private void btxCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btxCancelActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btxCancelActionPerformed
    

    //Load Function for jTable
    public void OfficeStyle_Load()
    {
        int c;
        try {
            pst = conn.prepareStatement("Select * from ostyle"); //query SQL
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            c= rsd.getColumnCount(); //get ColumnCount from database
            
            DefaultTableModel d = (DefaultTableModel)jTable1.getModel(); //DefaultTableModel must import from swing
            d.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2 = new Vector(); //Vector like ArrayList
                
                for(int i=1;i<=c;i++)
                {
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("stylename"));
                    v2.add(rs.getString("status"));
                }
                d.addRow(v2); // d represent for row o. jTable . c is row o. database
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Office.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //test
    
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
            java.util.logging.Logger.getLogger(Office.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Office.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Office.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Office.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Office().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btxAdd;
    private javax.swing.JButton btxCancel;
    private javax.swing.JButton btxDelete;
    private javax.swing.JButton btxUpdate;
    private javax.swing.JComboBox cboxStyle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea txtDesc;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
