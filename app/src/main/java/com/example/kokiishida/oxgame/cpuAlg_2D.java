package com.example.kokiishida.oxgame;

import android.util.Log;

import java.util.Arrays;
import java.util.Random;

public class cpuAlg_2D {

    public cpuAlg_2D(){}

    public Random r;
    public int n;

    public int select(int a[], String diff) {
        r = new Random();

        if (diff.equals("VeryEasy")) { //randomに選択する　
            while(true) {
                n = r.nextInt(9);
                if (a[n]==0) return n; //置けるタイルにヒットしたらやめる
            }
        } else if (diff.equals("Easy")) return check(a); //戦略的(王手はわかる)に選択する
        else if (diff.equals("Normal")) return tactics(a); //戦略的(基本方針はわかる)に選択する
        else return minMax(a, 1, true);
    }

    private Judge_2D judge2D;

    public int check(int a[]){
        judge2D = new Judge_2D();
        for (int i=0; i<a.length; i++){ //勝ちタイルがあるか
            if (a[i]==0){
                a[i] = 2; //仮定
                if (judge2D.winner(a)==2) return i; //勝てるなら埋める
                a[i] = 0; //戻す
            }
        }
        for (int i=0; i<a.length; i++){ //負けタイルがあるか
            if (a[i]==0){
                a[i] = 1; //仮定
                if (judge2D.winner(a)==1) return i; //このままだと負けるなら埋める
                a[i] = 0; //戻す
            }
        }
        while(true) {
            n = r.nextInt(9);
            if (a[n]==0) return n; //タップされていないタイルにヒットしたらやめる
        }
    }

    private int b[] = {0, 2, 6, 8}, c[] = {1, 3, 5, 7};

    public int tactics(int a[]){
        judge2D = new Judge_2D(); //最初はcheckと同じ
        for (int i=0; i<a.length; i++){
            if (a[i]==0){
                a[i] = 2;
                if (judge2D.winner(a)==2) return i;
                a[i] = 0;
            }
        }
        for (int i=0; i<a.length; i++){
            if (a[i]==0){
                a[i] = 1;
                if (judge2D.winner(a)==1) return i;
                a[i] = 0;
            }
        }
        if (a[4]==0) return 4; //中央が空いているか
        else if (a[4]==2&&((a[0]==1&&a[8]==1)||(a[2]==1&&a[6]==1))) { //角→中央→対角と置かれたとき
            while (true) {
                n = r.nextInt(4);
                if (a[c[n]]==0) return c[n]; //辺に置く
            }
        }
        else { //基本的には空いている角を埋める
            while (true) {
                n = r.nextInt(4);
                if (a[b[n]]==0) return b[n];
            }
        }
    }
    /*
     * 000 　　 200
     * 021 から 021 を選択してしまったら負け(33%)
     * 100  　　100
     * */

    public int score(int a[], int depth){
        judge2D = new Judge_2D();
        if (judge2D.winner(a)==2) return 10-depth; //できるだけ素早く勝ちたい
        else if (judge2D.winner(a)==1) return depth-10; //できるだけ粘って負けたい
        else return 0;
    }

    public int minMax(int a[], int depth, boolean turn){
        judge2D = new Judge_2D();
        int val, childVal, bestPosition=0; //それぞれノードの評価値、子ノードから伝わってきた評価値、最善手
        if (turn) val = -10; //CPU側：maxを探すために最小値をセットしておく
        else val = 10; //Player側：minを探すために最大値をセットしておく
        for (int i=0; i<a.length; i++){
            if (a[i]==0) { //置けるところにとりあえず置く
                int b[] = Arrays.copyOf(a, a.length); //作業用配列の確保

                if (turn) b[i] = 2;
                else b[i] = 1;

                if (judge2D.winner(b)!=0) childVal =  score(b, depth);
                else childVal = minMax(b, depth + 1, !turn);

                if (turn) { //CPU側
                    if (childVal > val) {
                        val = childVal;
                        bestPosition = i;
                    }
                } else { //Player側
                    if (childVal < val) {
                        val = childVal;
                        bestPosition = i;
                    }
                }
                b = null; //メモリ開放
            }
        }
        if (depth==1) return bestPosition; //depthが1(=rootノード)なら最善手を返す
        else return val; //子ノードなら評価値を返す
    }
}