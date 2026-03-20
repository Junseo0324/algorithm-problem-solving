package BOJ.trytty

fun main() {
    val dx = listOf(1, 1, 2, 2, -1, -1, -2, -2)
    val dy = listOf(2, -2, 1, -1, 2, -2, 1, -1)

    val answer = mutableListOf<Int>()
    repeat(readln().toInt()) {
        val n = readln().toInt()
        val (sX, sY) = readln().split(" ").map { it.toInt() }
        val (dX, dY) = readln().split(" ").map { it.toInt() }

        val graph = Array(n) { IntArray(n) { -1 } }

        if (sX == dX && sY == dY) {
            answer.add(0)
        }
        graph[sX][sY] = 0

        val queue = ArrayDeque<Pair<Int, Int>>()

        queue.addLast(sX to sY)

        while (queue.isNotEmpty()) {
            val (x, y) = queue.removeFirst()

            for (i in 0 until 8) {
                val nx = dx[i] + x
                val ny = dy[i] + y

                if (!(nx in 0 until n && ny in 0 until n)) continue

                if (graph[nx][ny] == -1) {
                    graph[nx][ny] = graph[x][y] + 1

                    if (nx == dX && ny == dY) {
                        answer.add(graph[nx][ny])
                    }
                    queue.addLast(nx to ny)
                }
            }
        }


    }

    println(answer.joinToString("\n"))


}