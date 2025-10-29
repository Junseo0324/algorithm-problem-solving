package BOJ.graph

// https://www.acmicpc.net/problem/7576

/**
 * 1 - 익은 토마토
 * 0 - 익지 않은 토마토
 * -1 - 들어있지 않은 곳
 */

fun main() {
    val (m, n) = readln().split(" ").map { it.toInt() }
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)
    val graph = Array(n) { IntArray(m) }
    val queue = ArrayDeque<Pair<Int,Int>>()

    repeat(n) {
        graph[it] = readln().split(" ").map { it.toInt() }.toIntArray()

        for (i in 0 until m) {
            if (graph[it][i] == 1) {
                queue.addLast(Pair(it,i))
            }
        }
    }

    while (queue.isNotEmpty()) {
        val curr = queue.removeFirst()
        for (i in 0 until 4) {
            val nx = dx[i] + curr.first
            val ny = dy[i] + curr.second

            if (!(nx in 0 until n && ny in 0 until m)) continue

            if (graph[nx][ny] == 0) {
                graph[nx][ny] += graph[curr.first][curr.second] +1
                queue.addLast(Pair(nx,ny))
            }

        }
    }

    val result = graph.flatMap { it.toList() }
    if (result.contains(0)) {
        println(-1)
    } else {
        println(result.maxOrNull()!! -1)
    }

}