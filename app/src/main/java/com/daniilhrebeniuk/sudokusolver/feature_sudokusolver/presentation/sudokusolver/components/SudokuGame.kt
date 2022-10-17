package com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.presentation.sudokusolver.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.domain.logic.SudokuSolver
import com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.domain.model.Sudoku
import com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.presentation.sudokusolver.SudokuSolverViewModel

@Composable
fun SudokuGame(
    modifier: Modifier = Modifier,
    sudoku: Sudoku,
    selected: Pair<Int, Int>,
    onSquareClick: (Int, Int) -> Unit
) {
    Box(modifier = modifier) {
        Column {
            repeat(3) { columnIndex ->
                Row {
                    repeat(3) { rowIndex ->
                        SudokuBox(
                            Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                                .border(2.dp, Color.Black)
                                .background(Color.White),
                            boxPosition = rowIndex to columnIndex,
                            selected = selected,
                            sudoku = sudoku,
                            onSquareClick = onSquareClick
                        )
                    }
                }
            }
        }
    }
}