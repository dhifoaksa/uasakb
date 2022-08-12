package com.example.uas_akb_10119289.main.catatanharian;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uas_akb_10119289.R;
import com.example.uas_akb_10119289.base.DBHelper;

//09 Agustus 2022, 10119289, Dhifo Aksa Hermawan, IF07
public class SaveKategoriActivity extends AppCompatActivity {

    private EditText titleInput;
    private EditText contentInput;
    private Button btn_simpan, btn_kembali;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_kategori);

        dbHelper = new DBHelper(this);
        titleInput = findViewById(R.id.input_title);
        contentInput = findViewById(R.id.input_content);
        btn_simpan = findViewById(R.id.button_submit);
        btn_kembali = findViewById(R.id.button_back);

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into kategori(kategori) values('" + titleInput.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Kategori Berhasil Dibuat", Toast.LENGTH_LONG).show();
                com.example.uas_akb_10119289.main.catatanharian.KategoriActivity.ma.RefreshList();
                finish();
            }
        });

        btn_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
}