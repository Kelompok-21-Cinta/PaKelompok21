/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.raven.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aditya D
 */
public class TransaksiPenggunaAdmin1 extends javax.swing.JFrame {
    // Konfigurasi koneksi database
    String url = "jdbc:mysql://localhost:3306/pap"; // Ganti sesuai dengan nama database Anda
    String username = "root";
    String password = "";
    Connection conn;

    public TransaksiPenggunaAdmin1() {
        initComponents();
        conn = connectToDatabase(); // Fungsi untuk menghubungkan ke database
        showDataInTable(); // Menampilkan data dalam tabel saat aplikasi dijalankan
        txtTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
    }

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {
        // Implementasi sesuai kebutuhan
        // ...
    }

    private Connection connectToDatabase() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    
    private void addNewRecord() {

       try {
           // Menggunakan JOIN untuk mendapatkan biaya_pengiriman dari tabel barang
           String sql = "INSERT INTO data_transaksi (biaya_pengiriman, status, kode_barang, nama_pengirim, nama_penerima) " +
                        "SELECT b.biaya_pengiriman, ?, ?, ?, ? " +
                        "FROM barang b " +
                        "WHERE b.kode_barang = ?";

           PreparedStatement stmt = conn.prepareStatement(sql);

           // Isi nilai parameter sesuai data dari kolom teks
           stmt.setString(1, jTextField3.getText());
           stmt.setInt(2, Integer.parseInt(jTextField4.getText()));
           stmt.setString(3, jTextField5.getText());
           stmt.setString(4, jTextField6.getText());
           stmt.setInt(5, Integer.parseInt(jTextField4.getText())); // Sesuaikan dengan kolom yang benar

           stmt.executeUpdate();
           JOptionPane.showMessageDialog(this, "Rekaman berhasil ditambahkan");
           showDataInTable();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }


        private void editSelectedRecord() {
           try {
               int selectedRow = txtTabel.getSelectedRow();
               if (selectedRow == -1) {
                   JOptionPane.showMessageDialog(this, "Pilih rekaman yang akan diubah");
                   return;
               }

               int kodeTransaksi = (int) txtTabel.getValueAt(selectedRow, 0);
               String sql = "UPDATE data_transaksi dt " +
                            "JOIN barang b ON dt.kode_barang = b.kode_barang " +
                            "SET dt.biaya_pengiriman=?, dt.status=?, dt.kode_barang=?, dt.nama_pengirim=?, dt.nama_penerima=? " +
                            "WHERE dt.kode_transaksi=?";
               PreparedStatement stmt = conn.prepareStatement(sql);

               // Isi nilai parameter sesuai data dari kolom teks
               stmt.setInt(1, Integer.parseInt(jTextField2.getText()));
               stmt.setString(2, jTextField3.getText());
               stmt.setInt(3, Integer.parseInt(jTextField4.getText()));
               stmt.setString(4, jTextField5.getText());
               stmt.setString(5, jTextField6.getText());
               stmt.setInt(6, kodeTransaksi);

               stmt.executeUpdate();
               JOptionPane.showMessageDialog(this, "Rekaman berhasil diubah");
               showDataInTable();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }

    private void deleteSelectedRecord() {
        try {
            int selectedRow = txtTabel.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Pilih rekaman yang akan dihapus");
                return;
            }

            int kodeTransaksi = (int) txtTabel.getValueAt(selectedRow, 0);
            String sql = "DELETE FROM data_transaksi WHERE kode_transaksi=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, kodeTransaksi);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Rekaman berhasil dihapus");
            showDataInTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showDataInTable() {
        try {
            String sql = "SELECT dt.kode_transaksi, b.biaya_pengiriman, dt.status, dt.kode_barang, dt.nama_pengirim, dt.nama_penerima " +
                    "FROM data_transaksi dt " +
                    "JOIN barang b ON dt.kode_barang = b.kode_barang";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            DefaultTableModel model = (DefaultTableModel) txtTabel.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                int kodeTransaksi = rs.getInt("kode_transaksi");
                int biayaPengiriman = rs.getInt("biaya_pengiriman");
                String status = rs.getString("status");
                int kodeBarang = rs.getInt("kode_barang");
                String namaPengirim = rs.getString("nama_pengirim");
                String namaPenerima = rs.getString("nama_penerima");

                model.addRow(new Object[]{kodeTransaksi, biayaPengiriman, status, kodeBarang, namaPengirim, namaPenerima});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    /**
     * Creates new form TransaksiAdminOk
     */

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        txtHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTabel = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(204, 0, 0));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER-GK\\Downloads\\traan.png")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jLabel2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(242, 242, 242))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 85, Short.MAX_VALUE))
        );

        jButton4.setText("Kembali");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtHapus.setText("Hapus");
        txtHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton4)
                        .addGap(34, 34, 34)
                        .addComponent(txtHapus)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(txtHapus)))
        );

        txtTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Kode Transaksi", "Biaya Pengantaran", "Status ", "Kode Barang", "Nama Pengirim", "Nama Penerima"
            }
        ));
        txtTabel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtTabelAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(txtTabel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 

    private void txtTabelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtTabelAncestorAdded
 


    }//GEN-LAST:event_txtTabelAncestorAdded

    private void txtHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHapusActionPerformed
        deleteSelectedRecord();
    }//GEN-LAST:event_txtHapusActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
        new Admin().setVisible(true);;
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(TransaksiPenggunaAdmin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiPenggunaAdmin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiPenggunaAdmin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiPenggunaAdmin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiPenggunaAdmin1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JButton txtHapus;
    private javax.swing.JTable txtTabel;
    // End of variables declaration//GEN-END:variables
}
