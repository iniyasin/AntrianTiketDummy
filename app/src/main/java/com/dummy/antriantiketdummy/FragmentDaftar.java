package com.dummy.antriantiketdummy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class FragmentDaftar extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private EditText edTextNama;
    private EditText edTextNotelp;
    private EditText edTextAlamat;

    private Button btnLoketSatu;
    private Button btnLoketDua;

    private Spinner spinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_daftar);

        edTextNama = (EditText) findViewById(R.id.nama);
        edTextNotelp = (EditText) findViewById(R.id.notelp);
        edTextAlamat = (EditText) findViewById(R.id.alamat);
        btnLoketSatu = (Button) findViewById(R.id.btn_loket_satu);
        btnLoketDua = (Button) findViewById(R.id.btn_loket_dua);

        btnLoketSatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                daftarAntrianLoketSatu();
                Intent intent = new Intent(FragmentDaftar.this, LoketSatu.class);
                startActivity(intent);
            }
        });

        btnLoketDua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                daftarAntrianLoketDua();
                Intent intent = new Intent(FragmentDaftar.this, LoketSatu.class);
                startActivity(intent);
            }
        });
    }

    //method daftar
    private void daftarAntrianLoketSatu(){
        final String nama = edTextNama.getText().toString().trim();
        final String notelp = edTextNotelp.getText().toString().trim();
        final String alamat = edTextAlamat.getText().toString().trim();

        class DaftarAntrianLoketSatu extends AsyncTask<Void, Void, String>{
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(FragmentDaftar.this, "Menambahkan...", "Tunggu....", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(FragmentDaftar.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... voids) {
                HashMap<String, String> params = new HashMap<>();
                params.put(Konfigurasi.KEY_NAMA, nama);
                params.put(Konfigurasi.KEY_NOTELP, notelp);
                params.put(Konfigurasi.KEY_ALAMAT, alamat);

                RequestHandler rh = new RequestHandler();
                return rh.sendPostRequest(Konfigurasi.URL_ADD_LOKET_SATU, params);
            }
        }
        DaftarAntrianLoketSatu da = new DaftarAntrianLoketSatu();
        da.execute();
    }

    private void daftarAntrianLoketDua(){
        final String nama = edTextNama.getText().toString().trim();
        final String notelp = edTextNotelp.getText().toString().trim();
        final String alamat = edTextAlamat.getText().toString().trim();

        class DaftarAntrianLoketDua extends AsyncTask<Void, Void, String>{
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(FragmentDaftar.this, "Menambahkan...", "Tunggu....", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(FragmentDaftar.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... voids) {
                HashMap<String, String> params = new HashMap<>();
                params.put(Konfigurasi.KEY_NAMA, nama);
                params.put(Konfigurasi.KEY_NOTELP, notelp);
                params.put(Konfigurasi.KEY_ALAMAT, alamat);

                RequestHandler rh = new RequestHandler();
                return rh.sendPostRequest(Konfigurasi.URL_ADD_LOKET_DUA, params);
            }
        }
        DaftarAntrianLoketDua da = new DaftarAntrianLoketDua();
        da.execute();
    }

    @Override
    public void onClick(View view) {
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
