package librarymanagement;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;
import java.text.*;
//DecimalFormat formatter;

public class Lib extends javax.swing.JFrame {

    ArrayList<Books>books;
    ArrayList<Borrower>borStaff;
    ArrayList<Borrower>borLib;
    ArrayList<Borrower>borStud;
    public Lib() {
        initComponents();
        books = new ArrayList<Books>();
        borStaff = new ArrayList<Borrower>();
        borLib = new ArrayList<Borrower>();
        borStud = new ArrayList<Borrower>();
        
        populateArrayList();
        
        
        String [] booksArray = new String[books.size()];
        for(int i=0; i<books.size(); i++){
            booksArray[i] = books.get(i).getTitle();
        }
        //JOptionPane.showMessageDialog(null, books.size());
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(booksArray));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Staff", "Librarian", "Student"}));
        jComboBox1.setSelectedIndex(0);
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
             JOptionPane.showMessageDialog(null, "Sucessfully Save!");
             this.dispose();
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
             JOptionPane.showMessageDialog(null, "Sucessfully Save!");
             this.dispose();
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
             JOptionPane.showMessageDialog(null, "Sucessfully Save!");
             this.setVisible(false);
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
        panel1 = new java.awt.Panel();
        name = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        position = new javax.swing.JLabel();
        nameLib = new javax.swing.JTextField();
        idLib = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        cancel = new javax.swing.JButton();
        save = new javax.swing.JButton();

        setTitle("LMS-Library Management System");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("ADD USER INFORMATION");

        name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        name.setText("NAME:");

        id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        id.setText("ID:");

        position.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        position.setText(" POSITION/DEPARTMENT/FACULTY:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("USER:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("BOOK:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(id)
                            .addComponent(name))
                        .addGap(67, 67, 67)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameLib)
                            .addComponent(idLib)
                            .addComponent(jComboBox1, 0, 401, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(position)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox3, 0, 401, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLib, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLib, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(27, 27, 27))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)))
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(position, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        cancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancel.setText("CANCEL");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        save.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        save.setText("SAVE");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 65, Short.MAX_VALUE)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(215, 215, 215))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancel)
                        .addGap(119, 119, 119)
                        .addComponent(save)
                        .addGap(305, 305, 305))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(cancel))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        String name = nameLib.getText().trim();
        String id = idLib.getText();
        
        int bookIndex = jComboBox2.getSelectedIndex();
        Books book = books.get(bookIndex);
        
        int posDepFac = jComboBox3.getSelectedIndex();
        
        if(jComboBox1.getSelectedIndex() == 0){
            Borrower bors = new Staff(book, id, name, posDepFac);
            borStaff.add(bors);
            //JOptionPane.showMessageDialog(null, book);
            saveUserToFile1();
        }else if(jComboBox1.getSelectedIndex() == 1){
            Borrower bors = new Librarian(book, id, name, posDepFac);
            borLib.add(bors);
            //JOptionPane.showMessageDialog(null, book);
            saveUserToFile2();
        }else{
            Borrower bors = new Student(book, id, name, posDepFac);
            borStud.add(bors);
            //JOptionPane.showMessageDialog(null, book);
            saveUserToFile3();
        }
        
        
        dashboardLib dash = new dashboardLib();
        dash.setVisible(true);
    }//GEN-LAST:event_saveActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if (jComboBox1.getSelectedIndex() == 0){
            jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lecturer", "Dean", "JHEPA"}));
        }else if (jComboBox1.getSelectedIndex() == 1){
            jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Director", "Technician", "Librarian"}));
        }else{
            jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FKOM", "FKP", "FKKSA"}));
        }
            
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        dashboardLib dash = new dashboardLib();
        dash.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cancelActionPerformed

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
            java.util.logging.Logger.getLogger(Lib.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lib.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lib.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lib.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lib().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JLabel id;
    private javax.swing.JTextField idLib;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel name;
    private javax.swing.JTextField nameLib;
    private java.awt.Panel panel1;
    public javax.swing.JLabel position;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}
