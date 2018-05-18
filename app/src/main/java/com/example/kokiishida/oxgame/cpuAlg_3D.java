package com.example.kokiishida.oxgame;

import java.util.Random;

public class cpuAlg_3D {

    public cpuAlg_3D(){}

    public Random r;
    public int n;

    public int select(int a[], String diff) {
        r = new Random();

        if (diff.equals("VeryEasy")) { //random
            while(true) {
                n = r.nextInt(27);
                if (a[n]==0) return n;
            }
        } else if (diff.equals("Easy")) return check(a); //王手判定可能
        else if (diff.equals("Normal")) return tactics(a); //基本方針
        else return study(a);
    }

    private Judge_3D judge3D;

    public int check(int a[]){
        judge3D = new Judge_3D();
        for (int i=0; i<a.length; i++){ //勝ちタイルがあるか
            if (a[i]==0){
                a[i] = 2; //仮定
                if (judge3D.winner(a)==2) return i; //勝てるなら埋める
                a[i] = 0; //戻す
            }
        }
        for (int i=0; i<a.length; i++){ //負けタイルがあるか
            if (a[i]==0){
                a[i] = 1; //仮定
                if (judge3D.winner(a)==1) return i; //このままだと負けるなら埋める
                a[i] = 0; //戻す
            }
        }
        while(true) {
            n = r.nextInt(27);
            if (a[n]==0) return n;
        }
    }

    private int b[] = {0, 2, 6, 8}, c[] = {1, 3, 5, 7};

    public int tactics(int a[]) {
        judge3D = new Judge_3D();
        for (int i=0; i<a.length; i++){
            if (a[i]==0){
                a[i] = 2;
                if (judge3D.winner(a)==2) return i;
                a[i] = 0;
            }
        }
        for (int i=0; i<a.length; i++){
            if (a[i]==0){
                a[i] = 1;
                if (judge3D.winner(a)==1) return i;
                a[i] = 0;
            }
        }
        if (a[4]==0) return 4; //1層中央が空いているか
        else if (a[4]==1) { //初手1層中央を取られたとき
            if (a[0] == 0 || a[2] == 0 || a[6] == 0 || a[8] == 0){ //埋まっていなければ
                while (true) {
                    n = r.nextInt(4);
                    if (a[b[n]] == 0) return b[n]; //角を取る
                }
            }
        }
        else if (a[4]==2&&((a[0]==1&&a[8]==1)||(a[2]==1&&a[6]==1))) { //角→中央→対角と置かれたとき
            if (a[1] == 0 || a[3] == 0 || a[5] == 0 || a[7] == 0){ //埋まっていなければ
                while (true) {
                    n = r.nextInt(4);
                    if (a[c[n]] == 0) return c[n]; //辺に置く
                }
            }
        }
        while(true) {
            n = r.nextInt(27);
            if (a[n]==0&&n!=22) return n; //置けるタイルにヒットしたらやめる
        }                                    //3層中央は積極的に狙わない
    }
    /*
     *  000　　  200    000
     *  021 から 021 or 221 の選択してしまったら負け(22%)
     *  100  　　100    100
     * */

    public int study(int a[]){
        return 0;
    }
}
