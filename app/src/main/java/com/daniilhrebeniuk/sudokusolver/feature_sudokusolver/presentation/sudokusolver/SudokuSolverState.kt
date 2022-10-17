package com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.presentation.sudokusolver

import com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.domain.model.Sudoku

data class SudokuSolverState(
    val currentPosition: Pair<Int, Int> = -1 to -1,
    val sudoku: Sudoku = Sudoku.createEmpty()
)