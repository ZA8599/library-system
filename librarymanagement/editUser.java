
package librarymanagement;

import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;
import java.text.*;

public class editUser extends javax.swing.JFrame {
    ArrayList<Books>books;
    ArrayList<Staff>borStaff;
    ArrayList<Librarian>borLib;
    ArrayList<Student>borStud;
    
    public editUser() {
        initComponents();
        books = new ArrayList<Books>();
        borStaff = new ArrayList<Staff>();
        borLib = new ArrayList<Librarian>();
        borStud = new ArrayList<Student>();
        
        populateArrayList();
        
        String [] booksArray = new String[books.size()];
        for(int i=0; i<books.size(); i++){
            booksArray[i] = books.get(i).getTitle();
        }
        //JOptionPane.showMessageDialog(null, books.size());
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(booksArray));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Staff", "Librarian", "Student"}));
        
        
    }
    
    public void populateArrayList(){
        try{
            FileInputStream file = new FileInputStream("Library.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            
            boolean endOfFile = false;
            while(!endOfFile){
                try{
                    books.add((Books)inputFile.readObject());
                }catch(EOFException e){
                    endOfFile = true;
                }catch(Exception f){
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }
            inputFile.close();
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
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
        
        try{
            FileInputStream file3 = new FileInputStream("Librarian.dat");
            ObjectInputStream inputFile3 = new ObjectInputStream(file3);
            
            boolean endOfFile = false;
            while(!endOfFile){
                try{
                        borLib.add((Librarian)inputFile3.readObject());
                }catch(EOFException e){
                    endOfFile = true;
                }catch(Exception f){
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }
            inputFile3.close();
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        try{
            FileInputStream file4 = new FileInputStream("Student.dat");
            ObjectInputStream inputFile4 = new ObjectInputStream(file4);
            
            boolean endOfFile = false;
            while(!endOfFile){
                try{
                        borStud.add((Student)inputFile4.readObject());
                }catch(EOFException e){
                    endOfFile = true;
                }catch(Exception f){
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }
            inputFile4.close();
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void saveUserToFile1(){
        try{
            FileOutputStream file = new FileOutputStream("Staff.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            
            for(int i=0; i<borStaff.size(); i++){
                outputFile.writeObject(borStaff.get(i));
            }
            outputFile.close();
             JOptionPane.showMessageDialog(null, "Sucessfully Update!");
             //this.setVisible(false);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void saveUserToFile2(){
        try{
            FileOutputStream file = new FileOutputStream("Librarian.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            
            for(int i=0; i<borLib.size(); i++){
                outputFile.writeObject(borLib.get(i));
            }
            outputFile.close();
             JOptionPane.showMessageDialog(null, "Sucessfully Update!");
             //this.dispose();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void saveUserToFile3(){
        try{
            FileOutputStream file = new FileOutputStream("Student.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            
            for(int i=0; i<borStud.size(); i++){
                outputFile.writeObject(borStud.get(i));
            }
            outputFile.close();
             JOptionPane.showMessageDialog(null, "Sucessfully Update!");
             //this.dispose();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("EDIT USER INFORMATION");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("NAME:");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("ID:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("USER:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("POSITION/ DEPARTMENT/FACULTY:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("BOOK:");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, 341, Short.MAX_VALUE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(43, 43, 43))
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("CANCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jButton2)
                        .addGap(86, 86, 86)
                        .addComponent(jButton1)))
                .addContainerGap(132, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        int selectedIndex = jComboBox2.getSelectedIndex();
        int index = 0;
        
        if(jComboBox1.getSelectedIndex() == 0){
            jTextField1.setText(borStaff.get(selectedIndex).getName());
            jComboBox3.setSelectedIndex(borStaff.get(selectedIndex).getDepartment());
            String book = borStaff.get(selectedIndex).getBook().getTitle();
        //JOptionPane.showMessageDialog(null, book);
            for(int i=0; i<books.size(); i++){
            
            //JOptionPane.showMessageDialog(null, books.get(i));
                if(books.get(i).getTitle().equals(book)){
                    index = i;
                    break;
                }
            }
        
            jComboBox4.setSelectedIndex(index);
        }else if(jComboBox1.getSelectedIndex() == 1){
            jTextField1.setText(borLib.get(selectedIndex).getName());
            jComboBox3.setSelectedIndex(borLib.get(selectedIndex).getPosition());
            String book = borLib.get(selectedIndex).getBook().getTitle();
        //JOptionPane.showMessageDialog(null, book);
            for(int i=0; i<books.size(); i++){
            
            //JOptionPane.showMessageDialog(null, books.get(i));
                if(books.get(i).getTitle().equals(book)){
                    index = i;
                    break;
                }
            }
        
            jComboBox4.setSelectedIndex(index);
        }else{
            jTextField1.setText(borStud.get(selectedIndex).getName());
            jComboBox3.setSelectedIndex(borStud.get(selectedIndex).getFaculty());
            String book = borStud.get(selectedIndex).getBook().getTitle();
        //JOptionPane.showMessageDialog(null, book);
            for(int i=0; i<books.size(); i++){
            
            //JOptionPane.showMessageDialog(null, books.get(i));
                if(books.get(i).getTitle().equals(book)){
                    index = i;
                    break;
                }
            }
        
            jComboBox4.setSelectedIndex(index);
        }
        
       
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dashboardLib dash = new dashboardLib();
        dash.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String [] staffArray = new String[borStaff.size()];
        for(int i=0; i<borStaff.size(); i++){
            staffArray[i] = borStaff.get(i).getStaffID();
        }

        String [] LibArray = new String[borLib.size()];
        for(int i=0; i<borLib.size(); i++){
            LibArray[i] = borLib.get(i).getLibrarianID();
        }
        String [] studArray = new String[borStud.size()];
        for(int i=0; i<borStud.size(); i++){
            studArray[i] = borStud.get(i).getMatricID();
        }
        
        
        if (jComboBox1.getSelectedIndex() == 0){
            jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lecturer", "Dean", "JHEPA"}));
            jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(staffArray));
        }else if (jComboBox1.getSelectedIndex() == 1){
            jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Director", "Technician", "Librarian"}));
            jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(LibArray));
        }else{
            jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FKOM", "FKP", "FKKSA"}));
            jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(studArray));
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selectedIndex = jComboBox2.getSelectedIndex();
        //JOptionPane.showMessageDialog(null, selectedIndex);
        
        int bookIndex = jComboBox4.getSelectedIndex();
        Books book = books.get(bookIndex);
        
        if (jComboBox1.getSelectedIndex() == 0){
            borStaff.get(selectedIndex).setName(jTextField1.getText());
            borStaff.get(selectedIndex).setBook(book);
            borStaff.get(selectedIndex).setDepartment(jComboBox3.getSelectedIndex());
            saveUserToFile1();
            
        }else if (jComboBox1.getSelectedIndex() == 1){
            
            borLib.get(selectedIndex).setName(jTextField1.getText());
            borLib.get(selectedIndex).setBook(book);
            borLib.get(selectedIndex).setPosition(jComboBox3.getSelectedIndex());
            saveUserToFile2();
            
        }else{
            
            borStud.get(selectedIndex).setName(jTextField1.getText());
            borStud.get(selectedIndex).setBook(book);
            borStud.get(selectedIndex).setFaculty(jComboBox3.getSelectedIndex());
            saveUserToFile3();
        }
        dashboardLib dash = new dashboardLib();
        dash.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(editUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
