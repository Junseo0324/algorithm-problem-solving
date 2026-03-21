package BOJ.trytty

fun main() {
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n) { IntArray(m) }

    var visited = Array(n) { IntArray(m) { -1 } }

    repeat(n) {
        graph[it] = readln().map { if (it == 'W') 1 else 0 }.toIntArray()
    }


    var answer = 0
    fun bfs(x: Int, y: Int): Int {
        val queue = ArrayDeque<Pair<Int, Int>>()

        queue.addLast(x to y)
        visited[x][y] = 0

        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()

            for (i in 0 until 4) {
                val nx = dx[i] + curr.first
                val ny = dy[i] + curr.second

                if (!(nx in 0 until n && ny in 0 until m)) continue

                if (graph[nx][ny] == 0 && visited[nx][ny] == -1) {
                    queue.addLast(nx to ny)
                    visited[nx][ny] = visited[curr.first][curr.second] + 1
                }
            }
        }

        val max = visited.maxOf {
            it.max()
        }
        return max
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (visited[i][j] == -1 && graph[i][j] == 0) {
                answer = maxOf(answer, bfs(i, j))
                visited = Array(n) { IntArray(m) { -1 } }
            }
        }
    }

    println(answer)
}