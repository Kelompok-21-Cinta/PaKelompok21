//package com.raven.service;
//
//import com.raven.connection.DatabaseConnection;
//import com.raven.model.ModelLogin;
//import com.raven.model.ModelUser;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.text.DecimalFormat;
//import java.util.Random;
//
//
// public class ServiceUser {
//
//    private final Connection con;
//
//    public ServiceUser() {
//        con = DatabaseConnection.getInstance().getConnection();
//    }
//
//    public ModelUser login(ModelLogin login) throws SQLException {
//        ModelUser data = null;
//        PreparedStatement p = con.prepareStatement("select Kode_Pengguna, UserName, Email from `pengguna` where BINARY(Email)=? and BINARY(`Password`)=? and `Status`='Verified' limit 1");
//        p.setString(1, login.getEmail());
//        p.setString(2, login.getPassword());
//        ResultSet r = p.executeQuery();
//        if (r.first()) {
//            int userID = r.getInt(1);
//            String userName = r.getString(2);
//            String email = r.getString(3);
//            data = new ModelUser(userID, userName, email, "");
//        }
//        r.close();
//        p.close();
//        return data;
//    }
//
//    public void insertUser(ModelUser user) throws SQLException {
//        PreparedStatement p = con.prepareStatement("insert into `pengguna` (Nama, no_telpon, alamat ,UserName, Email, `Password`, VerifyCode) values (?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
//        String code = generateVerifyCode();
//        p.setString(1, user.getUserName());
//        p.setString(2, user.getEmail());
//        p.setString(3, user.getPassword());
//        p.setString(4, code);
//        p.execute();
//        ResultSet r = p.getGeneratedKeys();
//        r.first();
//        int userID = r.getInt(1);
//        r.close();
//        p.close();
//        user.setKode_Pengguna(userID);
//        user.setVerifyCode(code);
//    }
//
//    private String generateVerifyCode() throws SQLException {
//        DecimalFormat df = new DecimalFormat("000000");
//        Random ran = new Random();
//        String code = df.format(ran.nextInt(1000000));  //  Random from 0 to 999999
//        while (checkDuplicateCode(code)) {
//            code = df.format(ran.nextInt(1000000));
//        }
//        return code;
//    }
//
//    private boolean checkDuplicateCode(String code) throws SQLException {
//        boolean duplicate = false;
//        PreparedStatement p = con.prepareStatement("select Kode_Pengguna from `pengguna` where VerifyCode=? limit 1");
//        p.setString(1, code);
//        ResultSet r = p.executeQuery();
//        if (r.first()) {
//            duplicate = true;
//        }
//        r.close();
//        p.close();
//        return duplicate;
//    }
//
//    public boolean checkDuplicateUser(String user) throws SQLException {
//        boolean duplicate = false;
//        PreparedStatement p = con.prepareStatement("select Kode_Pengguna from `pengguna` where UserName=? and `Status`='Verified' limit 1");
//        p.setString(1, user);
//        ResultSet r = p.executeQuery();
//        if (r.first()) {
//            duplicate = true;
//        }
//        r.close();
//        p.close();
//        return duplicate;
//    }
//
//    public boolean checkDuplicateEmail(String user) throws SQLException {
//        boolean duplicate = false;
//        PreparedStatement p = con.prepareStatement("select Kode_Pengguna from `pengguna` where Email=? and `Status`='Verified' limit 1");
//        p.setString(1, user);
//        ResultSet r = p.executeQuery();
//        if (r.first()) {
//            duplicate = true;
//        }
//        r.close();
//        p.close();
//        return duplicate;
//    }
//
//    public void doneVerify(int userID) throws SQLException {
//        PreparedStatement p = con.prepareStatement("update `pengguna` set VerifyCode='', `Status`='Verified' where UserID=? limit 1");
//        p.setInt(1, userID);
//        p.execute();
//        p.close();
//    }
//
//    public boolean verifyCodeWithUser(int userID, String code) throws SQLException {
//        boolean verify = false;
//        PreparedStatement p = con.prepareStatement("select Kode_Pnegguna from `pengguna` where Kode_Pengguna=? and VerifyCode=? limit 1");
//        p.setInt(1, userID);
//        p.setString(2, code);
//        ResultSet r = p.executeQuery();
//        if (r.first()) {
//            verify = true;
//        }
//        r.close();
//        p.close();
//        return verify;
//    }
//}


package com.raven.service;

import com.raven.connection.DatabaseConnection;
import com.raven.model.ModelLogin;
import com.raven.model.ModelUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Random;

public class ServiceUser {

    private final Connection con;

    public ServiceUser() {
        con = DatabaseConnection.getInstance().getConnection();
    }

public ModelUser login(ModelLogin login) throws SQLException {
    ModelUser data = null;
    String email = login.getEmail();
    String password = login.getPassword();

    if (email.equals("thejak123pasar@gmail.com") && password.equals("1234")) {
        data = new ModelUser();
        data.setUndangan("Admin");
    } else {
        // Cek pengguna biasa atau VIP
        PreparedStatement p = con.prepareStatement("select UserID, UserName, Email, Undangan from `user` where BINARY(Email)=? AND BINARY(`Password`)=? AND `Status` = 'Verified' limit 1");
        p.setString(1, email);
        p.setString(2, password);

        ResultSet r = p.executeQuery();
        if (r.first()) {
            String undangan = r.getString("Undangan");
            if (undangan != null && undangan.equals("VIP")) {
            // Pengguna adalah VIP
            data = new ModelUser(r.getInt("UserID"), r.getString("UserName"), email, undangan);
            data.setUndangan("VIP"); // Sesuaikan dengan "VIP"
        } else if (undangan != null && undangan.equals("Biasa")) {
            // Pengguna adalah pengguna biasa
            data = new ModelUser(r.getInt("UserID"), r.getString("UserName"), email, undangan);
            data.setUndangan("Biasa"); // Sesuaikan dengan "Biasa"
        }

        }

        r.close();
        p.close();
    }
    return data;
}



    public void insertUser(ModelUser user) throws SQLException {
        PreparedStatement p = con.prepareStatement("insert into `user` (UserName, Email, `Password`, VerifyCode, Undangan, Alamat) values (?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
        String code = generateVerifyCode();
        p.setString(1, user.getUserName()); // Kolom UserName
        p.setString(2, user.getEmail()); // Kolom Email
        p.setString(3, user.getPassword()); // Kolom Password
        p.setString(4, code); // Kolom VerifyCode

        // Periksa jenis pendaftaran (pengguna biasa atau VIP) dan atur undangan sesuai dengan jenis pendaftaran
        if (user.getUndangan().equals("VIP")) {
            p.setString(5, "VIP"); // Kolom Undangan
        } else {
            // Jika undangan tidak sesuai (tidak "VIP"), atur undangan sebagai "Biasa"
            p.setString(5, "Biasa"); // Kolom Undangan
        }

        p.setString(6, user.getAlamat()); // Kolom Alamat

        p.execute();
        ResultSet r = p.getGeneratedKeys();
        r.first();
        int userID = r.getInt(1);
        r.close();
        p.close();
        user.setUserID(userID);
        user.setVerifyCode(code);
    }



    private String generateVerifyCode() throws SQLException {
        DecimalFormat df = new DecimalFormat("000000");
        Random ran = new Random();
        String code = df.format(ran.nextInt(1000000));  //  Random from 0 to 999999
        while (checkDuplicateCode(code)) {
            code = df.format(ran.nextInt(1000000));
        }
        return code;
    }

    private boolean checkDuplicateCode(String code) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = con.prepareStatement("select UserID from `user` where VerifyCode=? limit 1");
        p.setString(1, code);
        ResultSet r = p.executeQuery();
        if (r.first()) {
            duplicate = true;
        }
        r.close();
        p.close();
        return duplicate;
    }

    public boolean checkDuplicateUser(String user) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = con.prepareStatement("select UserID from `user` where UserName=? and `Status`='Verified' limit 1");
        p.setString(1, user);
        ResultSet r = p.executeQuery();
        if (r.first()) {
            duplicate = true;
        }
        r.close();
        p.close();
        return duplicate;
    }

    public boolean checkDuplicateEmail(String user) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = con.prepareStatement("select UserID from `user` where Email=? and `Status`='Verified' limit 1");
        p.setString(1, user);
        ResultSet r = p.executeQuery();
        if (r.first()) {
            duplicate = true;
        }
        r.close();
        p.close();
        return duplicate;
    }

    public void doneVerify(int userID) throws SQLException {
        PreparedStatement p = con.prepareStatement("update `user` set VerifyCode='', `Status`='Verified' where UserID=? limit 1");
        p.setInt(1, userID);
        p.execute();
        p.close();
    }

    public boolean verifyCodeWithUser(int userID, String code) throws SQLException {
        boolean verify = false;
        PreparedStatement p = con.prepareStatement("select UserID from `user` where UserID=? and VerifyCode=? limit 1");
        p.setInt(1, userID);
        p.setString(2, code);
        ResultSet r = p.executeQuery();
        if (r.first()) {
            verify = true;
        }
        r.close();
        p.close();
        return verify;
    }
}
