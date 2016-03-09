# 内容
これは数独問題を解くアルゴリズムを実装するチャレンジです。

数独とは 9x9 のマス目に数字を並べていくパズルの事を指します。

## Step 1, Solve sudoku

テストでは 3 つのパズルを 2 次元配列のデータとして solve 関数に渡します。

数独の問題を解く関数 "solve" を実装してください。  
処理を分けるために自分で関数を新しく作っても構いませんが、最終的に答えを返すのは solve 関数で行ってください。

## Step 2, Explain your code
[answer.md](./answer.md) というファイルを用意してあるので、その中で
- 書いたコードの振る舞い
- どのような事に気をつけて書いたか
- チャレンジに挑戦する中で起きた問題をどう解決 / 対処したのか
等を書いてください。


#### 数独のルール
数独は 9x9 の行列からなる 81 のマス目を 1~9 の数字で埋めるパズルです。また盤面は 3x3 の行列からなる 9 つのグループに分けられます。  
数独のルールは非常にシンプルで、次の3つのみです。
- 同じ行に重複した数字は入らない
- 同じ列に重複した数字は入らない
- 同じグループに重複した数字は入らない

より詳しい内容については [Wikipedia](https://ja.wikipedia.org/wiki/%E6%95%B0%E7%8B%AC) 等を参照してください
#### インフォメーション

問題のすべてに独特な解法があります。

#### 条件

セル、縦列や横列それぞれにとって適切な移動であるかどうかをチェックする3つの機能を作成してください。

#### 問題 1

<table><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>9</td><td>8</td><td>&nbsp;</td><td>5</td><td>1</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>5</td><td>1</td><td>9</td><td>&nbsp;</td><td>7</td><td>4</td><td>2</td><td>&nbsp;</td></tr><tr><td>2</td><td>9</td><td>&nbsp;</td><td>4</td><td>&nbsp;</td><td>1</td><td>&nbsp;</td><td>6</td><td>5</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>1</td><td>4</td><td>&nbsp;</td><td>5</td><td>&nbsp;</td><td>8</td><td>&nbsp;</td><td>9</td><td>3</td></tr><tr><td>&nbsp;</td><td>2</td><td>6</td><td>7</td><td>&nbsp;</td><td>9</td><td>5</td><td>8</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>5</td><td>1</td><td>&nbsp;</td><td>3</td><td>6</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></table>

#### 問題 2

<table><tr><td>&nbsp;</td><td>&nbsp;</td><td>3</td><td>&nbsp;</td><td>2</td><td>&nbsp;</td><td>6</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>9</td><td>&nbsp;</td><td>&nbsp;</td><td>3</td><td>&nbsp;</td><td>5</td><td>&nbsp;</td><td>&nbsp;</td><td>1</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>1</td><td>8</td><td>&nbsp;</td><td>6</td><td>4</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>8</td><td>1</td><td>&nbsp;</td><td>2</td><td>9</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>7</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>8</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>6</td><td>7</td><td>&nbsp;</td><td>8</td><td>2</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>2</td><td>6</td><td>&nbsp;</td><td>9</td><td>5</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>8</td><td>&nbsp;</td><td>&nbsp;</td><td>2</td><td>&nbsp;</td><td>3</td><td>&nbsp;</td><td>&nbsp;</td><td>9</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>5</td><td>&nbsp;</td><td>1</td><td>&nbsp;</td><td>3</td><td>&nbsp;</td><td>&nbsp;</td></tr></table>

#### 問題 3

<table><tr><td>9</td><td>&nbsp;</td><td>4</td><td>2</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>7</td></tr><tr><td>&nbsp;</td><td>1</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>7</td><td>&nbsp;</td><td>6</td><td>5</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>8</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>9</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>2</td><td>&nbsp;</td><td>9</td><td>&nbsp;</td><td>4</td><td>&nbsp;</td><td>6</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>4</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>2</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>1</td><td>6</td><td>&nbsp;</td><td>7</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>3</td><td>&nbsp;</td></tr><tr><td>3</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>5</td><td>7</td><td>&nbsp;</td><td>2</td></tr></table>
