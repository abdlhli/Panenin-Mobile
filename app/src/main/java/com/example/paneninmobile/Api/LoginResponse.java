package com.example.paneninmobile.Api;

public class LoginResponse {

    private LoginDataResponse data;

    public LoginDataResponse getData() {
        return data;
    }

    public void setData(LoginDataResponse data) {
        this.data = data;
    }

    public static class LoginDataResponse {
        private String id_user;
        private String firstname;
        private String lastname;
        private String email;
        private String alamat;
        private String no_telp;
        private int id_hak_akses;
        private String foto_profile;

        public String getId_user() {
            return id_user;
        }

        public void setId_user(String id_user) {
            this.id_user = id_user;
        }

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
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
