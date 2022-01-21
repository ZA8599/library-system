
package librarymanagement;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;
import java.text.*;

public class mainStaff extends javax.swing.JFrame {

    ArrayList<Staff>borStaff;
    public mainStaff() {
        initComponents();
        borStaff = new ArrayList<Staff>();
        //JOptionPane.showMessageDialog(null, ID);
        populateArrayList();
        
        int index = 0;
        for(int i=0; i<borStaff.size(); i++){
            //JOptionPane.showMessageDialog(null, IDS);
            if(borStaff.get(i).getStaffID().equals(hidden.getText())){
                index = i;
                
            }
        }
        
        hidden.setText(borStaff.get(index).getName());
    }
    
   public void populateArrayList(){
       
        try{
            FileInputStream file2 = new FileInputStream("Staff.dat");
            ObjectInputStream inputFile2 = new ObjectInputStream(file2);
            
            boolean endOfFile = false;
            while(!endOfFile){
                try{
                    
                    borStaff.add((Staff)inputFile2.readObject());
                    
                }catch(EOFException e){
                    endOfFile = true;
                }catch(Exception f){
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }
            inputFile2.close();
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
//    public String getID(){
//        return ID;
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        returnBook = new javax.swing.JButton();
        borrowBook = new javax.swing.JButton();
        hidden = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LMS-Library Management System");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("WELCOME!");

        returnBook.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        returnBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagement/return.png"))); // NOI18N
        returnBook.setText("RETURN");
        returnBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        returnBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        returnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBookActionPerformed(evt);
            }
        });

        borrowBook.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        borrowBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagement/borrow.jpg"))); // NOI18N
        borrowBook.setText("BORROW");
        borrowBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        borrowBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        borrowBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowBookActionPerformed(evt);
            }
        });

        hidden.setText("jTextField1");
        hidden.setEnabled(false);

        jMenu1.setText("STAFF");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagement/signOut.png"))); // NOI18N
        jMenuItem1.setText("Logout");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(borrowBook)
                        .addGap(58, 58, 58)
                        .addComponent(returnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180))
                    .addComponent(hidden, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(hidden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(borrowBook, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(returnBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Login home = new Login();
        home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void borrowBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowBookActionPerformed
        int index =0;
        borrowStaff borBook = new borrowStaff();
        
        for(int i=0; i<borStaff.size(); i++){
            if(borStaff.get(i).getName().equals(hidden.getText())){
                index = i;
                break;
            }
        }
        
        //borBook.staffID.setText(borStaff.get(index).getStaffID());
        borBook.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_borrowBookActionPerformed

    private void returnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBookActionPerformed
        
        returnBook_Staff retBook = new returnBook_Staff();
        //retBook.staff.setText(this.hidden.getText());
        retBook.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_returnBookActionPerformed

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
            java.util.logging.Logger.getLogger(mainStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrowBook;
    public javax.swing.JTextField hidden;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JButton returnBook;
    // End of variables declaration//GEN-END:variables
}
