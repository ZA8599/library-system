/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;

import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;
import java.text.*;

public class borrowStaff extends javax.swing.JFrame {

    ArrayList<Books>books;
    ArrayList<Staff>borStaff;
    String IDS;
    public borrowStaff() {
        initComponents();
        //JOptionPane.showMessageDialog(null, IDS);
        books = new ArrayList<Books>();
        borStaff = new ArrayList<Staff>();
        populateArrayList();
        
        String [] booksArray = new String[books.size()];
        for(int i=0; i<books.size(); i++){
            booksArray[i] = books.get(i).getTitle();
        }
        //JOptionPane.showMessageDialog(null, books.size());
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(booksArray));
        IDS = staffID.getText();
        int index = 0;
        for(int i=0; i<borStaff.size(); i++){
            //JOptionPane.showMessageDialog(null, IDS);
            if(borStaff.get(i).getStaffID().equals(IDS)){
                index = i;
                
            }
        }
//        staffID.setText(borStaff.get(index).getStaffID());
//        staffName.setText(borStaff.get(index).getName());
//        staffID.setText(borStaff.get(index).getStaffID());
                
    }
    
    
    public void setIDS(String ID){
        this.IDS = ID;
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
        
    }
    
    public void saveBookToFile(){
        try{
            FileOutputStream file = new FileOutputStream("Library.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            
            for(int i=0; i<books.size(); i++){
                outputFile.writeObject(books.get(i));
            }
            outputFile.close();
             //JOptionPane.showMessageDialog(null, "Sucessfully Save!");
             //this.dispose();
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
             JOptionPane.showMessageDialog(null, "Sucessfully Save!");
             //this.setVisible(false);
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
        jLabel6 = new javax.swing.JLabel();
        staffName = new javax.swing.JTextField();
        bookInfo = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        borow = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        back = new javax.swing.JButton();
        staffID = new javax.swing.JTextField();

        setTitle("LMS-Library Management System");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("BORROW BOOK DETAILS");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("NAME");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("ID");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("BOOK TITLE");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("DATE BORROW");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("BOOK INFO");

        staffName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        staffName.setEnabled(false);
        staffName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffNameActionPerformed(evt);
            }
        });

        bookInfo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bookInfo.setEnabled(false);
        bookInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookInfoActionPerformed(evt);
            }
        });

        submit.setBackground(new java.awt.Color(0, 51, 102));
        submit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        submit.setForeground(new java.awt.Color(255, 255, 255));
        submit.setText("BORROW");
        submit.setBorderPainted(false);
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        jLabel7.setText("(e.g: 1/2/2021)");

        borow.setDateFormatString("dd/MM/yyyy");
        borow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borowMouseClicked(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(0, 51, 102));
        back.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagement/back.jpg"))); // NOI18N
        back.setText("BACK");
        back.setBorderPainted(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        staffID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(borow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(staffName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bookInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(staffID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(staffName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(staffID, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(borow, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addGap(39, 39, 39)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(bookInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void staffNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_staffNameActionPerformed

    private void bookInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookInfoActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        int index = 0;
        int bIndex =0;
        String bookTitle;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String selectDate = dateFormat.format(this.borow.getDate());
          
        //JOptionPane.showMessageDialog(null, selectDate);
        
        for(int i=0; i<borStaff.size(); i++){
            
            if(borStaff.get(i).getStaffID().equals(staffID.getText())){
                index = i;
            }
        }
        int bookIndex = jComboBox1.getSelectedIndex();
        Books book = books.get(bookIndex);
        borStaff.get(index).setBook(book);
        borStaff.get(index).setBorrowDate(selectDate);
        borStaff.get(index).getBook().Borrow(borStaff.get(index).getBook().getQty());
        book.Borrow(book.getQty());
        bookTitle = jComboBox1.getSelectedItem().toString();
        for(int i=0; i<books.size(); i++){
            
            if(books.get(i).getTitle().equals(bookTitle)){
                bIndex = i;
            }
        }
        books.get(bIndex).setQty(book.getQty());
        
        saveBookToFile();
        saveUserToFile1();
        
        mainStaff dash = new mainStaff();
        dash.hidden.setText(staffID.getText());
        dash.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_submitActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        int book = jComboBox1.getSelectedIndex();
        Books bookDetail = books.get(book);
        int index = 0;
        bookInfo.setText(bookDetail.getStatus());
        for(int i=0; i<borStaff.size(); i++){
            if(borStaff.get(i).getStaffID().equals(staffID.getText())){
                index = i;
            }
        }
        staffName.setText(borStaff.get(index).getName());
        
        if(bookDetail.getStatus().equals("not available")){
            submit.setEnabled(false);
        }else{
            submit.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void borowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borowMouseClicked
        
    }//GEN-LAST:event_borowMouseClicked

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        mainStaff dashStaff = new mainStaff();
        dashStaff.hidden.setText(staffID.getText());
        dashStaff.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_backActionPerformed

    private void staffIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_staffIDActionPerformed

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
            java.util.logging.Logger.getLogger(borrowStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(borrowStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(borrowStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(borrowStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new borrowStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton back;
    private javax.swing.JTextField bookInfo;
    private com.toedter.calendar.JDateChooser borow;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField staffID;
    private javax.swing.JTextField staffName;
    public javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
