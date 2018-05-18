package com.example.kokiishida.oxgame;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class vsCpu_2D_Activity extends AppCompatActivity implements View.OnClickListener{

    public int flg[] = new int[9];
    public int temp, temp2, count=0;
    public Random random;
    private ImageView btn[] = new ImageView[9];
    private cpuAlg_2D cpuAlg2D;
    private Judge_2D judge2D;
    private TextView textView;
    private Intent intent;
    private String diff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2d);

        intent = getIntent();
        diff = intent.getStringExtra("Difficulty");

        random = new Random();
        judge2D = new Judge_2D();
        cpuAlg2D = new cpuAlg_2D();
        textView = findViewById(R.id.text_view);

        for(int i=0; i<btn.length; i++){
                btn[i]=new ImageView(this);
        }

        btn[0] = findViewById(R.id.button01);
        btn[1] = findViewById(R.id.button02);
        btn[2] = findViewById(R.id.button03);
        btn[3] = findViewById(R.id.button04);
        btn[4] = findViewById(R.id.button05);
        btn[5] = findViewById(R.id.button06);
        btn[6] = findViewById(R.id.button07);
        btn[7] = findViewById(R.id.button08);
        btn[8] = findViewById(R.id.button09);

        btn[0].setOnClickListener(this);
        btn[1].setOnClickListener(this);
        btn[2].setOnClickListener(this);
        btn[3].setOnClickListener(this);
        btn[4].setOnClickListener(this);
        btn[5].setOnClickListener(this);
        btn[6].setOnClickListener(this);
        btn[7].setOnClickListener(this);
        btn[8].setOnClickListener(this);

        textView.setText(R.string.turn01);

    }

    @Override
    public void onClick(View v) {

        final Drawable btn_color_r = ResourcesCompat.getDrawable(getResources(), R.drawable.shape_r, null);
        final Drawable btn_color_b = ResourcesCompat.getDrawable(getResources(), R.drawable.shape_b, null);

        if (v == btn[0] && flg[0] == 0) flg[0] = 1;
        else if (v == btn[1] && flg[1] == 0) flg[1] = 1;
        else if (v == btn[2] && flg[2] == 0) flg[2] = 1;
        else if (v == btn[3] && flg[3] == 0) flg[3] = 1;
        else if (v == btn[4] && flg[4] == 0) flg[4] = 1;
        else if (v == btn[5] && flg[5] == 0) flg[5] = 1;
        else if (v == btn[6] && flg[6] == 0) flg[6] = 1;
        else if (v == btn[7] && flg[7] == 0) flg[7] = 1;
        else if (v == btn[8] && flg[8] == 0) flg[8] = 1;
        else return;
        v.setBackground(btn_color_b);

        //勝利条件を満たしているかどうかの判定
        if (judge2D.winner(flg)==1) {
            textView.setTextColor(0xffff0000);
            textView.setText(R.string.str01); //勝利宣言
            Arrays.fill(flg, 1); //以降タップしても反応しないように
            return;
        }

        count++; //何回目の手番だったか
        if (count==9){ //9タイル目なら引き分け
            textView.setTextColor(0xffff0000);
            textView.setText(R.string.str04);
            return;
        }

        //CPU側の処理
        textView.setText(R.string.turn03);
        temp2 = (random.nextInt(27)+4)*50;

        //0.2~1.5秒遅延させる
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                temp = cpuAlg2D.select(flg, diff); //CPUが選択するタイルを決定
                flg[temp] = 2;
                btn[temp].setBackground(btn_color_r);

                if (judge2D.winner(flg)==2) {
                    textView.setTextColor(0xffff0000);
                    textView.setText(R.string.str03);
                    Arrays.fill(flg, 2);
                    return;
                }
                count++;
                textView.setText(R.string.turn01);
            }
        }, temp2);

    }

    public void flashFlg(View view) {
        flg = null;
        Intent intent1 = new Intent(vsCpu_2D_Activity.this, vsCpu_2D_Activity.class);
        intent1.putExtra("Difficulty", diff);
        startActivity(intent1);
    }

    public void backHome(View view) {
        flg = null;
        Intent intent2 = new Intent(vsCpu_2D_Activity.this, MainActivity.class);
        startActivity(intent2);
    }

}
