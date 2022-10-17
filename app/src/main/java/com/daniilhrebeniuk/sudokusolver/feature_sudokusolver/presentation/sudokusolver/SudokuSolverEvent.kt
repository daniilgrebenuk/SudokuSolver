package com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.presentation.sudokusolver

sealed class SudokuSolverEvent {
    object Solve : SudokuSolverEvent()
    object Clear : SudokuSolverEvent()
    data class ChangeValue(val value: Int): SudokuSolverEvent()
    data class ChangeCurrentPosition(val rowIndex: Int, val columnIndex: Int): SudokuSolverEvent()
}