using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SudokuChallengeMedium.src
{
    [TestFixture]
    public class Tests
    {
        private string Sudokus = "000000000009805100051907420290401065000000000140508093026709580005103600000000000;003020600900305001001806400008102900700000008006708200002609500800203009005010300;904200007010000000000706500000800090020904060040002000001607000000000030300005702";
        
        [Test]
        public void SolveSudokus()
        {
            Assert.AreEqual(3, Sudokus
                .Split(';')
                .Select(x => ParseSudoku(x))
                .Select(x => WriteSudoku(x))
                .Select(x => Solver.Solve(x))
                .Select(x => WriteSudoku(x))
                .Count(x => IsValid(x)),
                "One or more solutions seem to be invalid");
        }

        private byte[,] WriteSudoku(byte[,] sudoku)
        {
            for (int x = 0; x < 9; x++)
            {
                for (int y = 0; y < 9; y++)
                {
                    Console.Write(sudoku[x, y]);
                }
                Console.Write('\n');
            }
            Console.Write('\n');
            return sudoku;
        }

        private byte[,] ParseSudoku(string sudoku)
        {
            var ret = new byte[9, 9];
            for (int x = 0; x < 9; x++)
                for (int y = 0; y < 9; y++)
                    ret[y, x] = (byte)(sudoku[x + (y * 9)] - 0x30);

            return ret;
        }

        private bool IsValid(byte[,] sudoku)
        {
            // Check the cells
            for (int val = 1; val <= 9; val++)
            {
                for (int cell = 0; cell < 9; cell++)
                {
                    int count = 0;
                    int startx = cell % 3;
                    int starty = cell - (cell % 3);
                    startx *= 3;

                    for (int x = 0; x < 3; x++)
                        for (int y = 0; y < 3; y++)
                            if (sudoku[x + startx, y + starty] == val)
                                if (count++ > 0)
                                    Assert.Fail("A cell contained the same number more than once");
                }
            }

            // Check the rows
            for (int val = 1; val <= 9; val++)
            {
                for (int y = 0; y < 9; y++)
                {
                    int count = 0;
                    for (int x = 0; x < 9; x++)
                    {
                        if (sudoku[x, y] == val)
                            if (count++ > 0)
                                Assert.Fail("A row contained the same number more than once");
                    }
                }
            }

            // Check the columns
            for (int val = 1; val <= 9; val++)
            {
                for (int x = 0; x < 9; x++)
                {
                    int count = 0;
                    for (int y = 0; y < 9; y++)
                    {
                        if (sudoku[x, y] == val)
                            if (count++ > 0)
                                Assert.Fail("A column contained the same number more than once");
                    }
                }
            }


            // Check the total sum
            const int sudokusum = 9 * ((9 * (9 + 1)) / 2);

            if (sudokusum != sudoku.Cast<byte>().Sum(x => x))
                Assert.Fail("The total sum of the sudoku appears to be incorrect [{0}]", sudoku.Cast<byte>().Sum(x => x));

            return true;
        }
    }
}
