package com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.domain.logic

import com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.domain.model.Sudoku

class SudokuSolver {
    private val elements: List<SudokuElement>

    constructor(sudoku: Sudoku) : this(sudoku.squares)

    constructor(fields: List<List<Int>>) {
        this.elements = linesToSquareElement(
            fields.map { line ->
                line.map { it.toSquare() }
            }
        )
    }

    private constructor(sudokuSolver: SudokuSolver) {
        this.elements = linesToSquareElement(
            sudokuSolver.elements.subList(0, 9).map { it.copy().fields }
        )
    }

    @Suppress("ControlFlowWithEmptyBody")
    fun solve(): SudokuSolver? {
        while (iterate()) {
        }
        if (!verify()) {
            return null
        }
        if (isSolved()) {
            return this
        }

        return splitBySmallestSquarePossibleValuesAndFilterIncorrect()
    }

    fun toSudoku() =
        Sudoku(elements.map { it.fields.mapTo(ArrayList(9)) { field -> field.current } })

    private fun splitBySmallestSquarePossibleValuesAndFilterIncorrect(): SudokuSolver? {
        val (elementIndex, squareIndex) = findSmallest()
        val possibleValues = elements[elementIndex].fields[squareIndex].getCopyOfPossibleValues()

        for (possibleValue in possibleValues) {
            val sudoku = this.copy()
            sudoku.elements[elementIndex].fields[squareIndex].current = possibleValue
            val temp = sudoku.solve()
            if (temp != null)
                return temp
        }
        return null
    }


    private fun findSmallest(): Pair<Int, Int> {
        var smallestSize = 10
        var resultElementIndex = -1
        var resultSquareIndex = -1

        elements.subList(0, 9).forEachIndexed { index, sudokuElement ->
            val (smallestSizeOfSudokuElement, indexOfSquare) = sudokuElement.findSmallest()

            if (smallestSizeOfSudokuElement < smallestSize) {
                resultElementIndex = index
                resultSquareIndex = indexOfSquare
                smallestSize = smallestSizeOfSudokuElement
            }
        }

        return resultElementIndex to resultSquareIndex
    }

    private fun linesToSquareElement(squares: List<List<Square>>): List<SudokuElement> {
        val elements = ArrayList<SudokuElement>(27)
        squares.onEach {
            elements += SudokuElement(it)
        }.also { lists ->
            repeat(9) { index ->
                val tempList = ArrayList<Square>(9)
                lists.forEach {
                    tempList += it[index]
                }
                elements += SudokuElement(tempList)
            }
        }.also { lists ->
            repeat(3) { x ->
                repeat(3) { y ->
                    val tempList = ArrayList<Square>(9)
                    repeat(3) { index ->
                        tempList += lists[y * 3 + index][x * 3]
                        tempList += lists[y * 3 + index][x * 3 + 1]
                        tempList += lists[y * 3 + index][x * 3 + 2]
                    }
                    elements += SudokuElement(tempList)
                }
            }
        }
        return elements
    }


    private fun iterate(): Boolean {
        var isChanged = false
        elements.forEach { element ->
            isChanged = element.iterate() || isChanged
        }
        return isChanged
    }

    private fun isSolved() = elements.subList(0, 9).all { it.isSolved() }

    private fun verify() = elements.all { it.verify() }

    private fun copy() = SudokuSolver(this)

    override fun toString(): String {
        return """
            |horizontal ->
            |${elements.subList(0, 9).joinToString(separator = "\n|")}
        """.trimMargin().replace("0", "X")
    }
}