#BEGIN_CHALLENGE
from copy import deepcopy
#END_CHALLENGE
def solve(sudoku):
    #BEGIN_CHALLENGE
    possibilities = generate_possibilities(sudoku)
    solve_recursive(sudoku, possibilities, 0, 0)
    #END_CHALLENGE
    return sudoku

#BEGIN_CHALLENGE
def solve_recursive(sudoku, possibilities, x, y):
    while sudoku[x][y] != 0:
        y += 1
        if y >= 9:
            y = 0
            x += 1
            if x >= 9: return True

    for val in range(1, 10):
        if possibilities[x][y][val - 1]:
            clone = deepcopy(possibilities)
            set_block(sudoku, clone, x, y, val)

            tx = x
            ty = y + 1
            if ty >= 9:
                ty = 0
                tx += 1
                if tx >= 9: return True
            if solve_recursive(sudoku, clone, tx, ty):
                return True
            else:
                sudoku[x][y] = 0
    return False

def generate_possibilities(sudoku):
    possibilities = [[[True for x in range(9)] for x in range(9)] for x in range(9)]
    for x in range(9):
        for y in range(9):
            for val in range(1, 10):
                possibilities[x][y][val - 1] = sudoku[x][y] == 0 \
                                               and check_row(sudoku, x, y, val) \
                                               and check_column(sudoku, x, y, val) \
                                               and check_cell(sudoku, x, y, val)
    return possibilities

def set_block(sudoku, possibilities, x, y, val):
    sudoku[x][y] = val
    # rows
    for ix in range(9):
        possibilities[ix][y][val - 1] = False
    # columns
    for iy in range(9):
        possibilities[x][iy][val - 1] = False
    # cells
    sx = x - (x % 3)
    sy = y - (y % 3)
    for ix in range(sx, sx + 3):
        for iy in range(sy, sy + 3):
            possibilities[ix][iy][val - 1] = False
    return sudoku, possibilities
def check_row(sudoku, x, y, val):
    for ix in range(9):
        if x == ix: continue
        if sudoku[ix][y] == val: return False
    return True

def check_column(sudoku, x, y, val):
    for iy in range(9):
        if y == iy: continue
        if sudoku[x][iy] == val: return False
    return True

def check_cell(sudoku, x, y, val):
    sx = x - (x % 3)
    sy = y - (y % 3)
    for ix in range(sx, sx + 3):
        for iy in range(sy, sy + 3):
            if y == iy and x == ix: continue
            if sudoku[ix][iy] == val: return False
    return True
#END_CHALLENGE
