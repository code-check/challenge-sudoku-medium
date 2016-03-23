## Sudoku 
Sudoku is a number-placement puzzle.
Solve the challenge by developing a sudoku solving algorithm.  

## Challenge Description
### Sudoku rules

Sudoku is a puzzle made out of 9x9 matrix. We also have 9 sub-grids which are made of 3x3 cells.
A valid sudoku contains the numbers 1-9 each 9 times while not breaking one simple rule: "A sub-grid, column or row can only contain each number once".

You can find more details in [Wikipedia](https://en.wikipedia.org/wiki/Sudoku).

### Sudoku solution

Some sudoku has multiple solutions, but all of puzzles we provide have a unique solution.

#### Utility functions

This challenge provides 3 functions to check if a certain move is valid for either a cell, column or row.

#### Puzzle 1

<table><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>9</td><td>8</td><td>&nbsp;</td><td>5</td><td>1</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>5</td><td>1</td><td>9</td><td>&nbsp;</td><td>7</td><td>4</td><td>2</td><td>&nbsp;</td></tr><tr><td>2</td><td>9</td><td>&nbsp;</td><td>4</td><td>&nbsp;</td><td>1</td><td>&nbsp;</td><td>6</td><td>5</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>1</td><td>4</td><td>&nbsp;</td><td>5</td><td>&nbsp;</td><td>8</td><td>&nbsp;</td><td>9</td><td>3</td></tr><tr><td>&nbsp;</td><td>2</td><td>6</td><td>7</td><td>&nbsp;</td><td>9</td><td>5</td><td>8</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>5</td><td>1</td><td>&nbsp;</td><td>3</td><td>6</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></table>

#### Puzzle 2

<table><tr><td>&nbsp;</td><td>&nbsp;</td><td>3</td><td>&nbsp;</td><td>2</td><td>&nbsp;</td><td>6</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>9</td><td>&nbsp;</td><td>&nbsp;</td><td>3</td><td>&nbsp;</td><td>5</td><td>&nbsp;</td><td>&nbsp;</td><td>1</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>1</td><td>8</td><td>&nbsp;</td><td>6</td><td>4</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>8</td><td>1</td><td>&nbsp;</td><td>2</td><td>9</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>7</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>8</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>6</td><td>7</td><td>&nbsp;</td><td>8</td><td>2</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>2</td><td>6</td><td>&nbsp;</td><td>9</td><td>5</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>8</td><td>&nbsp;</td><td>&nbsp;</td><td>2</td><td>&nbsp;</td><td>3</td><td>&nbsp;</td><td>&nbsp;</td><td>9</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>5</td><td>&nbsp;</td><td>1</td><td>&nbsp;</td><td>3</td><td>&nbsp;</td><td>&nbsp;</td></tr></table>

#### Puzzle 3

<table><tr><td>9</td><td>&nbsp;</td><td>4</td><td>2</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>7</td></tr><tr><td>&nbsp;</td><td>1</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>7</td><td>&nbsp;</td><td>6</td><td>5</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>8</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>9</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>2</td><td>&nbsp;</td><td>9</td><td>&nbsp;</td><td>4</td><td>&nbsp;</td><td>6</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>4</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>2</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>1</td><td>6</td><td>&nbsp;</td><td>7</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>3</td><td>&nbsp;</td></tr><tr><td>3</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>5</td><td>7</td><td>&nbsp;</td><td>2</td></tr></table>

### Solve sudoku

The application will send you 3 different puzzles in the form of two-dimensional array.

Solve those puzzles through the "solve" function.

### Test Results *before* solving the challenge  
- Initially all the tests will fail with following output
```
Write Test reults before solving challenge
```

### Test Results *after* solving the challenge
- Solve the challenge to pass the tests
```
Write Test reults after solving challenge
```

--- --- ---

## Run Tests
To run tests locally install `codecheck` by running the following command in terminal 
```
$ npm install codecheck -g
```
To run tests in web editor please click in `RUN` button on left side of web editor

## Explain your code
In [answer.md](answer.md) write a brief explanation 
- About how your code works
- Problems faced while solving the challenge
- How you solved those problems
- Improvements/Feedbacks are also welcomed