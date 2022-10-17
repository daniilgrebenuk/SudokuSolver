package com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.domain.model

data class Sudoku(
    val squares: List<MutableList<Int>>
) {
    companion object {
        fun createEmpty(): Sudoku {
            val outerList = ArrayList<MutableList<Int>>(9)
            repeat(9) {
                val innerList = ArrayList<Int>(9)
                repeat(9) {
                    innerList += 0
                }
                outerList += innerList
            }

            return Sudoku(outerList)
        }
    }

    fun getSquareValue(rowIndex: Int, columnIndex: Int): Int = squares[rowIndex][columnIndex]

    fun copy(): Sudoku {
        val outerList = ArrayList<MutableList<Int>>(9)
        repeat(9) { row ->
            val innerList = ArrayList<Int>(9)
            repeat(9) { column ->
                innerList += squares[row][column]
            }
            outerList += innerList
        }
        return Sudoku(outerList)
    }
}