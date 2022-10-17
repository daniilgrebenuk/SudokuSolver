package com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.domain.use_case

import com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.domain.exception.ImpossibleSudokuException
import com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.domain.logic.SudokuSolver
import com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.domain.model.Sudoku

class SolveSudoku {

    @Throws(ImpossibleSudokuException::class)
    operator fun invoke(sudoku: Sudoku): Sudoku {
        return SudokuSolver(sudoku).solve()?.toSudoku() ?: throw ImpossibleSudokuException()
    }
}