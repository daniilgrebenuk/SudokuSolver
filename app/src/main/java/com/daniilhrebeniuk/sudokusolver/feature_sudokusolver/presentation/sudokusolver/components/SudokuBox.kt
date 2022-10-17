package com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.presentation.sudokusolver.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.domain.model.Sudoku

@Composable
fun SudokuBox(
    modifier: Modifier = Modifier,
    boxPosition: Pair<Int, Int>,
    selected: Pair<Int, Int>,
    sudoku: Sudoku,
    onSquareClick: (Int, Int) -> Unit
) {
    Box(modifier = modifier) {
        Column {
            repeat(3) { columnIndex ->
                Row {
                    repeat(3) { rowIndex ->
                        val squareRowIndex = boxPosition.first * 3 + rowIndex
                        val squareColumnIndex = boxPosition.second * 3 + columnIndex
                        val squarePosition = squareRowIndex to squareColumnIndex
                        val smallSquareColor = if (squarePosition == selected) Color.LightGray else Color.White
                        SudokuSmallSquare(
                            Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                                .border(1.dp, Color.Black)
                                .background(smallSquareColor),
                            squarePosition = squarePosition,
                            value = sudoku.getSquareValue(squareRowIndex, squareColumnIndex),
                            onSquareClick = onSquareClick
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PrvBox() {
    SudokuBox(
        boxPosition = 0 to 0,
        selected = 0 to 0,
        sudoku = Sudoku.createEmpty(),
        onSquareClick = { _, _ -> }
    )
}
