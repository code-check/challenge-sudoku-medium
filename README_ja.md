# 数独
これは数独問題を解くアルゴリズムを実装するチャレンジです。  

## 内容
数独とは 9x9 のマス目に数字を並べていくパズルの事を指します。

### 数独のルール
数独は 9x9 の行列からなる 81 のマス目を 1~9 の数字で埋めるパズルです。また盤面は 3x3 の行列からなる 9 つのグループに分けられます。  
数独のルールは非常にシンプルで、次の3つです。
- 同じ行に重複した数字は入らない
- 同じ列に重複した数字は入らない
- 同じグループに重複した数字は入らない

より詳しい内容については [Wikipedia](https://ja.wikipedia.org/wiki/%E6%95%B0%E7%8B%AC) 等を参照してください

## 問題
### ステップ1, 数独の問題を解く関数を実装してください

[testsudoku.py](./testsudoku.py) にテストコードが記載されています。
このテストでは 3 つのパズルを 2 次元配列のデータとして solve 関数に渡しています。

[sudoku.py](./sudoku.py)を編集して、こちらを全て通過する数独の問題を解く関数 "solve" を実装してください。  
処理を分けるために自分で関数を新しく作っても問題ございませんが、最終的に答えを返すのは solve 関数で行ってください。

#### 数独 1

<table><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>9</td><td>8</td><td>&nbsp;</td><td>5</td><td>1</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>5</td><td>1</td><td>9</td><td>&nbsp;</td><td>7</td><td>4</td><td>2</td><td>&nbsp;</td></tr><tr><td>2</td><td>9</td><td>&nbsp;</td><td>4</td><td>&nbsp;</td><td>1</td><td>&nbsp;</td><td>6</td><td>5</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>1</td><td>4</td><td>&nbsp;</td><td>5</td><td>&nbsp;</td><td>8</td><td>&nbsp;</td><td>9</td><td>3</td></tr><tr><td>&nbsp;</td><td>2</td><td>6</td><td>7</td><td>&nbsp;</td><td>9</td><td>5</td><td>8</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>5</td><td>1</td><td>&nbsp;</td><td>3</td><td>6</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></table>

#### 数独 2

<table><tr><td>&nbsp;</td><td>&nbsp;</td><td>3</td><td>&nbsp;</td><td>2</td><td>&nbsp;</td><td>6</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>9</td><td>&nbsp;</td><td>&nbsp;</td><td>3</td><td>&nbsp;</td><td>5</td><td>&nbsp;</td><td>&nbsp;</td><td>1</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>1</td><td>8</td><td>&nbsp;</td><td>6</td><td>4</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>8</td><td>1</td><td>&nbsp;</td><td>2</td><td>9</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>7</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>8</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>6</td><td>7</td><td>&nbsp;</td><td>8</td><td>2</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>2</td><td>6</td><td>&nbsp;</td><td>9</td><td>5</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>8</td><td>&nbsp;</td><td>&nbsp;</td><td>2</td><td>&nbsp;</td><td>3</td><td>&nbsp;</td><td>&nbsp;</td><td>9</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>5</td><td>&nbsp;</td><td>1</td><td>&nbsp;</td><td>3</td><td>&nbsp;</td><td>&nbsp;</td></tr></table>

#### 数独 3

<table><tr><td>9</td><td>&nbsp;</td><td>4</td><td>2</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>7</td></tr><tr><td>&nbsp;</td><td>1</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>7</td><td>&nbsp;</td><td>6</td><td>5</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>8</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>9</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>2</td><td>&nbsp;</td><td>9</td><td>&nbsp;</td><td>4</td><td>&nbsp;</td><td>6</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>4</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>2</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>1</td><td>6</td><td>&nbsp;</td><td>7</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>3</td><td>&nbsp;</td></tr><tr><td>3</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>5</td><td>7</td><td>&nbsp;</td><td>2</td></tr></table>


### ステップ2, あなたの書いたコードについて説明してください
[answer.md](./answer.md) というファイルを用意してあるので、その中に
- どのように実装したか
- どのような事に気をつけて実装したか、工夫した点は何か
- チャレンジに挑戦する中で起きた問題、難しかった箇所
- またそれをどのようにして対処したのか

等を書いてください。

## 期待するテストの実行結果
- テストの実行結果として以下の表示がされればクリアです。

```
codecheck: Finish with code 0
codecheck: tests  : 3
codecheck: success: 3
codecheck: failure: 0
```

---
## テストの実行方法
- テストはnosetestsで実行されます。
- 使用するPythonのバージョンは2系を使用してください。(テストサーバは2.7.6を使用しています。)

- codecheckでは、テストコードを実行して自分が正しく回答できているかどうかを確かめることができます
- Webエディタで受験している場合は、consoleにある”Run”ボタンをクリックしてください
- GitHubを活用したローカル受験では、以下の手順に従ってcodecheck CLIをインストールし、テストを実行してください

- クローンしたプロジェクトのroot folderに移動し、以下のコマンドでCLIをインストールします
```
$ npm install codecheck -g
```

- テストを実行するにはroot folderから `codecheck`を入力し、実行してください

