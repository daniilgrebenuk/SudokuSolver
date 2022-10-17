package com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.presentation.sudokusolver.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.presentation.sudokusolver.SudokuSolverEvent
import com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.presentation.sudokusolver.SudokuSolverViewModel

@Composable
fun InputSystem(
    modifier: Modifier,
    viewModel: SudokuSolverViewModel
) {
    Box(contentAlignment = Alignment.BottomCenter, modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            val defaultTextModifier = Modifier
                .padding(10.dp)

            val textSize = 18.sp

            Row {
                for (i in 1..9) {
                    Text(
                        modifier = Modifier
                            .clickable { viewModel.onEvent(SudokuSolverEvent.ChangeValue(i)) }
                            .then(defaultTextModifier),
                        text = "$i",
                        fontSize = textSize
                    )
                }
                Text(
                    modifier = Modifier
                        .clickable {
                            viewModel.onEvent(SudokuSolverEvent.ChangeValue(0))
                        }
                        .then(defaultTextModifier),
                    text = "X",
                    fontSize = textSize
                )
            }
            Row {
                Text(
                    modifier = Modifier
                        .clickable {
                            viewModel.onEvent(SudokuSolverEvent.Clear)
                        }
                        .then(defaultTextModifier),
                    text = "Clear",
                    fontSize = textSize
                )
                Text(
                    modifier = Modifier
                        .clickable {
                            viewModel.onEvent(SudokuSolverEvent.Solve)
                        }
                        .then(defaultTextModifier),
                    text = "Solve",
                    fontSize = textSize
                )
            }

        }
    }
}