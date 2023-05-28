package com.example.paneninmobile.Api;

public class UserResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserDataReponse getData() {
        return data;
    }

    public void setData(UserDataReponse data) {
        this.data = data;
    }

    private UserDataReponse data;


    public static class UserDataReponse {
        private String firstname;
        private String lastname;
        private String email;
        private String alamat;

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAlamat() {
            return alamat;
        }

        public void setAlamat(String alamat) {
            this.alamat = alamat;
        }

        public String getNo_telp() {
            return no_telp;
        }

        public void setNo_telp(String no_telp) {
            this.no_telp = no_telp;
        }

        public int getId_hak_akses() {
            return id_hak_akses;
        }

        public void setId_hak_akses(int id_hak_akses) {
            this.id_hak_akses = id_hak_akses;
        }

        public String getFoto_profile() {
            return foto_profile;
        }

        public void setFoto_profile(String foto_profile) {
            this.foto_profile = foto_profile;
        }

        public int getId_user() {
            return id_user;
        }

        public void setId_user(int id_user) {
            this.id_user = id_user;
        }

        private String no_telp;
        private int id_hak_akses;
        private String foto_profile;
        private int id_user;
    }
}
