# oxGame
平面三目並べと立体三目並べを遊べるAndroidアプリです。  
開発環境はAndroid Studio 3.1.2です。

## 概要
平面か立体か、対CPUモードか対人モードかを選んでプレイできます。  
対CPUモードでは難易度をVeryEasy, Easy, Normalの３種類から選べます。  
(VeryEasy：完全にランダム, Easy：勝敗条件に沿って選択, Normal：基本的な戦略に沿って選択)  
対戦中は盤面状況、手番、同じモードの同じ難易度で最初からやり直す「もう一度」ボタン、ホーム画面に戻る「ホーム」ボタンが表示されます。  
勝敗決着時は勝利者を手番の代わりに表示します。  
<img width="290" alt="2018-05-18 13 20 56" src="https://user-images.githubusercontent.com/38423640/40216884-b77d97a4-5aa4-11e8-996c-9d34036fd5df.png">
<img width="289" alt="2018-05-18 13 23 20" src="https://user-images.githubusercontent.com/38423640/40216903-c5553cec-5aa4-11e8-8482-a0adc482f4ba.png">

## ルール
### 平面三目並べ(2D)
通常の三目並べです。縦横斜めのどれか１列を自分の色で揃えることができたら勝利となります。

### 立体三目並べ(3D)
平面三目並べが３層積み重なっています。層の切り替えは画面横スクロールで行います。  
勝利条件に層をまたいだ縦横斜めが加わります。  
また、マスを選択するときの条件として以下の2項目が追加されます。  
1. 1層目以外は既に選択されているマスの１つ上のマスしか選択することができない
2. 2層目中央は1層目中央が選択された直後に勝敗に関係しないマスとして選択され、その後に3層目中央が開放される  
<img width="291" alt="2018-05-18 13 23 56" src="https://user-images.githubusercontent.com/38423640/40216906-cacd0ee8-5aa4-11e8-97ed-9ec7a089cbe9.png">
<img width="289" alt="2018-05-18 13 24 25" src="https://user-images.githubusercontent.com/38423640/40216911-cf3386d8-5aa4-11e8-8de5-4237c486f56e.png">
<img width="291" alt="2018-05-18 13 25 07" src="https://user-images.githubusercontent.com/38423640/40216913-d67c68ba-5aa4-11e8-88b7-4a865c00b5c5.png">
<img width="292" alt="2018-05-18 13 25 29" src="https://user-images.githubusercontent.com/38423640/40216916-decd6e24-5aa4-11e8-867a-5550815d11e0.png">
<img width="291" alt="2018-05-18 13 25 48" src="https://user-images.githubusercontent.com/38423640/40216928-e6b7eaba-5aa4-11e8-88db-c2c493b6dc4a.png">


## 今後の方針
難易度Hardを作成中です。
HardにおけるゲームAIにはミニマックス法やQ学習を用いる予定です。
