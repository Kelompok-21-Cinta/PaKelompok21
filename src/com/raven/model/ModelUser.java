//package com.raven.model;
//
//public class ModelUser {
//
//    public int getKode_Pengguna() {
//        return getKode_pengguna();
//    }
//
//    public void setKode_Pengguna(int kode_pengguna) {
//        this.setKode_pengguna(kode_pengguna);
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getVerifyCode() {
//        return verifyCode;
//    }
//
//    public void setVerifyCode(String verifyCode) {
//        this.verifyCode = verifyCode;
//    }
//
//    public ModelUser(int kode_pengguna, String nama, String no_Telpon, String email) {
//        this.kode_pengguna = kode_pengguna;
//        this.userName = userName;
//        this.Undangan = Undangan;
//        this.email = email;
//        this.password = password;
//        this.verifyCode = verifyCode;
//    }
//
//    public ModelUser(int kode_pengguna,String nama,String no_Telpon,String email,String udangan, String userName, String password) {
//        this.kode_pengguna = kode_pengguna;
//        this.no_Telpon = no_Telpon; 
//        this.Undangan = Undangan;
//        this.email = email;
//        this.userName = userName;
//        this.password = password;
//    }
//
//    public ModelUser() {
//    }
//
//    private int kode_pengguna;
//    private String nama;
//    private String no_Telpon;
//    private String userName;
//    private String email;
//    private String Undangan;
//    private String Alamat;
//    private String password;
//    private String verifyCode;
//
//    
//    public int getKode_pengguna() {
//        return getKode_Pengguna();
//    }
//
//    
//    public void setKode_pengguna(int kode_pengguna) {
//        this.setKode_Pengguna(kode_pengguna);
//    }
//
//    public String getNama() {
//        return nama;
//    }
//
//    
//    public void setNama(String nama) {
//        this.nama = nama;
//    }
//
//   
//    public String getNo_Telpon() {
//        return no_Telpon;
//    }
//
//    
//    public void setNo_Telpon(String no_Telpon) {
//        this.no_Telpon = no_Telpon;
//    }
//
//    /**
//     * @return the Undangan
//     */
//    public String getundangan() {
//        return Undangan;
//    }
//
//    /**
//     * @param Undangan the Undangan to set
//     */
//    public void setundangan(String Undangan) {
//        this.Undangan = Undangan;
//    }
//
//    /**
//     * @return the Alamat
//     */
//    public String getAlamat() {
//        return getalamat();
//    }
//
//    /**
//     * @param Alamat the Alamat to set
//     */
//    public void setAlamat(String Alamat) {
//        this.setalamat(Alamat);
//    }
//
//    /**
//     * @return the Alamat
//     */
//    public String getalamat() {
//        return Alamat;
//    }
//
//    /**
//     * @param Alamat the Alamat to set
//     */
//    public void setalamat(String Alamat) {
//        this.Alamat = Alamat;
//    }
//
//    public String getVerifycode() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//}

package com.raven.model;

public class ModelUser {




    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
        
    }

        public String getUndangan() {
        return Undangan;
    }

    public void setUndangan(String Undangan) {
        this.Undangan = Undangan;
    }

  
    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }
    public ModelUser(int userID, String userName, String email, String password) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.verifyCode = verifyCode;
        this.Alamat = Alamat;
        this.Undangan = Undangan;
        
   
        
    }

    public ModelUser(int userID, String userName, String email, String password, String Alamat, String Undangan) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.Alamat = Alamat;
        this.Undangan = Undangan;
    }

    public ModelUser() {
    }

    private int userID;
    private String userName;
    private String email;
    private String password;
    private String verifyCode;
    private String Undangan;
    private String Alamat;

   

    
}



