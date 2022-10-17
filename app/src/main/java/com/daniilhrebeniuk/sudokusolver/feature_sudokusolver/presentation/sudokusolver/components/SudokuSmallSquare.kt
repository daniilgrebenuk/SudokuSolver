package com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.presentation.sudokusolver.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.domain.model.Sudoku

@Composable
fun SudokuSmallSquare(
    modifier: Modifier = Modifier,
    squarePosition: Pair<Int, Int>,
    value: Int,
    onSquareClick: (Int, Int) -> Unit
) {
    Box(modifier = modifier.clickable { onSquareClick(squarePosition.first, squarePosition.second) }, contentAlignment = Alignment.Center) {
        Text(
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            text = if (value == 0) "" else "$value"
        )
    }
}