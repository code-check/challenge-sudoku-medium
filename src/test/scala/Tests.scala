import org.scalatest.{FlatSpec, Matchers}

class Tests extends FlatSpec with Matchers {
  val sudokus: Array[String] = Array(
    "003020600900305001001806400008102900700000008006708200002609500800203009005010300",
    "000000000009805100051907420290401065000000000140508093026709580005103600000000000",
    "904200007010000000000706500000800090020904060040002000001607000000000030300005702"
  )

  val sudoku1 = validateSudoku(Solver.solveSudoku(parseSudoku(sudokus(0))))
  val sudoku2 = validateSudoku(Solver.solveSudoku(parseSudoku(sudokus(1))))
  val sudoku3 = validateSudoku(Solver.solveSudoku(parseSudoku(sudokus(2))))

  "Sudoku 1" should "validate" in {
    sudoku1 should ===(true)
  }

  "Sudoku 2" should "validate" in {
    sudoku2 should ===(true)
  }

  "Sudoku 3" should "validate" in {
    sudoku3 should ===(true)
  }

  def parseSudoku(sudoku: String) =
    sudoku
      .toCharArray
      .map(_.toByte - 0x30)
      .grouped(9)
      .toArray

  def validateSudoku(sudoku: Array[Array[Int]]): Boolean = {
    def checkCells: Boolean =
      !(for {
        v <- 1 to 9
        c <- 0 until 9
      } yield {
          val y = c - (c % 3)
          val x = 3 * (c % 3)
          (for (ix <- 0 until 3; iy <- 0 until 3) yield (ix, iy))
            .map { case (ix, iy) => (ix + (x - (x % 3)), iy + (y - (y % 3))) }
            .count { case (ix, iy) => sudoku(ix)(iy) == v }
        }).exists(_ >= 2)

    // Check the columns
    def checkColumns: Boolean =
      !(for {
        v <- 1 to 9
        x <- 0 until 9
      } yield (0 until 9).count(sudoku(x)(_) == v)
        ).exists(_ >= 2)

    // Check the rows
    def checkRows: Boolean =
      !(for {
        v <- 1 to 9
        y <- 0 until 9
      } yield (0 until 9).count(sudoku(_)(y) == v)
        ).exists(_ >= 2)

    checkCells & checkColumns & checkRows
  }
}
