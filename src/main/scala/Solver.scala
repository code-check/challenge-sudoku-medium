object Solver {
  def solveSudoku(sudoku: Array[Array[Int]]):  Array[Array[Int]] = {
    sudoku
  }
}

// BEGIN_CHALLENGE
case class Sudoku(sudoku: Array[Array[Int]]) {

  def extractRow(n: Int): Array[Int] = sudoku(n - 1)
  def extractCol(n: Int): Array[Int] = sudoku.map(v => v(n-1))
  def extractGrid(n: Int): Array[Int] = {
    val fromRow = (n - 1) / 3 * 3
    val fromCol = (n - 1) % 3 * 3

    extractGrid(fromRow - 1, fromCol - 1)
  }

  def extractGrid(x: Int, y: Int): Array[Int] = {
    val fromRow = (y - 1) / 3 * 3
    val fromCol = (x - 1) / 3 * 3
    sudoku.slice(fromRow, fromRow + 3).map(_.slice(fromCol, fromCol + 3)).flatten
  }

  def check(nums: Array[Int]): Boolean = {
    (1 to 9).forall(v => nums.filter(_ == v).size == 1)
  }

  def duplicate(nums: Array[Int]): Boolean = {
    (1 to 9).exists(v => nums.filter(_ == v).size > 1)
  }

  def isSolved: Boolean = {
    val rows  = (1 to 9).map(extractRow)
    val cols  = (1 to 9).map(extractCol)
    val grids = (1 to 9).map(extractGrid)

    (rows ++ cols ++ grids).forall(check)
  }

  def isValid: Boolean = {
    val hasCandidate = (for {
      y <- 1 to 9
      x <- 1 to 9
    } yield {
      calcCell(x, y)
    }).forall(_.isValid)

    val rows  = (1 to 9).map(extractRow)
    val cols  = (1 to 9).map(extractCol)
    val grids = (1 to 9).map(extractGrid)

    val hasDuplicate = (rows ++ cols ++ grids).exists(duplicate)
    hasCandidate && !hasDuplicate
  }

  def isInvalid: Boolean = !isValid

  def getValue(x: Int, y: Int): Int = sudoku(y - 1)(x - 1)

  def isAllowed(x: Int, y: Int, v: Int): Boolean = {
    !extractRow(y).contains(v) &&
    !extractCol(x).contains(v) &&
    !extractGrid(x, y).contains(v)
  }

  def calcCell(x: Int, y: Int): Cell = {
    val v = getValue(x, y)
    if (v != 0) {
      Cell(x, y, Array(v))
    } else {
      val ret = Cell(x, y, (1 to 9).filter(v => isAllowed(x, y, v)).toArray)
      ret
    }
  }

  def clone(x: Int, y: Int, v: Int): Sudoku = {
    val nums = sudoku.zipWithIndex.map { case (row, idx) =>
      if (idx == y - 1) {
        row.zipWithIndex.map { case (n, idx) =>
          if (idx == x - 1) {
            v
          } else {
            n
          }
        }
      } else {
        row
      }
    }
    Sudoku(nums)
  }

  def calcNext: List[Sudoku] = {
    if (isSolved) {
      List(this)
    } else if (isInvalid) {
      Nil
    } else {
      val cells = (for {
        y <- 1 to 9
        x <- 1 to 9
      } yield {
        calcCell(x, y)
      })
      val nums = cells.map(_.toInt).toArray.grouped(9).toArray
      if (nums2str(nums) != nums2str(sudoku)) {
        Sudoku(nums).calcNext
      } else {
        val cell = cells.filter(_.values.length > 1).sortBy(_.values.length).head
        cell.values.map(v => clone(cell.x, cell.y, v)).map(_.calcNext).flatten.toList
      }
    }
  }

  def nums2str(nums: Array[Array[Int]]): String = {
    nums.flatten.mkString("")
  }

  def solve: Array[Array[Int]] = {
    calcNext match {
      case x :: Nil => x.sudoku
      case any => throw new Exception("No answer")
    }
  }

}

case class Cell(x: Int, y: Int, values: Array[Int]) {
  def toInt = if (values.length == 1) values(0) else 0

  def isValid = values.size > 0

  override def toString = s"($x, $y) = [${values.mkString(",")}]"
}
//END_CHALLENGE
