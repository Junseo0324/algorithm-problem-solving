package BOJ.bfs

import java.util.LinkedList

/**
 * 토마토 보관
 * 잘 익은 것 -> 1
 * 안 익은 것 -> 0
 * 토마토가 들어있지 않은 칸 -> -1
 * m = 가로 수 . n = 세로 수
 */
fun main() {
    var (m, n) = readln().split(" ").map { it.toInt() }
    var array = Array(n) { IntArray(m) }
    var dx = arrayOf(1, 0, -1, 0)
    var dy = arrayOf(0, 1, 0, -1)
    val queue = LinkedList<Pair<Int, Int>>()

    repeat(n) {
        array[it] = readln().split(" ").map { it.toInt() }.toIntArray()
        for (i in 0 until m) {
            if (array[it][i] == 1) {
                queue.offer(Pair(it, i))
            }
        }
    }

    while (queue.isNotEmpty()) {
        val curr = queue.poll()
        for (i in 0 until 4) {
            val nx = dx[i] + curr.first
            val ny = dy[i] + curr.second

            if (!(nx in 0 until n && ny in 0 until m)) continue

            if (array[nx][ny] == 0) {
                array[nx][ny] += array[curr.first][curr.second] + 1
                queue.offer(Pair(nx, ny))
            }
        }
    }

    val result = array.flatMap { it.toList() }
    println(result)

    if (result.contains(0)) {
        println(-1)
    } else {
        println(result.maxOrNull()!! - 1)
    }

}