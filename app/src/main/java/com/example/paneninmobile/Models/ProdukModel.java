package com.example.paneninmobile.Models;

import com.google.gson.annotations.SerializedName;

public class ProdukModel {

        @SerializedName("id_produk")
        private String idProduk;

        @SerializedName("nama_produk")
        private String namaProduk;

        @SerializedName("harga_produk")
        private String hargaProduk;

        @SerializedName("satuan_produk")
        private String satuanProduk;

        @SerializedName("stock_produk")
        private String stockProduk;

        @SerializedName("foto_produk")
        private String fotoProduk;

        @SerializedName("id_jenis_produk")
        private String idJenisProduk;

        @SerializedName("jenis_produk")
        private ProductType jenisProduk;

        public String getIdProduk() {
            return idProduk;
        }

        public void setIdProduk(String idProduk) {
            this.idProduk = idProduk;
        }

        public String getNamaProduk() {
            return namaProduk;
        }

        public void setNamaProduk(String namaProduk) {
            this.namaProduk = namaProduk;
        }

        public String getHargaProduk() {
            return hargaProduk;
        }

        public void setHargaProduk(String hargaProduk) {
            this.hargaProduk = hargaProduk;
        }

        public String getSatuanProduk() {
            return satuanProduk;
        }

        public void setSatuanProduk(String satuanProduk) {
            this.satuanProduk = satuanProduk;
        }

        public String getStockProduk() {
            return stockProduk;
        }

        public void setStockProduk(String stockProduk) {
            this.stockProduk = stockProduk;
        }

        public String getFotoProduk() {
            return fotoProduk;
        }

        public void setFotoProduk(String fotoProduk) {
            this.fotoProduk = fotoProduk;
        }

        public String getIdJenisProduk() {
            return idJenisProduk;
        }

        public void setIdJenisProduk(String idJenisProduk) {
            this.idJenisProduk = idJenisProduk;
        }

        public ProductType getJenisProduk() {
            return jenisProduk;
        }

        public void setJenisProduk(ProductType jenisProduk) {
            this.jenisProduk = jenisProduk;
        }

            public static class ProductType {
                    @SerializedName("id_jenis_produk")
                    private String idJenisProduk;

                    @SerializedName("nama_jenis_produk")
                    private String namaJenisProduk;

                    @SerializedName("foto_jenis_produk")
                    private String fotoJenisProduk;

                    public String getIdJenisProduk() {
                        return idJenisProduk;
                    }

                    public void setIdJenisProduk(String idJenisProduk) {
                        this.idJenisProduk = idJenisProduk;
                    }

                    public String getNamaJenisProduk() {
                        return namaJenisProduk;
                    }

                    public void setNamaJenisProduk(String namaJenisProduk) {
                        this.namaJenisProduk = namaJenisProduk;
                    }

                    public String getFotoJenisProduk() {
                        return fotoJenisProduk;
                    }

                    public void setFotoJenisProduk(String fotoJenisProduk) {
                        this.fotoJenisProduk = fotoJenisProduk;
                    }
            }

}
