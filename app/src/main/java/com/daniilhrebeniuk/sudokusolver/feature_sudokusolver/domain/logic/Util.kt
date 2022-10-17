package com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.domain.logic

import com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.domain.model.Sudoku


fun Int.toSquare() = Square(this)