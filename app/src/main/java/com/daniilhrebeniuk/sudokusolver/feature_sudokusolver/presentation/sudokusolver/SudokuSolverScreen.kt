package com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.presentation.sudokusolver

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.presentation.sudokusolver.components.InputSystem
import com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.presentation.sudokusolver.components.SudokuGame


@Composable
fun SudokuSolverScreen(
    viewModel: SudokuSolverViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.background(Color.White)) {
        SudokuGame(
            modifier = Modifier.fillMaxWidth(),
            sudoku = viewModel.sudokuState.value,
            selected = viewModel.currentPositionState.value,
            onSquareClick = { row, column ->
                viewModel.onEvent(
                    SudokuSolverEvent.ChangeCurrentPosition(
                        row,
                        column
                    )
                )
            }
        )

        Spacer(modifier = Modifier.height(2.dp))

        InputSystem(modifier = Modifier.fillMaxSize(), viewModel = viewModel)
    }

}