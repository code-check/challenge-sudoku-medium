from nose.tools import assert_equal
from sudoku import solve

def test_solve_1():
    input = parse_sudoku("000000000009805100051907420290401065000000000140508093026709580005103600000000000")
    output = solve(input)
    assert_equal(True, is_valid(output))
    assert_equal(True, compare(input, output))

def test_solve_2():
    input = parse_sudoku("003020600900305001001806400008102900700000008006708200002609500800203009005010300")
    output = solve(input)
    assert_equal(True, is_valid(output))
    assert_equal(True, compare(input, output))

def test_solve_3():
    input = parse_sudoku("904200007010000000000706500000800090020904060040002000001607000000000030300005702")
    output = solve(input)
    assert_equal(True, is_valid(output))
    assert_equal(True, compare(input, output))

def parse_sudoku(data):
    chars = list(data)
    data = [[0 for x in range(9)] for x in range(9)]
    for x in range(9):
        for y in range(9):
            data[x][y] = ord(chars[x + (y * 9)]) - 0x30
    return data

def is_valid(data):
    sum = 0
    for x in range(9):
        for y in range(9):
            sum += data[x][y]
    # check sum
    if sum != 405:
        return False

    # check cells
    for val in range(1, 10):
        for cell in range(9):
            count = 0
            sx = cell % 3
            sy = cell - sx
            sx *= 3

            for x in range(3):
                for y in range(3):
                    if data[x + sx][y + sy] == val:
                        count += 1
                        if count > 1:
                            return False

    # check columns
    for val in range(1, 10):
        for x in range(9):
            count = 0
            for y in range(9):
                if data[x][y] == val:
                    count += 1
                    if count > 1:
                        return False

    # check rows
    for val in range(1, 10):
        for y in range(9):
            count = 0
            for x in range(9):
                if data[x][y] == val:
                    count += 1
                    if count > 1:
                        return False
    return True

def compare(input, output):
    return all([all([input[y][x] == 0 or input[y][x] == output[y][x] for x in range(9)]) for y in range(9)])