using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SudokuChallengeMedium.src
{
    public static class Solver
    {
        public static byte[,] Solve(byte[,] sudoku)
        {
            //BEGIN_CHALLENGE
            bool[, ,] possibilities = GeneratePossibilities(sudoku);
            SolveRecursive(sudoku, possibilities);
            //END_CHALLENGE
            return sudoku;
        }

        //BEGIN_CHALLENGE
        /// <summary>
        /// Checks if a certain value in allowed within a row
        /// </summary>
        /// <param name="sudoku">Current sudoku field</param>
        /// <param name="x">X position to check</param>
        /// <param name="y">Y position to check</param>
        /// <param name="val">Value to check</param>
        /// <returns>If <paramref name="val"/> is posible</returns>
        private static bool CheckRow(byte[,] sudoku, int x, int y, byte val)
        {
            for (int ix = 0; ix < 9; ix++)
            {
                if (x == ix) continue;
                if (sudoku[ix, y] == val) return false;
            }
            return true;
        }

        /// <summary>
        /// Checks if a certain value in allowed within a column
        /// </summary>
        /// <param name="sudoku">Current sudoku field</param>
        /// <param name="x">X position to check</param>
        /// <param name="y">Y position to check</param>
        /// <param name="val">Value to check</param>
        /// <returns>If <paramref name="val"/> is posible</returns>
        private static bool CheckColumn(byte[,] sudoku, int x, int y, byte val)
        {
            for (int iy = 0; iy < 9; iy++)
            {
                if (y == iy) continue;
                if (sudoku[x, iy] == val) return false;
            }
            return true;
        }

        /// <summary>
        /// Checks if a certain value in allowed within a cell
        /// </summary>
        /// <param name="sudoku">Current sudoku field</param>
        /// <param name="x">X position to check</param>
        /// <param name="y">Y position to check</param>
        /// <param name="val">Value to check</param>
        /// <returns>If <paramref name="val"/> is posible</returns>
        private static bool CheckCell(byte[,] sudoku, int x, int y, byte val)
        {
            int startx = x - (x % 3);
            int starty = y - (y % 3);

            for (int ix = startx; ix < startx + 3; ix++)
            {
                for (int iy = starty; iy < starty + 3; iy++)
                {
                    if (y == iy && x == ix) continue;
                    if (sudoku[ix, iy] == val) return false;
                }
            }
            return true;
        }

        public static bool SolveRecursive(byte[,] sudoku, bool[, ,] possibilities, int x = 0, int y = 0)
        {
            while (sudoku[x, y] != 0)
            {
                if (++y >= 9)
                {
                    y = 0;
                    if (++x >= 9)
                        return true;
                }
            }
            int ty, tx;

            for (byte val = 1; val <= 9; val++)
            {
                if (possibilities[x, y, val - 1])
                {
                    bool[, ,] clone = possibilities.Clone() as bool[, ,];
                    SetBlock(sudoku, possibilities, x, y, val);
                    ty = y;
                    tx = x;
                    if (++ty >= 9)
                    {
                        ty = 0;
                        if (++tx >= 9)
                            return true;
                    }

                    if (SolveRecursive(sudoku, possibilities, tx, ty))
                        return true;
                    else
                    {
                        possibilities = clone;
                        sudoku[x, y] = 0;
                    }
                }
            }

            if (--y < 0)
            {
                y = 8;
                x--;
            }
            return false;
        }

        public static void SetBlock(byte[,] sudoku, bool[, ,] possibilities, int x, int y, byte val)
        {
            sudoku[x, y] = val;

            // Rows
            for (int ix = 0; ix < 9; ix++)
                possibilities[ix, y, val - 1] = false;

            // Columns
            for (int iy = 0; iy < 9; iy++)
                possibilities[x, iy, val - 1] = false;

            // Cell
            int startx = x - (x % 3);
            int starty = y - (y % 3);
            for (int ix = startx; ix < startx + 3; ix++)
            {
                for (int iy = starty; iy < starty + 3; iy++)
                    possibilities[ix, iy, val - 1] = false;
            }
        }

        private static bool[, ,] GeneratePossibilities(byte[,] sudoku)
        {
            bool[, ,] ret = new bool[9, 9, 9];

            for (int x = 0; x < 9; x++)
                for (int y = 0; y < 9; y++)
                    for (byte val = 1; val <= 9; val++)
                    {
                        bool possible = true;
                        possible &= sudoku[x, y] == 0;
                        possible &= CheckRow(sudoku, x, y, val);
                        possible &= CheckColumn(sudoku, x, y, val);
                        possible &= CheckCell(sudoku, x, y, val);
                        ret[x, y, val - 1] = possible;
                    }

            return ret;
        }
        //END_CHALLENGE
    }
}
