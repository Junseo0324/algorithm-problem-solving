package BOJ.bfs

import java.util.LinkedList

/**
 * 높이에 대한 문제 존재
 * dx dy 에 관해
 * 5 3 2
 * 3차원 배열로 처리하면 깔끔함.
 */
fun main() {
    var (m, n, h) = readln().split(" ").map { it.toInt() }
    var array = Array(h) { Array(n) { IntArray(m) } }
    var dx = arrayOf(1, 0, -1, 0, 0, 0)
    var dy = arrayOf(0, 1, 0, -1, 0, 0)
    var dz = arrayOf(0, 0, 0, 0, 1, -1)
    var queue = LinkedList<Triple<Int, Int, Int>>()

    repeat(h) {
        for (i in 0 until n) {
            array[it][i] = readln().split(" ").map { it.toInt() }.toIntArray()
            for (j in 0 until m) {
                if (array[it][i][j] == 1) {
                    queue.offer(Triple(i, j, it))
                }
            }
        }

    }

    while (queue.isNotEmpty()) {
        val curr = queue.poll()
        for (i in 0 until 6) {
            val nx = dx[i] + curr.first
            val ny = dy[i] + curr.second
            val nz = dz[i] + curr.third

            if (!(nx in 0 until n && ny in 0 until m && nz in 0 until h)) continue

            if (array[nz][nx][ny] == 0) {
                array[nz][nx][ny] += array[curr.third][curr.first][curr.second] + 1
                queue.offer(Triple(nx, ny,nz))
            }
        }
    }

    var result = mutableListOf<Int>()
    for (i in 0 until h) {
        result +=array[i].flatMap { it.toList() }
    }

    if (result.contains(0)) {
        println(-1)
    } else {
        println(result.maxOrNull()!! - 1)
    }
}