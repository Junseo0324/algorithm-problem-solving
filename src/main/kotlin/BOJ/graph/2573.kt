package BOJ.graph

// https://www.acmicpc.net/problem/2573

/**
 * 주변 상하좌우에 0이 존재하냐? 그럼 그거를 -몇 해야된다.
 * 1년마다. 흠. 그럼.. 흠.
 */

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    var graph = Array(n) { mutableListOf<Int>() }
    var visited = Array(n) { BooleanArray(m) }
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)
    var time = 0
    repeat(n) {
        graph[it] = readln().split(" ").map { it.toInt() }.toMutableList()
    }

    fun bfs(x: Int, y: Int) {
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.addLast(x to y)
        visited[x][y] = true

        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()

            for (i in 0 until 4) {
                val nx = dx[i] + curr.first
                val ny = dy[i] + curr.second

                if (!(nx in 0 until n && ny in 0 until m)) continue

                if (!visited[nx][ny] && graph[nx][ny] != 0) {
                    queue.addLast(nx to ny)
                    visited[nx][ny] = true
                }
            }
        }
    }

    while (true) {
        visited = Array(n) { BooleanArray(m) }
        var mountain = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (graph[i][j] != 0 && !visited[i][j]) {
                    bfs(i, j)
                    mountain++
                }
            }
        }

        if (mountain >= 2) {
            break
        }
        if (mountain == 0) {
            time = 0
            break
        }


        val iceZero = Array(n) { IntArray(m) }
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (graph[i][j] != 0) {
                    var count = 0
                    for (k in 0 until 4) {
                        val nx = i + dx[k]
                        val ny = j + dy[k]
                        if (nx in 0 until n && ny in 0 until m && graph[nx][ny] == 0) {
                            count++
                        }
                    }
                    iceZero[i][j] = count
                }
            }
        }

        for (i in 0 until n) {
            for (j in 0 until m) {
                graph[i][j] = (graph[i][j] - iceZero[i][j]).coerceAtLeast(0)
            }
        }

        time++
    }

    println(time)
}