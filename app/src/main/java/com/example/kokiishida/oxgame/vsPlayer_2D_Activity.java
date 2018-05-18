package com.example.kokiishida.oxgame;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class vsPlayer_2D_Activity extends AppCompatActivity implements View.OnClickListener{

    public int flg[] = new int[9];
    public int count = 0;
    public boolean mark = true;
    private ImageView btn[] = new ImageView[9];
    private Judge_2D judge2D;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2d);

        judge2D = new Judge_2D();
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

        while(mark) { //player1の処理
            if (v == btn[0] && flg[0] == 0) {
                flg[0] = 1; mark = false;
            } else if (v == btn[1] && flg[1] == 0) {
                flg[1] = 1; mark = false;
            } else if (v == btn[2] && flg[2] == 0) {
                flg[2] = 1; mark = false;
            } else if (v == btn[3] && flg[3] == 0) {
                flg[3] = 1; mark = false;
            } else if (v == btn[4] && flg[4] == 0) {
                flg[4] = 1; mark = false;
            } else if (v == btn[5] && flg[5] == 0) {
                flg[5] = 1; mark = false;
            } else if (v == btn[6] && flg[6] == 0) {
                flg[6] = 1; mark = false;
            } else if (v == btn[7] && flg[7] == 0) {
                flg[7] = 1; mark = false;
            } else if (v == btn[8] && flg[8] == 0) {
                flg[8] = 1; mark = false;
            } else return;
            v.setBackground(btn_color_b); //タイルの色変え

            //勝利条件を満たしているかどうかの判定
            if (judge2D.winner(flg)==0) {
                count++;
                if (count==5) { //この回がPlayer1の5回目(9タイル目)なら引き分け
                    textView.setTextColor(0xffff0000);
                    textView.setText(R.string.str04);
                    return;
                }
                textView.setText(R.string.turn02);
                return;
            }
            else if (judge2D.winner(flg)==1) {
                textView.setTextColor(0xffff0000);
                textView.setText(R.string.str01); //勝利宣言
                Arrays.fill(flg, 1); //以降タップしても反応しないように
                return;
            }
        }

        while(!mark) { //player2の処理
            if (v == btn[0] && flg[0] == 0) {
                flg[0] = 2; mark = true;
            } else if (v == btn[1] && flg[1] == 0) {
                flg[1] = 2; mark = true;
            } else if (v == btn[2] && flg[2] == 0) {
                flg[2] = 2; mark = true;
            } else if (v == btn[3] && flg[3] == 0) {
                flg[3] = 2; mark = true;
            } else if (v == btn[4] && flg[4] == 0) {
                flg[4] = 2; mark = true;
            } else if (v == btn[5] && flg[5] == 0) {
                flg[5] = 2; mark = true;
            } else if (v == btn[6] && flg[6] == 0) {
                flg[6] = 2; mark = true;
            } else if (v == btn[7] && flg[7] == 0) {
                flg[7] = 2; mark = true;
            } else if (v == btn[8] && flg[8] == 0) {
                flg[8] = 2; mark = true;
            } else return;
            v.setBackground(btn_color_r);

            if (judge2D.winner(flg)==0) {
                textView.setText(R.string.turn01);
                return;
            }
            else if (judge2D.winner(flg)==2) {
                textView.setTextColor(0xffff0000);
                textView.setText(R.string.str02);
                Arrays.fill(flg, 2);
                return;
            }
        }

    }

    public void flashFlg(View view) {
        flg = null;
        Intent intent1 = new Intent(vsPlayer_2D_Activity.this, vsPlayer_2D_Activity.class);
        startActivity(intent1);
    }

    public void backHome(View view) {
        flg = null;
        Intent intent2 = new Intent(vsPlayer_2D_Activity.this, MainActivity.class);
        startActivity(intent2);
    }

}
