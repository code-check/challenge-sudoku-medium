object Solver {
  def solveSudoku(sudoku: Array[Array[Int]]):  Array[Array[Int]] = {
    //BEGIN_CHALLENGE
    solveRecursive(sudoku, generatePossibilities(sudoku))
    //END_CHALLENGE
    sudoku
  }

  //BEGIN_CHALLENGE
  def solveRecursive(sudoku: Array[Array[Int]], possibilities: Array[Array[Array[Boolean]]], x: Int = 0, y: Int = 0): Boolean = {
    var ix = x
    var iy = y
    while(sudoku(ix)(iy) != 0) {
      iy += 1
      if (iy >= 9) {
        iy = 0
        ix += 1
        if (ix >= 9)
          return true
      }
    }

    for (v <- 1 to 9) {
      if (possibilities(ix)(iy)(v - 1)) {
        val clone = possibilities.clone()

        var tx = ix
        var ty = iy + 1
        if (ty >= 9)
        {
          ty = 0
          tx += 1
          if (tx >= 9)
            return true
        }

        if (solveRecursive(sudoku, possibilities, tx, ty))
          return true
        else {
          sudoku(ix)(iy) = 0
          clone.copyToArray(possibilities)
        }
      }
    }
    iy -= 1
    if (iy < 0)
    {
      iy = 0
      ix -= 1
    }
    false
  }

  def setBlock(sudoku: Array[Array[Int]], possibilities: Array[Array[Array[Boolean]]], x: Int, y: Int, v: Int) = {
    sudoku(x)(y) = v

    (0 until 9).foreach(possibilities(_)(y)(v - 1) = false)
    (0 until 9).foreach(possibilities(x)(_)(v - 1) = false)

    val startx = x - (x % 3)
    val starty = y - (y % 3)
    for (x <- 0 until 3; y <- 0 until 3)
      possibilities(x + startx)(y + starty)(v - 1) = false
  }

  def generatePossibilities(sudoku: Array[Array[Int]]): Array[Array[Array[Boolean]]] =
    (for (x <- 0 until 9) yield {
      for (y <- 0 until 9) yield {
        for (v <- 1 to 9) yield {
          val t1 = checkColumn(sudoku, x, y, v)
          val t2 = checkRow(sudoku, x, y, v)
          val t3 = checkCell(sudoku, x, y, v)
          val ret = sudoku(x)(y) == 0 &&
            checkRow(sudoku, x, y, v) &&
            checkColumn(sudoku, x, y, v) &&
            checkCell(sudoku, x, y, v)
          ret
        }
      }
    }).map(_.map(_.toArray).toArray).toArray
  //END_CHALLENGE

  /**
   * Checks if a certain value is allowed within a row
   * @param sudoku Current sudoku field
   * @param x X position to check
   * @param y Y position to check
   * @param v value to check
   * @return true if move is possible
   */
  def checkRow(sudoku: Array[Array[Int]], x: Int, y: Int, v: Int): Boolean =
    !(0 until 9).filter(_ != x).exists(sudoku(_)(y) == v)

  /**
   * Checks if a certain value is allowed within a column
   * @param sudoku Current sudoku field
   * @param x X position to check
   * @param y Y position to check
   * @param v value to check
   * @return true if move is possible
   */
  def checkColumn(sudoku: Array[Array[Int]], x: Int, y: Int, v: Int): Boolean =
    !(0 until 9).filter(_ != y).exists(sudoku(x)(_) == v)

  /**
   * Checks if a certain value is allowed within a cell
   * @param sudoku Current sudoku field
   * @param x X position to check
   * @param y Y position to check
   * @param v value to check
   * @return true if move is possible
   */
  def checkCell(sudoku: Array[Array[Int]], x: Int, y: Int, v: Int): Boolean =
    !(for(ix <- 0 until 3; iy <- 0 until 3) yield (ix, iy))
      .map { case (ix, iy) => (ix + (x - (x % 3)), iy + (y - (y % 3))) }
      .filter { case (ix, iy) => !(ix == x && iy == y) }
      .exists { case (ix, iy) => sudoku(ix)(iy) == v }
}
