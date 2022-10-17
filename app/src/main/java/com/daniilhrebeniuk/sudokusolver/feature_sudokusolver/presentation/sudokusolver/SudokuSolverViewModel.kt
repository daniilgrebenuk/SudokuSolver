package com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.presentation.sudokusolver

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.domain.model.Sudoku
import com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.domain.use_case.SudokuSolverUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Math.random
import javax.inject.Inject

@HiltViewModel
class SudokuSolverViewModel @Inject constructor(
    private val sudokuSolverUseCases: SudokuSolverUseCases
) : ViewModel() {

    private val _sudokuState = mutableStateOf(Sudoku.createEmpty())
    val sudokuState: State<Sudoku> = _sudokuState

    private val _currentPositionState = mutableStateOf(-1 to -1)
    val currentPositionState: State<Pair<Int, Int>> = _currentPositionState

    private var sudokuSolverJob: Job? = null

    fun onEvent(event: SudokuSolverEvent) {
        when (event) {
            is SudokuSolverEvent.ChangeValue -> {
                _sudokuState.value = sudokuState.value.copy().apply {
                    this.squares[currentPositionState.value.first][currentPositionState.value.second] =
                        event.value
                }
            }
            is SudokuSolverEvent.Clear -> {
                _sudokuState.value = Sudoku.createEmpty()
            }
            is SudokuSolverEvent.Solve -> {
                sudokuSolverJob?.cancel()
                sudokuSolverJob = viewModelScope.launch {
                    _sudokuState.value = sudokuSolverUseCases.solveSudoku(_sudokuState.value)
                }
            }
            is SudokuSolverEvent.ChangeCurrentPosition -> {
                _currentPositionState.value = event.rowIndex to event.columnIndex
            }
        }
    }
}