package palbp.demos.tds.isel.puzzle.domain

/**
 * Finds a solution for the given board. For simplicity, we will use Breadth-first search.
 * Alternatives are Depth-first and, most notably, the A* algorithm.
 * The implementation uses the A* algorithm.
 * @param board the board to solve.
 * @return a list of coordinates representing the sequence of moves to solve the board.
 * @return null if no solution is found.
 */
fun findSolution(board: Board): List<Board.Coordinate>? {

    if (board.isSolved()) return emptyList()

    val openSet = mutableListOf(GraphNode(board))
    val closedSet = mutableSetOf(board)

    while (openSet.isNotEmpty()) {
        val current = openSet.removeFirst()

        closedSet.add(current.board)

        if (current.board.isSolved()) {
            return current.buildPath()
        }

        val neighbors = current.findNeighbors()
        neighbors.forEach { neighbor ->
            if (neighbor.board !in closedSet) {
                openSet.add(neighbor)
            }
        }
    }

    return null
}

/**
 * Represents a node in the search graph.
 * @param board the board represented by this node.
 * @param move the move that led to this node.
 * @param parent the parent node of this node.
 */
data class GraphNode(val board: Board, val move: Board.Coordinate? = null, val parent: GraphNode? = null) {

    /**
     * Finds the neighbors of this node.
     * @return a list of neighbors of this node.
     */
    fun findNeighbors(): List<GraphNode> {
        val spaceAt = board.getEmptySpaceCoordinate()
        val spaceNeighbors = spaceAt.neighbors()
        return spaceNeighbors.map { GraphNode(board = board.movePieceAt(it), move = it, parent = this) }
    }

    /**
     * Builds the path from the initial state to the current state.
     * @return a list of coordinates representing the sequence of moves that led to this node of the search graph.
     */
    fun buildPath(): List<Board.Coordinate> = buildList {
        var current = this@GraphNode
        while (current.parent != null) {
            addFirst(current.move ?: error("Move is null"))
            current = current.parent
        }
    }
}
