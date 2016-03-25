package sudoku

import "testing"

func TestSolve1(t *testing.T) {
	input := ParseSudoku("000000000009805100051907420290401065000000000140508093026709580005103600000000000")
	output := Solve(input)
	
	if !IsValid(output) {
		t.Error("Solution for Puzzle is not valid")
	}
	if !IsSamePuzzle(input, output) {
		t.Error("Solution for Puzzle is not solved from input")
	}
}

func TestSolve2(t *testing.T) {
	input := ParseSudoku("003020600900305001001806400008102900700000008006708200002609500800203009005010300")
	output := Solve(input)
	
	if !IsValid(output) {
		t.Error("Solution for Puzzle is not valid")
	}
	if !IsSamePuzzle(input, output) {
		t.Error("Solution for Puzzle is not solved from input")
	}
}

func TestSolve3(t *testing.T) {
	input := ParseSudoku("904200007010000000000706500000800090020904060040002000001607000000000030300005702")
	output := Solve(input)
	
	if !IsValid(output) {
		t.Error("Solution for Puzzle is not valid")
	}
	if !IsSamePuzzle(input, output) {
		t.Error("Solution for Puzzle is not solved from input")
	}
}

func ParseSudoku(sudoku string) [][]int {
	data := make([][]int, 9)
	for x := range data {
		data[x] = make([]int, 9)
		for y := range data[x] {
			data[x][y] = int(sudoku[x * 9 + y] - 0x30)
		}
	}
	return data
}

func IsValid(sudoku [][]int) bool {
	// Create array and compute field sum
	sum := 0
	for x := range sudoku {
		for y := range sudoku[x] {
			sum += sudoku[x][y]
		}
	}

	// Check field sum
	if sum != 405 {
		return false
	}

	// Check cells
	for val := 1; val <= 9; val++ {
		for cell := 0; cell < 9; cell++ {
			count := 0
			sx := cell % 3
			sy := cell - sx
			sx *= 3

			for x := 0; x < 3; x++ {
				for y := 0; y < 3; y++ {
					if sudoku[x + sx][y + sy] == val {
						count++
						if count > 1 {
							return false
						}
					}
				}
			}
		}
	}

	// Check rows
	for val := 1; val <= 9; val++ {
		for y := 0; y < 9; y++ {
			count := 0
			for x := 0; x < 9; x++ {
				if sudoku[x][y] == val {
					count++
					if count > 1 {
						return false
					}
				}
			}
		}
	}

	// Check columns
	for val := 1; val <= 9; val++ {
		for x := 0; x < 9; x++ {
			count := 0
			for y := 0; y < 9; y++ {
				if sudoku[x][y] == val {
					count++
					if count > 1 {
						return false
					}
				}
			}
		}
	}
	return true
}

func IsSamePuzzle(input, output [][]int) bool {
	for y:=0; y<9; y++ {
		for x:=0; x<9; x++ {
			if (input[y][x] != 0 && input[y][x] != output[y][x]) {
				return false
			}
		}
	}
	return true
}
