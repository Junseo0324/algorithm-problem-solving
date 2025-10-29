package BOJ.graph

// https://www.acmicpc.net/problem/10026


fun main() {
    val n = readln().toInt()
    val graph = Array(n) { CharArray(n) }
    val graph2 = Array(n) { CharArray(n) }
    var visited = Array(n) { BooleanArray(n) }
    var answer = 0
    var answer2 = 0
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)
    repeat(n) {
        graph[it] = readln().toCharArray()
    }

    fun bfs(x: Int, y: Int, graph: Array<CharArray>) {
        val queue = ArrayDeque<Pair<Int, Int>>()
        visited[x][y] = true
        queue.addLast(Pair(x, y))

        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()
            for (i in 0 until 4) {
                val nx = dx[i] + curr.first
                val ny = dy[i] + curr.second

                if (!(nx in 0 until n && ny in 0 until n)) continue

                if (!visited[nx][ny] && graph[x][y] == graph[nx][ny]) {
                    visited[nx][ny] = true
                    queue.addLast(Pair(nx, ny))
                }
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!visited[i][j]) {
                bfs(i, j, graph)
                answer++
            }
        }
    }

    visited = Array(n) { BooleanArray(n) { false } }

    for (i in graph.indices) {
        for (j in graph[i].indices) {
            if (graph[i][j] == 'G') {
                graph2[i][j] = 'R'
            } else {
                graph2[i][j] = graph[i][j]
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!visited[i][j]) {
                bfs(i, j, graph2)
                answer2++
            }
        }
    }

    println("$answer $answer2")
}