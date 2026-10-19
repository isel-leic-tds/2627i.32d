package palbp.demos.tds.isel.puzzle.domain

/**
 * Counts the number of inversions in the given list of integers.
 * An inversion is a pair of elements (a, b) such that ´a´ appears before ´b´, but a > b.
 * For more details on inversions in sliding puzzles, refer to:
 * https://en.wikipedia.org/wiki/15_puzzle#Solvability
 *
 * @receiver List of integers
 * @return The total number of inversions.
 */
internal fun List<Int>.countInversions(): Int {
    var inversions = 0
    for (i in indices) {
        for (j in i + 1 until size) {
            if (this[i] > this[j]) inversions++
        }
    }
    return inversions
}

/**
 * Swaps the first inversion in the list and returns a new list.
 * An inversion is a pair of elements (a, b) such that ´a´ appears before ´b´, but a > b.
 * @receiver List of integers
 * @return A new list with the first inversion swapped.
 */
internal fun List<Int>.swapInversion(): List<Int> {
    for (i in indices) {
        for (j in i + 1 until size) {
            if (this[i] > this[j]) {
                return swap(i, j)
            }
        }
    }
    return this
}

/**
 * Swaps two elements in the list and returns a new list.
 *
 * @param index1 The index of the first element.
 * @param index2 The index of the second element.
 * @return A new list with the elements at index1 and index2 swapped.
 */
internal fun <T> List<T>.swap(index1: Int, index2: Int): List<T> {
    val result = toMutableList()
    val tmp = result[index1]
    result[index1] = result[index2]
    result[index2] = tmp
    return result.toList()
}

/**
 * Checks if the list of integers is a solvable 8-puzzle candidate. For simplification, we presume that the empty space
 * is in the bottom-right corner. In such cases, the list must have an even number of inversions.
 *
 * @receiver List of integers
 * @return true if the list is solvable, false otherwise.
 */
internal fun List<Int>.isSolvable(): Boolean {
    return countInversions() % 2 == 0
}