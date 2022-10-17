package com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.domain.logic

class Square(current: Int, possibleValues: MutableSet<Int>? = null) {

    var current = current
        set(value) {
            field = value
            possibleValues.clear()
        }

    private val possibleValues: MutableSet<Int>

    init {
        this.possibleValues = possibleValues?.toMutableSet()
            ?: if (current == 0) {
                (1..9).toMutableSet()
            } else {
                mutableSetOf()
            }
    }

    fun removePossibleValue(square: Square): Boolean {
        if (current != 0) {
            return false
        }

        possibleValues.remove(square.current)
        if (possibleValues.size == 1) {
            current = possibleValues.first()
            return true
        }
        return false
    }

    fun getCopyOfPossibleValues() = possibleValues.toList()

    fun copy() = Square(current, possibleValues)

    fun amountOfPossibleValues() = possibleValues.size

    override fun toString(): String = "$current"
}