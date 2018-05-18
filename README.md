# oxGame
平面三目並べと立体三目並べを遊べるAndroidアプリです。  
開発環境はAndroid Studio 3.1.2です。

## 概要
平面か立体か、対CPUモードか対人モードかを選んでプレイできます。  
対CPUモードでは難易度をVeryEasy, Easy, Normalの３種類から選べます。  
対戦中は盤面状況、手番、同じモードの同じ難易度で最初からやり直す「もう一度」ボタン、ホーム画面に戻る「ホーム」ボタンが表示されます。  
勝敗決着時は勝利者を手番の代わりに表示します。

## ルール
### 平面三目並べ(2D)
通常の三目並べです。縦横斜めのどれか１列を自分の色で揃えることができたら勝利となります。

### 立体三目並べ(3D)
平面三目並べが３層積み重なっています。層の切り替えは画面横スクロールで行います。  
勝利条件に層をまたいだ縦横斜めが加わります。  
また、マスを選択するときの条件として以下の2項目が追加されます。  
1. 1層目以外は既に選択されているマスの１つ上のマスしか選択することができない
2. 2層目中央は1層目中央が選択された直後に勝敗に関係しないマスとして選択され、その後に3層目中央が開放される

## 今後の方針
難易度Hardを作成中です。
HardにおけるゲームAIにはミニマックス法やQ学習を用いる予定です。