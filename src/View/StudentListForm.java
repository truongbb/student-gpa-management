/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Student;
import Model.StudentDAO;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nhom4
 */
public class StudentListForm extends javax.swing.JFrame implements KeyListener {

    String maSV, tenSV, matKhau, ngaySinh, noiSinh, lop, khoa;
    StudentDAO sinhVienDAO = new StudentDAO();
    Student sinhVien;
    Student sinhVienTemp;

    /**
     * Creates new form ListSinhVienForm
     */
    public StudentListForm() {
        initComponents();
        hienThiDSSinhVien();
        if (LogInForm.maQuyen == 0) {
            jbThem.setVisible(false);
            jbSua.setVisible(false);
            jbXoa.setVisible(false);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jtDSSinhVien = new javax.swing.JTable();
        jlDSSinhVien = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jbThem = new javax.swing.JButton();
        jbSua = new javax.swing.JButton();
        jbXoa = new javax.swing.JButton();
        jbThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtDSSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Student's full name", "Birthday", "Hometown", "Class", "Specializing"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtDSSinhVien.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtDSSinhVienFocusGained(evt);
            }
        });
        jtDSSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtDSSinhVienMouseClicked(evt);
            }
        });
        jtDSSinhVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtDSSinhVienKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtDSSinhVienKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jtDSSinhVien);

        jlDSSinhVien.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jlDSSinhVien.setText("STUDENT LIST");

        jbThem.setText("Add");
        jbThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbThemActionPerformed(evt);
            }
        });

        jbSua.setText("Edit");
        jbSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSuaActionPerformed(evt);
            }
        });

        jbXoa.setText("Delete");
        jbXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jbThem, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSua, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(jbXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbThem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jbThoat.setText("Exit");
        jbThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(jlDSSinhVien)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(324, 324, 324))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jlDSSinhVien)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void hienThiDSSinhVien() {
        ArrayList<Student> dsSV = sinhVienDAO.layDanhSachSinhVien();
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Student ID");
        dtm.addColumn("Student's full name");
        dtm.addColumn("Birthday");
        dtm.addColumn("Hometown");
        dtm.addColumn("Class");
        dtm.addColumn("Specializing");
        for (int i = 0; i < dsSV.size(); i++) {
            String[] data = {dsSV.get(i).getMaSV() + "", dsSV.get(i).getTenSV(), dsSV.get(i).getNgaySinh(),
                dsSV.get(i).getNoiSinh(), dsSV.get(i).getLop(), dsSV.get(i).getKhoa()};
            dtm.addRow(data);
        }
        jtDSSinhVien.setModel(dtm);
        jtDSSinhVien.addKeyListener(this);
    }

    public boolean coThayDoiThongTin() {
        if (sinhVien.getTenSV().equals(sinhVienTemp.getTenSV()) && sinhVien.getNgaySinh().equals(sinhVienTemp.getNgaySinh())
                && sinhVien.getNoiSinh().equals(sinhVienTemp.getNoiSinh())
                && sinhVien.getLop().equals(sinhVienTemp.getLop()) && sinhVien.getKhoa().equals(sinhVienTemp.getKhoa())) {
            return false;
        }
        return true;
    }

    public boolean coThayDoiMa() {
        if (sinhVien.getMaSV().equals(sinhVienTemp.getMaSV())) {
            return false;
        }
        return true;
    }

    private void jbSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSuaActionPerformed
        // TODO add your handling code here:
        if (sinhVien != null) {
            if (!coThayDoiMa()) {
                if (coThayDoiThongTin()) {
                    if (sinhVienDAO.updateSV(sinhVien)) {
                        hienThiDSSinhVien();
                        JOptionPane.showMessageDialog(this, "Editting succeeded");
                    } else {
                        JOptionPane.showMessageDialog(this, "Editting failed");
                        hienThiDSSinhVien();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Choose a student, RETYPE any infor (except ID) and press ENTER to change");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Cannot change student's ID");
                hienThiDSSinhVien();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Choose a student, RETYPE any infor (except ID) and press ENTER to change");
        }
        sinhVien = null;
        sinhVienTemp = null;
    }//GEN-LAST:event_jbSuaActionPerformed

    private void jbXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbXoaActionPerformed
        // TODO add your handling code here:
        if (sinhVienTemp != null) {
            if (sinhVienDAO.xoaSV(sinhVienTemp.getMaSV())) {
                hienThiDSSinhVien();
                JOptionPane.showMessageDialog(this, "Deleting succeeded");
            } else {
                JOptionPane.showMessageDialog(this, "Deleting failed");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Choose a student by click on and click Delete to remove");

        }
        sinhVien = null;
        sinhVienTemp = null;
    }//GEN-LAST:event_jbXoaActionPerformed

    private void jbThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbThoatActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jbThoatActionPerformed

    private void jtDSSinhVienKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDSSinhVienKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDSSinhVienKeyPressed

    private void jtDSSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtDSSinhVienMouseClicked
        int rowSelected = jtDSSinhVien.getSelectedRow();
        if (rowSelected == -1) {
            return;
        }
        maSV = jtDSSinhVien.getValueAt(rowSelected, 0) + "";
        tenSV = jtDSSinhVien.getValueAt(rowSelected, 1) + "";
        ngaySinh = jtDSSinhVien.getValueAt(rowSelected, 2) + "";
        noiSinh = jtDSSinhVien.getValueAt(rowSelected, 3) + "";
        lop = jtDSSinhVien.getValueAt(rowSelected, 4) + "";
        khoa = jtDSSinhVien.getValueAt(rowSelected, 5) + "";
        Student sinhVienTemp1 = sinhVienDAO.laySVTheoMa(maSV);
        sinhVienTemp = new Student(maSV, tenSV, sinhVienTemp1.getMatKhau(), ngaySinh, noiSinh, lop, khoa);
    }//GEN-LAST:event_jtDSSinhVienMouseClicked

    private void jtDSSinhVienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDSSinhVienKeyTyped
    }//GEN-LAST:event_jtDSSinhVienKeyTyped

    private void jtDSSinhVienFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtDSSinhVienFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDSSinhVienFocusGained

    private void jbThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbThemActionPerformed
        // TODO add your handling code here:
        new RegisterForm().setVisible(true);
    }//GEN-LAST:event_jbThemActionPerformed

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
            java.util.logging.Logger.getLogger(StudentListForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentListForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentListForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentListForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
//        
        //</editor-fold>
//        
        //</editor-fold>
//        
        //</editor-fold>
//        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new StudentListForm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbSua;
    private javax.swing.JButton jbThem;
    private javax.swing.JButton jbThoat;
    private javax.swing.JButton jbXoa;
    private javax.swing.JLabel jlDSSinhVien;
    private static javax.swing.JTable jtDSSinhVien;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (LogInForm.maQuyen == 1) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                int rowSelected = jtDSSinhVien.getSelectedRow();
                if (rowSelected == -1) {
                    return;
                }
                maSV = jtDSSinhVien.getValueAt(rowSelected, 0) + "";
                tenSV = jtDSSinhVien.getValueAt(rowSelected, 1) + "";
                ngaySinh = jtDSSinhVien.getValueAt(rowSelected, 2) + "";
                noiSinh = jtDSSinhVien.getValueAt(rowSelected, 3) + "";
                lop = jtDSSinhVien.getValueAt(rowSelected, 4) + "";
                khoa = jtDSSinhVien.getValueAt(rowSelected, 5) + "";
                Student sinhVienTemp1 = sinhVienDAO.laySVTheoMa(sinhVienTemp.getMaSV());
                sinhVien = new Student(maSV, tenSV, sinhVienTemp1.getMatKhau(), ngaySinh, noiSinh, lop, khoa);
            }
        } else {
            hienThiDSSinhVien();
            JOptionPane.showMessageDialog(this, "Cannot change anything in this table");
        }
    }

}