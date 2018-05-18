package com.example.kokiishida.oxgame;

public class Judge_3D {

    public Judge_3D(){}

    public int winner(int a[]){
        //下
        if (a[0]!=0 && a[0]==a[1] && a[0]==a[2]) return a[0];
        else if (a[3]!=0 && a[3]==a[4] && a[3]==a[5]) return a[3];
        else if (a[6]!=0 && a[6]==a[7] && a[6]==a[8]) return a[6];
        else if (a[0]!=0 && a[0]==a[3] && a[0]==a[6]) return a[0];
        else if (a[1]!=0 && a[1]==a[4] && a[1]==a[7]) return a[1];
        else if (a[2]!=0 && a[2]==a[5] && a[2]==a[8]) return a[2];
        else if (a[0]!=0 && a[0]==a[4] && a[0]==a[8]) return a[4];
        else if (a[2]!=0 && a[2]==a[4] && a[2]==a[6]) return a[4];
        //奥(下1)
        else if (a[9]>0 && a[9]==a[10] && a[9]==a[11]) return a[9];
        else if (a[18]>0 && a[18]==a[19] && a[18]==a[20]) return a[18];
        else if (a[0]!=0 && a[0]==a[9] && a[0]==a[18]) return a[0];
        else if (a[1]!=0 && a[1]==a[10] && a[1]==a[19]) return a[1];
        else if (a[2]!=0 && a[2]==a[11] && a[2]==a[20]) return a[2];
        else if (a[0]!=0 && a[0]==a[10] && a[0]==a[20]) return a[10];
        else if (a[2]!=0 && a[2]==a[10] && a[2]==a[18]) return a[10];
        //手前(下1)
        else if (a[15]>0 && a[15]==a[16] && a[15]==a[17]) return a[15];
        else if (a[24]>0 && a[24]==a[25] && a[24]==a[26]) return a[24];
        else if (a[6]!=0 && a[6]==a[15] && a[6]==a[24]) return a[6];
        else if (a[7]!=0 && a[7]==a[16] && a[7]==a[25]) return a[7];
        else if (a[8]!=0 && a[8]==a[17] && a[8]==a[26]) return a[8];
        else if (a[6]!=0 && a[6]==a[16] && a[6]==a[26]) return a[16];
        else if (a[8]!=0 && a[8]==a[16] && a[8]==a[24]) return a[16];
        //左(下1奥1手前1)
        else if (a[9]>0 && a[9]==a[12] && a[9]==a[15]) return a[9];
        else if (a[18]>0 && a[18]==a[21] && a[18]==a[24]) return a[18];
        else if (a[3]!=0 && a[3]==a[12] && a[3]==a[21]) return a[3];
        else if (a[0]!=0 && a[0]==a[12] && a[0]==a[24]) return a[12];
        else if (a[6]!=0 && a[6]==a[12] && a[6]==a[18]) return a[12];
        //右(下1奥1手前1)
        else if (a[11]>0 && a[11]==a[14] && a[11]==a[17]) return a[11];
        else if (a[20]>0 && a[20]==a[23] && a[20]==a[26]) return a[20];
        else if (a[5]!=0 && a[5]==a[14] && a[5]==a[23]) return a[5];
        else if (a[2]!=0 && a[2]==a[14] && a[2]==a[26]) return a[14];
        else if (a[8]!=0 && a[8]==a[14] && a[8]==a[20]) return a[14];
        //上(奥1手前1左1右1)
        else if (a[19]>0 && a[19]==a[22] && a[19]==a[25]) return a[19];
        else if (a[21]>0 && a[21]==a[22] && a[21]==a[23]) return a[21];
        else if (a[18]>0 && a[18]==a[22] && a[18]==a[26]) return a[22];
        else if (a[20]>0 && a[20]==a[22] && a[20]==a[24]) return a[22];

        else return 0;
    }
}
