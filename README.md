# Information

Sudoku is a number-placement puzzle.

The goal of this challenge is to write a sudoku solving algorithm.  

## Step 1, Solve sudoku

The application will send you 3 different puzzles with form of two-dimensional array.

Solve those puzzles through the "solve" function.

## Step 2, Explain your code
In [answer.md](./answer.md) write a brief explanation about how your code works and how you solved any problems which you've encountered.

## Notes
### About Python
- The test is run with `nosetests`.
- Python version is 2.x. (TestServer uses 2.7.6)

### Sudoku rules

Sudoku is a puzzle made out of 9x9 matrix. We also have 9 sub-grids which are made of 3x3 cells.
A valid sudoku contains the numbers 1-9 each 9 times while not breaking one simple rule: "A sub-grid, column or row can only contain each number once".

You can find more details in [Wikipedia](https://en.wikipedia.org/wiki/Sudoku).

### Sudoku solution

Some sudoku has multiple solutions, but all of puzzles we provide have a unique solution.

#### Puzzle 1

<table><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>9</td><td>8</td><td>&nbsp;</td><td>5</td><td>1</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>5</td><td>1</td><td>9</td><td>&nbsp;</td><td>7</td><td>4</td><td>2</td><td>&nbsp;</td></tr><tr><td>2</td><td>9</td><td>&nbsp;</td><td>4</td><td>&nbsp;</td><td>1</td><td>&nbsp;</td><td>6</td><td>5</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>1</td><td>4</td><td>&nbsp;</td><td>5</td><td>&nbsp;</td><td>8</td><td>&nbsp;</td><td>9</td><td>3</td></tr><tr><td>&nbsp;</td><td>2</td><td>6</td><td>7</td><td>&nbsp;</td><td>9</td><td>5</td><td>8</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>5</td><td>1</td><td>&nbsp;</td><td>3</td><td>6</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></table>

#### Puzzle 2

<table><tr><td>&nbsp;</td><td>&nbsp;</td><td>3</td><td>&nbsp;</td><td>2</td><td>&nbsp;</td><td>6</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>9</td><td>&nbsp;</td><td>&nbsp;</td><td>3</td><td>&nbsp;</td><td>5</td><td>&nbsp;</td><td>&nbsp;</td><td>1</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>1</td><td>8</td><td>&nbsp;</td><td>6</td><td>4</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>8</td><td>1</td><td>&nbsp;</td><td>2</td><td>9</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>7</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>8</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>6</td><td>7</td><td>&nbsp;</td><td>8</td><td>2</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>2</td><td>6</td><td>&nbsp;</td><td>9</td><td>5</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>8</td><td>&nbsp;</td><td>&nbsp;</td><td>2</td><td>&nbsp;</td><td>3</td><td>&nbsp;</td><td>&nbsp;</td><td>9</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>5</td><td>&nbsp;</td><td>1</td><td>&nbsp;</td><td>3</td><td>&nbsp;</td><td>&nbsp;</td></tr></table>

#### Puzzle 3

<table><tr><td>9</td><td>&nbsp;</td><td>4</td><td>2</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>7</td></tr><tr><td>&nbsp;</td><td>1</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>7</td><td>&nbsp;</td><td>6</td><td>5</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>8</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>9</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>2</td><td>&nbsp;</td><td>9</td><td>&nbsp;</td><td>4</td><td>&nbsp;</td><td>6</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>4</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>2</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>1</td><td>6</td><td>&nbsp;</td><td>7</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>3</td><td>&nbsp;</td></tr><tr><td>3</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>5</td><td>7</td><td>&nbsp;</td><td>2</td></tr></table>
