package com.raven.service;

import com.raven.connection.DatabaseConnection;
import com.raven.model.ModelPengiriman;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane;

        public class ServicePengiriman {
            private final Connection con;

            public ServicePengiriman() {
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

public int simpanPengiriman(ModelPengiriman pengiriman, double biayaPengiriman, String estimasiPengiriman) {
    String url = "jdbc:mysql://localhost/pap";
    String user = "root";
    String password = "";

    try (Connection connection = DriverManager.getConnection(url, user, password)) {
       // Query untuk mendapatkan kode barang terakhir
       String lastKodeQuery = "SELECT MAX(kode_barang) AS lastKode FROM barang";
       try (PreparedStatement lastKodeStatement = connection.prepareStatement(lastKodeQuery)) {
           ResultSet resultSet = lastKodeStatement.executeQuery();

           // Mendapatkan nilai terakhir dari kolom kode_barang
           int lastKode;

           if (resultSet.next()) {
               lastKode = resultSet.getInt("lastKode");
               // Jika tabel kosong, set lastKode ke 4400
               if (resultSet.wasNull()) {
                   lastKode = 4400;
               }
           } else {
               lastKode = 4400; // Nilai default jika terjadi kesalahan atau tidak ada data
           }

           // Meningkatkan nilai kode untuk data yang baru
           int newKode = lastKode + 1;

           // Query untuk menyimpan data barang
           String insertQuery = "INSERT INTO barang (kode_barang, nama_barang, jumlah_barang, jenis_barang, berat_barang, jenis_pengiriman, estimasi_pengiriman, biaya_pengiriman, alamat_kirim) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
           try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
               preparedStatement.setInt(1, newKode); // Menggunakan nilai kode yang baru
               preparedStatement.setString(2, pengiriman.getNamaBarang());
               preparedStatement.setInt(3, pengiriman.getJumlahBarang());
               preparedStatement.setString(4, pengiriman.getJenisBarang());
               preparedStatement.setDouble(5, pengiriman.getBeratBarang());
               preparedStatement.setString(6, pengiriman.getJenisPengiriman());
               preparedStatement.setString(7, estimasiPengiriman);
               preparedStatement.setDouble(8, biayaPengiriman);
               preparedStatement.setString(9, pengiriman.getAlamatKirim());

               int rowsInserted = preparedStatement.executeUpdate();
               return rowsInserted;
           } catch (SQLException e) {
               JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyimpan data barang: " + e.getMessage());
           }
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mendapatkan kode barang terakhir: " + ex.getMessage());
       }
   } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menghubungkan ke database: " + ex.getMessage());
   }
   return 0; // Gagal

   }






    // Validasi data pengiriman
    private String isValidPengiriman(ModelPengiriman pengiriman) {
        // Lakukan validasi sesuai dengan kebutuhan Anda
        // Misalnya, periksa apakah berat barang, jumlah barang, atau jenis pengiriman memiliki nilai yang valid.
        // Anda juga dapat menambahkan peraturan validasi lainnya yang sesuai.

        if (pengiriman.getBeratBarang() <= 0) {
            return "Berat barang harus lebih dari 0.";
        }

        if (pengiriman.getJumlahBarang() <= 0) {
            return "Jumlah barang harus lebih dari 0.";
        }

        if (pengiriman.getJenisPengiriman() == null || pengiriman.getJenisPengiriman().isEmpty()) {
            return "Pilih jenis pengiriman.";
        }

        // Tambahkan peraturan validasi lainnya di sini...

        // Jika data valid, kembalikan null
        return null;
    }
}
