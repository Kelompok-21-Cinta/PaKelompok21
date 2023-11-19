// ServicePenyimpanan.java
package com.raven.service;

import com.raven.model.ModelPenyimpanan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ServicePenyimpanan {
    private final Connection con;

    public ServicePenyimpanan() {
        // Menginisialisasi koneksi database
        String url = "jdbc:mysql://localhost/pap"; // URL database MySQL Anda
        String user = "root"; // Nama pengguna database
        String password = ""; // Kata sandi database

        try {
            // Mencoba menghubungkan ke database
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // Menangani kesalahan jika koneksi database gagal
            JOptionPane.showMessageDialog(null, "Gagal menginisialisasi koneksi database.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("Gagal menginisialisasi koneksi database.", e);
        }
    }

    public int simpanDataTransaksi(ModelPenyimpanan penyimpanan) {
        // Query untuk mendapatkan kode admin terakhir
        String lastKodeAdminQuery = "SELECT MAX(kode_admin) AS lastKodeAdmin FROM admin";
        try (PreparedStatement lastKodeAdminStatement = con.prepareStatement(lastKodeAdminQuery)) {
            ResultSet resultSet = lastKodeAdminStatement.executeQuery();

            // Mendapatkan nilai terakhir dari kolom kode_admin
            int lastKodeAdmin;

            if (resultSet.next()) {
                lastKodeAdmin = resultSet.getInt("lastKodeAdmin");
                // Jika tabel kosong, set lastKodeAdmin ke 1
                if (resultSet.wasNull()) {
                    lastKodeAdmin = 1;
                }
            } else {
                lastKodeAdmin = 1; // Nilai default jika terjadi kesalahan atau tidak ada data
            }

            // Query untuk mendapatkan kode barang terakhir
            String lastKodeBarangQuery = "SELECT MAX(kode_barang) AS lastKodeBarang FROM barang";
            try (PreparedStatement lastKodeBarangStatement = con.prepareStatement(lastKodeBarangQuery)) {
                resultSet = lastKodeBarangStatement.executeQuery();

                // Mendapatkan nilai terakhir dari kolom kode_barang
                int lastKodeBarang;

                if (resultSet.next()) {
                    lastKodeBarang = resultSet.getInt("lastKodeBarang");
                    // Jika tabel kosong, set lastKodeBarang ke 4400
                    if (resultSet.wasNull()) {
                        lastKodeBarang = 4400;
                    }
                } else {
                    lastKodeBarang = 4400; // Nilai default jika terjadi kesalahan atau tidak ada data
                }

                // Query untuk menyimpan data transaksi
                String insertQuery = "INSERT INTO data_transaksi (kode_admin, kode_barang, nama_pengirim, nama_penerima) VALUES (?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = con.prepareStatement(insertQuery)) {
                    preparedStatement.setInt(1, lastKodeAdmin); // Menggunakan nilai kode admin terbaru
                    preparedStatement.setInt(2, lastKodeBarang); // Menggunakan nilai kode barang terbaru
                    preparedStatement.setString(3, penyimpanan.getNamaPengirim());
                    preparedStatement.setString(4, penyimpanan.getNamaPenerima());

                    int rowsInserted = preparedStatement.executeUpdate();
                    return rowsInserted;
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyimpan data transaksi: " + e.getMessage());
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mendapatkan kode barang terakhir: " + ex.getMessage());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mendapatkan kode admin terakhir: " + ex.getMessage());
        }

        return 0; // Gagal
    }
}
