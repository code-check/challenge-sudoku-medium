import org.scalatest.{FlatSpec, Matchers}

class Tests extends FlatSpec with Matchers {
  val sudokus: Array[String] = Array(
    "003020600900305001001806400008102900700000008006708200002609500800203009005010300",
    "000000000009805100051907420290401065000000000140508093026709580005103600000000000",
    "904200007010000000000706500000800090020904060040002000001607000000000030300005702"
    // "234679815678512349519843276841325697357961482962487153423798561196254738785136924",
    // "437618529862359714591274836953462178214785693678931245129546387346827951785193462",
    // "467215938359487126821963475184326759976854213235791864742538691693142587518679342"
  )


  "Sudoku 1" should "validate" in {
    val input = parseSudoku(sudokus(0))
    val sudoku = Solver.solveSudoku(input)
    validateSudoku(sudoku) should ===(true)
    compare(input, sudoku) should ===(true)
  }

  "Sudoku 2" should "validate" in {
    val input = parseSudoku(sudokus(1))
    val sudoku = Solver.solveSudoku(input)
    validateSudoku(sudoku) should ===(true)
    compare(input, sudoku) should ===(true)
  }

  "Sudoku 3" should "validate" in {
    val input = parseSudoku(sudokus(2))
    val sudoku = Solver.solveSudoku(input)
    validateSudoku(sudoku) should ===(true)
    compare(input, sudoku) should ===(true)
  }

  def parseSudoku(sudoku: String) =
    sudoku
      .toCharArray
      .map(_.toByte - 0x30)
      .grouped(9)
      .toArray

  def validateSudoku(sudoku: Array[Array[Int]]): Boolean = {
    def extractRow(n: Int): Array[Int] = sudoku(n - 1)
    def extractCol(n: Int): Array[Int] = sudoku.map(v => v(n-1))
    def extractGrid(n: Int): Array[Int] = {
      val fromRow = (n - 1) / 3 * 3
      val fromCol = (n - 1) % 3 * 3

      sudoku.slice(fromRow, fromRow + 3).map(_.slice(fromCol, fromCol + 3)).flatten
    }
    def check(nums: Array[Int]): Boolean = {
      (1 to 9).forall(v => nums.filter(_ == v).size == 1)
    }
    val rows  = (1 to 9).map(extractRow)
    val cols  = (1 to 9).map(extractCol)
    val grids = (1 to 9).map(extractGrid)

    (rows ++ cols ++ grids).forall(check)
  }

  def compare(input: Array[Array[Int]], output: Array[Array[Int]]): Boolean = {
    val fInput = input.flatten
    val fOutput = output.flatten
    fInput.zip(fOutput).forall { case (a, b) =>
      a == 0 || a == b
    }
  }
}
