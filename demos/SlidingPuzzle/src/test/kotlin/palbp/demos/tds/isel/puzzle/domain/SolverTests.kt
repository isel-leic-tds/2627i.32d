package palbp.demos.tds.isel.puzzle.domain

import kotlin.test.*

class SolverTests {

    @Test
    fun `findSolution should return the solution for a given puzzle`() {
        // Arrange
        val puzzle = Board(listOf(
            Board.Piece(1), Board.Piece(2), Board.Piece(3),
            Board.Piece(4), Board.Piece(6), Board.Piece(8),
            Board.Piece(7), Board.Piece(5), null
        ))

        // Act
        val solution = findSolution(board = puzzle)

        // Assert
        assertNotNull(solution)
        assertEquals(4, solution.size)
        assertEquals(Board.Coordinate(1, 2), solution[0])
        assertEquals(Board.Coordinate(1, 1), solution[1])
        assertEquals(Board.Coordinate(2, 1), solution[2])
        assertEquals(Board.Coordinate(2, 2), solution[3])
    }

    @Test
    fun `findSolution should return null for an unsolvable puzzle`() {
        // Arrange
        val unsolvablePuzzle = Board(listOf(
            Board.Piece(1), Board.Piece(2), Board.Piece(3),
            Board.Piece(4), Board.Piece(5), Board.Piece(6),
            Board.Piece(8), Board.Piece(7), null
        ))
        // Act
        val actual = findSolution(board = unsolvablePuzzle)

        // Assert
        assertNull(actual)
    }

    @Test
    fun `findSolution should return an empty list for a solved puzzle`() {
        // Arrange
        val solvedPuzzle = Board()

        // Act
        val solution = findSolution(board = solvedPuzzle)

        // Assert
        assertNotNull(solution)
        assertTrue(solution.isEmpty() )
    }

    @Test
    fun `findNeighbors should return the neighbors of a given graph node`() {
        // Arrange
        val puzzle = Board()
        val rootNode = GraphNode(puzzle)
        val expectedNeighbors = listOf(Board.Piece(6), Board.Piece(8))
            .map {
                GraphNode(
                    board = puzzle.move(it),
                    move = puzzle.getCoordinate(it),
                    parent = rootNode
                )
            }

        // Act
        val actualNeighbors = rootNode.findNeighbors()

        // Assert
        expectedNeighbors.forEach {
            assertTrue {
                actualNeighbors.contains(it)
            }
        }
        assertEquals(actualNeighbors.size, expectedNeighbors.size)
    }
}