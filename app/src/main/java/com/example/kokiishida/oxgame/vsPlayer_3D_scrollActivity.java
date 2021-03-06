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

public class vsPlayer_3D_scrollActivity extends AppCompatActivity implements View.OnClickListener{

    public int flg[] = new int[27];
    public int count = 0;
    public boolean mark = true;
    private ImageView btn[] = new ImageView[27];
    private Judge_3D judge3D;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3d_scroll);

        judge3D = new Judge_3D();
        textView = findViewById(R.id.text_view);


        for(int i=0; i<btn.length; i++) btn[i]=new ImageView(this);

        btn[0] = findViewById(R.id.button01); btn[1] = findViewById(R.id.button02);
        btn[2] = findViewById(R.id.button03); btn[3] = findViewById(R.id.button04);
        btn[4] = findViewById(R.id.button05); btn[5] = findViewById(R.id.button06);
        btn[6] = findViewById(R.id.button07); btn[7] = findViewById(R.id.button08);
        btn[8] = findViewById(R.id.button09);

        btn[9] = findViewById(R.id.button10); btn[10] = findViewById(R.id.button11);
        btn[11] = findViewById(R.id.button12); btn[12] = findViewById(R.id.button13);
        btn[13] = findViewById(R.id.button14); btn[14] = findViewById(R.id.button15);
        btn[15] = findViewById(R.id.button16); btn[16] = findViewById(R.id.button17);
        btn[17] = findViewById(R.id.button18);

        btn[18] = findViewById(R.id.button19); btn[19] = findViewById(R.id.button20);
        btn[20] = findViewById(R.id.button21); btn[21] = findViewById(R.id.button22);
        btn[22] = findViewById(R.id.button23); btn[23] = findViewById(R.id.button24);
        btn[24] = findViewById(R.id.button25); btn[25] = findViewById(R.id.button26);
        btn[26] = findViewById(R.id.button27);

        for(int i=0; i<btn.length; i++) btn[i].setOnClickListener(this);


        Arrays.fill(flg, -1);
        for (int i=0; i<9; i++) flg[i]=0;

        textView.setText(R.string.turn01);
        //textView.setText("メンテナンス中…");
    }

    @Override
    public void onClick(View v){

        final Drawable btn_color_r = ResourcesCompat.getDrawable(getResources(), R.drawable.shape_r, null);
        final Drawable btn_color_b = ResourcesCompat.getDrawable(getResources(), R.drawable.shape_b, null);
        final Drawable btn_color_w = ResourcesCompat.getDrawable(getResources(), R.drawable.shape_w, null);
        final Drawable btn_color_black = ResourcesCompat.getDrawable(getResources(), R.drawable.shape_black, null);

        while(mark){ //player1の処理
            for(int i=0; i<btn.length; i++){
                if (v == btn[i] && flg[i] == 0) {
                    flg[i]=1;
                    mark=false;
                    if (i==4) {
                        btn[13].setImageDrawable(btn_color_black); //立体中央は置けない
                        flg[22]=0;
                        btn[22].setImageDrawable(btn_color_w); //3層を置けるようにする
                    } else if (i<18) {
                        flg[i+9]=0;
                        btn[i+9].setImageDrawable(btn_color_w); //1か2層なら一つ上を置けるようにする
                    }
                    break;
                }
            }
            if (mark) return; //falseになって(=ヒットして)いなかったらclickイベント終了

            v.setBackground(btn_color_b); //タイルの色変え

            //勝利条件を満たしているかどうかの判定
            if (judge3D.winner(flg)==0) {
                textView.setText(R.string.turn02);
                return;
            }
            else if (judge3D.winner(flg)==1) {
                textView.setTextColor(0xffff0000);
                textView.setText(R.string.str01); //勝利宣言
                Arrays.fill(flg, 1); //以降タップしても反応しないように
                return;
            }
        }

        while(!mark){ //player2の処理
            for(int i=0; i<btn.length; i++){
                if (v == btn[i] && flg[i] == 0) {
                    flg[i]=2;
                    mark=true;
                    if (i==4) {
                        btn[13].setImageDrawable(btn_color_black); //立体中央は置けない
                        flg[22]=0;
                        btn[22].setImageDrawable(btn_color_w); //3層を置けるようにする
                    } else if (i<18) {
                        flg[i+9]=0;
                        btn[i+9].setImageDrawable(btn_color_w); //1か2層なら一つ上を置けるようにする
                    }
                    break;
                }
            }
            if (!mark) return; //trueになって(=ヒットして)いなかったらclickイベント終了

            v.setBackground(btn_color_r); //タイルの色変え

            //勝利条件を満たしているかどうかの判定
            if (judge3D.winner(flg)==0) {
                count++;
                if (count==13) { //この回がPlayer2の13回目(26タイル目)なら引き分け
                    textView.setTextColor(0xffff0000);
                    textView.setText(R.string.str04);
                    return;
                }
                textView.setText(R.string.turn01);
                return;
            }
            else if (judge3D.winner(flg)==2) {
                textView.setTextColor(0xffff0000);
                textView.setText(R.string.str02); //勝利宣言
                Arrays.fill(flg, 2); //以降タップしても反応しないように
                return;
            }
        }
    }

    public void flashFlg(View view) {
        flg = null;
        Intent intent1 = new Intent(vsPlayer_3D_scrollActivity.this, vsPlayer_3D_scrollActivity.class);
        startActivity(intent1);
    }

    public void backHome(View view) {
        flg = null;
        Intent intent2 = new Intent(vsPlayer_3D_scrollActivity.this, MainActivity.class);
        startActivity(intent2);
    }
}

