package BOJ.graph

// https://www.acmicpc.net/problem/2178


fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)

    val graph = Array(n) { mutableListOf<Int>() }
    val visited = Array(n) { BooleanArray(m) }
    repeat(n) {
        graph[it] = readln().map { it.digitToInt() }.toMutableList()
    }

    fun bfs(x: Int, y: Int) {
        val queue = ArrayDeque<Pair<Int, Int>>()
        visited[x][y] = true
        queue.addLast(Pair(x, y))
        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()
            for (i in 0 until 4) {
                val nx = curr.first + dx[i]
                val ny = curr.second + dy[i]

                if (!(nx in 0 until n && ny in 0 until m)) continue
                if (!visited[nx][ny] && graph[nx][ny] != 0) {
                    graph[nx][ny] = graph[curr.first][curr.second] + 1
                    visited[nx][ny] = true
                    queue.addLast(Pair(nx, ny))
                }
            }
        }
    }

    bfs(0, 0)
    println(graph[n - 1][m - 1])

}