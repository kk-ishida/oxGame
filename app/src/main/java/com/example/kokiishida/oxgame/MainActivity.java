package com.example.kokiishida.oxgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    public int ID, ID2;
    private String text, diff;
    private RadioGroup dimension, difficulty;
    private RadioButton radioButton, radioButton2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dimension = findViewById(R.id.dimension);
        difficulty = findViewById(R.id.difficulty);

        //チェックされているラジオボタンのID取得
        ID = dimension.getCheckedRadioButtonId();
        radioButton = findViewById(ID);
        ID2 = difficulty.getCheckedRadioButtonId();
        radioButton2 = findViewById(ID2);

        //チェックされているラジオボタンの名前
        text = radioButton.getText().toString();
        diff = radioButton2.getText().toString();

        //チェックされているラジオボタンが変更されたときの処理
        dimension.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = findViewById(checkedId);
                text = radioButton.getText().toString();
            }
        });
        difficulty.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton2 = findViewById(checkedId);
                diff = radioButton2.getText().toString();
            }
        });

    }

    protected void vsCPU(View view) {
        if (text.equals("2D")) {
            Intent intent1 = new Intent(MainActivity.this, vsCpu_2D_Activity.class);
            intent1.putExtra("Difficulty", diff);
            startActivity(intent1);
        }else if (text.equals("3D")){
            Intent intent1 = new Intent(MainActivity.this, vsCpu_3D_scrollActivity.class);
            intent1.putExtra("Difficulty", diff);
            startActivity(intent1);
        }
    }

    protected void vsPlayer2(View view){
        if (text.equals("2D")) {
            Intent intent2 = new Intent(MainActivity.this, vsPlayer_2D_Activity.class);
            startActivity(intent2);
        }else if (text.equals("3D")){
            Intent intent2 = new Intent(MainActivity.this, vsPlayer_3D_scrollActivity.class);
            startActivity(intent2);
        }
    }
}
