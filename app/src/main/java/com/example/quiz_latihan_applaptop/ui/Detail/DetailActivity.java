package com.example.quiz_latihan_applaptop.ui.Detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.quiz_latihan_applaptop.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class DetailActivity extends AppCompatActivity {

    TextView tvNamaLaptop, tvDetailLaptop;
    ImageView gambarLaptop;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvNamaLaptop = findViewById(R.id.tv_nama_laptop);
        tvDetailLaptop = findViewById(R.id.tv_detail_laptop);
        gambarLaptop = findViewById(R.id.gambar_laptop);



        //menangkap data
        tvNamaLaptop.setText(getIntent().getStringExtra("NAMA"));
        tvDetailLaptop.setText(getIntent().getStringExtra("DETAIL"));

        Glide.with(this).load(getIntent().getStringExtra("GAMBAR"))
                .into(gambarLaptop);



    }

}
