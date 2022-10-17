package com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.domain.logic

class SudokuElement(val fields: List<Square>) {

    fun iterate(): Boolean {
        var isChanged = false
        fields.forEach { square ->
            if (square.current != 0) {
                fields.forEach {
                    isChanged = it.removePossibleValue(square) || isChanged
                }
            }
        }
        return isChanged
    }

    fun isSolved() = fields.all { it.current != 0 }

    fun verify() = fields.map { it.current }.filter { it != 0 }.let { it == it.distinct() }

    fun findSmallest(): Pair<Int, Int> {
        var smallestSize = 10
        var indexOfSmallestSize = -1

        fields.forEachIndexed { index, field ->
            val tempSize = field.amountOfPossibleValues()
            if (tempSize in 1 until smallestSize) {
                smallestSize = tempSize
                indexOfSmallestSize = index
            }
        }
        return smallestSize to indexOfSmallestSize
    }

    fun copy() = SudokuElement(fields.map { it.copy() })

    fun getAnswerForEuler() = "${fields[0].current}${fields[1].current}${fields[2].current}".toInt()

    override fun toString() = "$fields"
}