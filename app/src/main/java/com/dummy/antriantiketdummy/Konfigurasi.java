package com.dummy.antriantiketdummy;

public class Konfigurasi {
    //Dibawah ini merupakan Pengalamatan dimana Lokasi Skrip CRUD PHP disimpan
    //Pada tutorial Kali ini, karena kita membuat localhost maka alamatnya tertuju ke IP komputer
    //dimana File PHP tersebut berada
    //PENTING! JANGAN LUPA GANTI IP SESUAI DENGAN IP KOMPUTER DIMANA DATA PHP BERADA
    public static final String URL_ADD="http://192.168.1.7/antrian_tiket/daftarAntrianUser.php";
    public static final String URL_ADD_LOKET_SATU="http://192.168.1.7/antrian_tiket/daftarAntrianLoketSatu.php";
    public static final String URL_ADD_LOKET_DUA="http://192.168.1.7/antrian_tiket/daftarAntrianLoketDua.php";
    public static final String URL_GET_ALL = "http://192.168.1.7/antrian_tiket/tampilSemuaPgw.php";
    public static final String URL_GET_DATA_USER = "http://192.168.1.7/antrian_tiket/tampilDataUser.php?id=";
    public static final String URL_GET_DATA_LOKET_SATU = "http://192.168.1.7/antrian_tiket/tampilDataLoketSatu.php?id=";
    public static final String URL_GET_DATA_LOKET_DUA = "http://192.168.1.7/antrian_tiket/tampilDataLoketDua.php?id=";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_ID = "id";
    public static final String KEY_NAMA = "nama";
    public static final String KEY_NOTELP = "notelp"; //desg itu variabel untuk posisi
    public static final String KEY_ALAMAT = "alamat"; //salary itu variabel untuk gajih

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAMA = "name";
    public static final String TAG_NOTELP = "notelp";
    public static final String TAG_ALAMAT = "alamat";

    //ID karyawan
    //emp itu singkatan dari Employee
    public static final String ANT_ID = "ant_id";
}
