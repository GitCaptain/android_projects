package game

class Location(private val width: Int = 4, private val height: Int = 4) {

    private val map = Array(height) { Array(width) { '.' } }
    private val edge = '\n' + "-".repeat(width + 4) + '\n'
    private var currentPos = 0 to 0


    init {
        setLocation(currentPos)
    }

    private fun setLocation(to: Pair<Int, Int>) {
        map[to.first][to.second] = '*'
    }

    private fun clearLocation(to: Pair<Int, Int>) {
        map[to.first][to.second] = '.'
    }

    fun getLocation(): Pair<Int, Int> {
        return currentPos
    }

    fun updateLocation(to: Pair<Int, Int>) {
        val newPos = currentPos.first + to.first to currentPos.second + to.second
        if (newPos.first < 0 || newPos.first >= height ||
            newPos.second < 0 || newPos.second >= width )
                    throw RuntimeException()
        clearLocation(currentPos)
        currentPos = newPos
        setLocation(currentPos)
    }

    fun drawLocation() {
        println(
            map.joinToString(separator = "\n", prefix = edge, postfix = edge) {
                it.joinToString(prefix = "| ", postfix = " |", separator = "")
            }
        )
    }
}

class Game {
    private val path = mutableListOf(Directions.START)

    private val north = { path.add(Directions.NORTH) }
    private val south = { path.add(Directions.SOUTH) }
    private val east = { path.add(Directions.EAST) }
    private val west = { path.add(Directions.WEST) }

    private val endLoc = 3 to 3

    private val location = Location()

    private fun move(where: () -> Boolean ) {
        where()
    }

    fun makeMove(to: String? ): Boolean {
        val delta: Pair<Int, Int>?
        when (to) {
            "n" -> {
                move(north)
                delta = -1 to 0
            }
            "s" -> {
                move(south)
                delta = 1 to 0
            }
            "e" -> {
                move(east)
                delta = 0 to 1
            }
            "w" -> {
                move(west)
                delta = 0 to -1
            }
            else -> delta = 0 to 0
        }
        try {
            location.updateLocation(delta)
        }
        catch (e: RuntimeException) {
            return end()
        }
        drawLocation()
        return checkWin()

    }

    private fun checkWin(): Boolean {
        if (endLoc == location.getLocation()) {
            println("Win")
            return false
        }
        return true
    }

    fun drawLocation() {
        location.drawLocation()

    }

    private fun printPath() {
        println(path.joinToString(separator = " -> ", prefix = "[", postfix = "]") { it.name })
    }

    val end = {
        path.add(Directions.END)
        println("GameOver")
        printPath()
        path.clear()
        false
    }

}

fun main() {
    val game = Game()
    game.drawLocation()
    while(true) {
        print("Enter a direction: n/s/e/w: ")
        if(!game.makeMove(readLine()?.trim())) break
    }

}