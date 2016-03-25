package sudoku

func Solve(data [][]int) [][]int {
//BEGIN_CHALLENGE
	possibilities := GeneratePossibilities(data)
	SolveRecursive(data, possibilities, 0, 0)
//END_CHALLENGE
	return data
}

//BEGIN_CHALLENGE
func SolveRecursive(data [][]int, possibilities [][][]bool, x int, y int) bool {
	for data[x][y] != 0 {
		y++
		if y >= 9 {
			y = 0 
			x++
			if x >= 9 {
				return true
			}
		}
	}

	for val := 1; val <= 9; val++ {
		if possibilities[x][y][val - 1] {
			clone := CreateClone(possibilities)
			SetBlock(data, clone, x, y, val)

			tx := x
			ty := y + 1
			if ty >= 9 {
				ty = 0 
				tx++
				if tx >= 9 {
					return true
				}
			}

			if SolveRecursive(data, clone, tx, ty) {
				return true
			} else {
				data[x][y] = 0
			}
		}
	}

	y--
	if y < 0 {
		y = 8
		x--
	}

	return false
}

func CreateClone(possibilities [][][]bool) [][][]bool {
	ret := make([][][]bool, 9)
	for x := range ret {
		ret[x] = make([][]bool, 9)
		for y := range ret[x] {
			ret[x][y] = make([]bool, 9)
			for v := range ret[x][y] {
				ret[x][y][v] = possibilities[x][y][v]
			}
		}
	}
	return ret
}

func SetBlock(data [][]int, possibilities [][][]bool, x int, y int, val int) {
	data[x][y] = val

    // Rows
    for ix := 0; ix < 9; ix++ {
        possibilities[ix][y][val - 1] = false
	}

    // Columns
    for iy := 0; iy < 9; iy++ {
        possibilities[x][iy][val - 1] = false
	}

    // Cell
    sx := x - (x % 3);
    sy := y - (y % 3);
    for ix := sx; ix < sx + 3; ix++ {
        for iy := sy; iy < sy + 3; iy++ {
			possibilities[ix][iy][val - 1] = false
		}
    }
}

func GeneratePossibilities(data [][]int) [][][]bool {
	ret := make([][][]bool, 9)

	for x := range ret {
		ret[x] = make([][]bool, 9)
		for y := range ret[x] {
			ret[x][y] = make([]bool, 9)
			for val := 1; val <= 9; val++ {
				ret[x][y][val - 1] = 
					data[x][y] == 0 &&
					CheckRow(data, x, y, val) &&
					CheckColumn(data, x, y, val) && 
					CheckCell(data, x, y, val)
			}
		}
	}
	return ret
}

func CheckRow(data [][]int, x int, y int, val int) bool {
	for ix := 0; ix < 9; ix++ {
		if ix == x { 
			continue 
		}
		if data[ix][y] == val { 
			return false 
		}
	}
	return true
}

func CheckColumn(data [][]int, x int, y int, val int) bool {
	for iy := 0; iy < 9; iy++ {
		if iy == y { 
			continue 
		}
		if data[x][iy] == val {
			return false 
		}
	}
	return true
}

func CheckCell(data [][]int, x int, y int, val int) bool {
	sx := x - (x % 3)
	sy := y - (y % 3)

	for ix := sx; ix < sx + 3; ix++ {
		for iy := sy; iy < sy + 3; iy++ {
			if y == iy && x == ix { 
				continue 
			}
			if data[ix][iy] == val { 
				return false 
			}
		}
	}
	return true
}
//END_CHALLENGE
