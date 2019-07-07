package com.dummy.antriantiketdummy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoketSatu extends AppCompatActivity {

    private TextView nomorAntrian;

    private String id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_antrian);

        Intent intent = getIntent();
        id = intent.getStringExtra(Konfigurasi.ANT_ID);

        nomorAntrian = (TextView) findViewById(R.id.nomor_antrian);

        getData();
    }

    private void getData() {
        class GetData extends AsyncTask<Void, Void, String> {
            private ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LoketSatu.this, "Fetching...", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showData(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                return rh.sendGetRequestParam(Konfigurasi.URL_GET_DATA_LOKET_SATU, id);
            }
        }
        GetData ge = new GetData();
        ge.execute();
    }

    private void showData(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(Konfigurasi.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String id = c.getString(Konfigurasi.TAG_ID);

            nomorAntrian.setText(id);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
