/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.raven.main;

import com.raven.component.PanelCover;
import com.raven.component.PanelLoading;
import com.raven.model.ModelPengiriman;
import com.raven.service.ServicePengiriman;
import com.raven.model.ModelPenyimpanan;
import com.raven.service.ServicePenyimpanan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Aditya D
 */
public class DropOff extends javax.swing.JFrame {
    private MigLayout layout;
    private PanelLoading loading;
    private PanelCover cover;
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginSize = 60;
    private ServicePengiriman servicePengiriman;
    private ServicePenyimpanan servicePenyimpanan;
    public DropOff() {
        initComponents();
        loading = new PanelLoading();
        cover = new PanelCover();
        layout = new MigLayout("fill, insets 0");
        Merah.setLayout(layout);
        Merah.setLayer(loading, JLayeredPane.POPUP_LAYER);
        Merah.add(loading, "pos 0 0 100% 100%");
        updateBiayaEstimasi();
        servicePenyimpanan = new ServicePenyimpanan();
        servicePengiriman = new ServicePengiriman();
                // Menambahkan ActionListener ke combo box yang memicu pembaruan biaya dan estimasi
        txtberat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBiayaEstimasi();
            }
        });
        txtpilih.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBiayaEstimasi();
            }
        });
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        putih = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Merah = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtKembali = new javax.swing.JButton();
        txtKirim = new javax.swing.JButton();
        txtnama = new javax.swing.JTextField();
        txtalamat = new javax.swing.JTextField();
        txtnmbrg = new javax.swing.JTextField();
        txtjmbrg = new javax.swing.JTextField();
        txtjnsbrg = new javax.swing.JTextField();
        txtbrg = new javax.swing.JTextField();
        txtberat = new javax.swing.JComboBox<>();
        txtestimasi = new javax.swing.JTextField();
        txtpilih = new javax.swing.JComboBox<>();
        txtbiaya = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtnama2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        putih.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(69, 68, 68));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Drop Off");

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER-GK\\Downloads\\rag.png")); // NOI18N

        jPanel3.setBackground(new java.awt.Color(153, 0, 0));

        txtKembali.setText("Kembali");
        txtKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKembaliActionPerformed(evt);
            }
        });

        txtKirim.setText("Kirim");
        txtKirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKirimActionPerformed(evt);
            }
        });

        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });

        txtberat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kilo Gram", "Gram" }));

        txtpilih.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reguler", "Ekspress", "Kargo" }));

        jLabel2.setText("Nama Penerima");

        jLabel3.setText("Alamat ");

        jLabel6.setText("Nama Barang");

        jLabel7.setText("Jumlah Barang");

        jLabel8.setText("Jenis Barang");

        jLabel9.setText("Berat");

        jLabel10.setText("Jenis Pengiriman");

        jLabel11.setText("Estimasi Pengiriman");

        jLabel12.setText("Biaya Kirim");

        txtnama2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnama2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nama Pengirim");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtKembali)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtKirim)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(70, 220, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtpilih, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtestimasi)
                            .addComponent(txtbiaya, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(jLabel1))
                            .addGap(108, 108, 108)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtnama, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtalamat, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtnmbrg, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtjmbrg, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtjnsbrg, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(txtbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtberat, 0, 161, Short.MAX_VALUE))
                                .addComponent(txtnama2)))))
                .addGap(232, 232, 232))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnama2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnmbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtjmbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtjnsbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtberat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpilih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtestimasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbiaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKembali)
                    .addComponent(txtKirim)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 248, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(231, 231, 231))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(595, 595, 595)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(522, 522, 522)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        Merah.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout MerahLayout = new javax.swing.GroupLayout(Merah);
        Merah.setLayout(MerahLayout);
        MerahLayout.setHorizontalGroup(
            MerahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MerahLayout.setVerticalGroup(
            MerahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MerahLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout putihLayout = new javax.swing.GroupLayout(putih);
        putih.setLayout(putihLayout);
        putihLayout.setHorizontalGroup(
            putihLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(putihLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Merah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        putihLayout.setVerticalGroup(
            putihLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(putihLayout.createSequentialGroup()
                .addGroup(putihLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(putihLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(putihLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Merah)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(putih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(putih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
       // Method to update txtbiaya and txtestimasi based on user selections

    
    // Metode untuk memperbarui biaya dan estimasi berdasarkan pilihan pengguna
    private void updateBiayaEstimasi() {
        String selectedBerat = (String) txtberat.getSelectedItem();
        String selectedPengiriman = (String) txtpilih.getSelectedItem();

        double berat = 0;
        try {
            berat = Double.parseDouble(txtbrg.getText());
        } catch (NumberFormatException ex) {
            // Handle invalid input here, e.g., display an error message
            return;
        }

        double biaya = 0;
        String estimasi = "";

        if ("Kilo Gram".equals(selectedBerat)) {
            biaya = berat * 10000; // 10000 per kilogram
        } else if ("Gram".equals(selectedBerat)) {
            biaya = berat * 0.01;  // 1 kilogram = 1000 grams
        }

        if ("Reguler".equals(selectedPengiriman)) {
            estimasi = "3 hari";
        } else if ("Ekspress".equals(selectedPengiriman)) {
            estimasi = "1 hari";
            biaya *= 2;
        } else if ("Kargo".equals(selectedPengiriman)) {
            estimasi = "5 hari";
            biaya = berat * 5000; // 5000 per kilogram
        }

        txtbiaya.setText(String.valueOf(biaya));
        txtestimasi.setText(estimasi);
    }

    private void txtKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKembaliActionPerformed
        this.dispose();
        new Biasa().setVisible(true);;
    }//GEN-LAST:event_txtKembaliActionPerformed

    private void txtKirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKirimActionPerformed
                                         
    String alamatKirim = txtalamat.getText();
    String namaBarang = txtnmbrg.getText();
    String jumlahBarangStr = txtjmbrg.getText();
    String jenisBarang = txtjnsbrg.getText();
    String beratBarangStr = txtbrg.getText();
    String jenisPengiriman = (String) txtpilih.getSelectedItem();

    if (namaBarang.isEmpty() || jumlahBarangStr.isEmpty() || jenisBarang.isEmpty() || beratBarangStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Harap isi semua kolom dengan benar.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int jumlahBarang = Integer.parseInt(jumlahBarangStr);
        double beratBarang = Double.parseDouble(beratBarangStr);

        double biayaPengiriman = Double.parseDouble(txtbiaya.getText());
        String estimasiPengiriman = txtestimasi.getText();

        ModelPengiriman pengiriman = new ModelPengiriman();
        pengiriman.setAlamatKirim(alamatKirim);
        pengiriman.setNamaBarang(namaBarang);
        pengiriman.setJumlahBarang(jumlahBarang);
        pengiriman.setJenisBarang(jenisBarang);
        pengiriman.setBeratBarang(beratBarang);
        pengiriman.setJenisPengiriman(jenisPengiriman);
        pengiriman.setEstimasiPengiriman(estimasiPengiriman);
        pengiriman.setBiayaPengiriman(biayaPengiriman);

        int hasil = servicePengiriman.simpanPengiriman(pengiriman, biayaPengiriman, estimasiPengiriman);

        if (hasil > 0) {
            // Setelah pengiriman berhasil, tambahkan logika penyimpanan
            ModelPenyimpanan penyimpanan = new ModelPenyimpanan( txtnama2.getText(), txtnama.getText());

            penyimpanan.setNamaPengirim(txtnama2.getText()); // Gantilah txtNamaPengirim dengan komponen yang sesuai
            penyimpanan.setNamaPenerima(txtnama.getText()); // Gantilah txtNamaPenerima dengan komponen yang sesuai

            int hasilPenyimpanan = servicePenyimpanan.simpanDataTransaksi(penyimpanan);

            if (hasilPenyimpanan > 0) {
                // Logika ketika penyimpanan berhasil
                JOptionPane.showMessageDialog(this, "Data penyimpanan berhasil disimpan.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Logika ketika penyimpanan gagal
                JOptionPane.showMessageDialog(this, "Gagal menyimpan data penyimpanan.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }

            loading.setVisible(true);
            loading.setVisible(false);
            JOptionPane.showMessageDialog(this, "Pengiriman berhasil Diakukan.", "Sukses", JOptionPane.INFORMATION_MESSAGE);

            // Setelah pengiriman berhasil, kosongkan semua JTextFields
            txtnama.setText("");
            txtalamat.setText("");
            txtnmbrg.setText("");
            txtjmbrg.setText("");
            txtjnsbrg.setText("");
            txtbrg.setText("");
            txtberat.setSelectedIndex(0);
            txtpilih.setSelectedIndex(0);
            txtestimasi.setText("");
            txtbiaya.setText("");
        } else {
            loading.setVisible(true);
            loading.setVisible(false);
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException e) {
        loading.setVisible(false);
        JOptionPane.showMessageDialog(this, "Jumlah barang dan berat barang harus berupa angka yang valid.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
    


}

    
    }//GEN-LAST:event_txtKirimActionPerformed

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed

    }//GEN-LAST:event_txtnamaActionPerformed

    private void txtnama2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnama2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnama2ActionPerformed

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
            java.util.logging.Logger.getLogger(DropOff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DropOff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DropOff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DropOff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DropOff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane Merah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel putih;
    private javax.swing.JButton txtKembali;
    private javax.swing.JButton txtKirim;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JComboBox<String> txtberat;
    private javax.swing.JTextField txtbiaya;
    private javax.swing.JTextField txtbrg;
    private javax.swing.JTextField txtestimasi;
    private javax.swing.JTextField txtjmbrg;
    private javax.swing.JTextField txtjnsbrg;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnama2;
    private javax.swing.JTextField txtnmbrg;
    private javax.swing.JComboBox<String> txtpilih;
    // End of variables declaration//GEN-END:variables
}
