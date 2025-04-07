package BOJ.bfs

import java.util.LinkedList

/**
 * 적록색약 = R - G 차이 모름
 *
 */
fun main() {
    var n = readln().toInt()
    var array = Array(n) { CharArray(n) }
    var rgArray = Array(n) { CharArray(n)}
    var visited = Array(n) { BooleanArray(n + 1) }
    var dx = arrayOf(1, 0, -1, 0)
    var dy = arrayOf(0, 1, 0, -1)

    var answer = 0
    var secondAnswer = 0

    repeat(n) {
        var input = readln()
        array[it] = input.toCharArray()

    }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (array[i][j] == 'R') {
                rgArray[i][j] = 'G'
            } else {
                rgArray[i][j] = array[i][j]
            }
        }
    }

    fun bfs(x: Int, y: Int,array: Array<CharArray>) {
        val queue = LinkedList<Pair<Int, Int>>()
        queue.offer(Pair(x, y))
        visited[x][y] = true

        while (queue.isNotEmpty()) {
            val curr = queue.poll()

            for (i in 0 until 4) {
                var nx = dx[i] + curr.first
                var ny = dy[i] + curr.second

                if (!(nx in 0 until n && ny in 0 until n)) continue

                if (!visited[nx][ny] && array[x][y] == array[nx][ny]) {
                    queue.offer(Pair(nx, ny))
                    visited[nx][ny] = true
                }
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!visited[i][j]) {
                bfs(i, j,array)
                answer++
            }
        }
    }
    visited = Array(n) { BooleanArray(n + 1) {false} }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!visited[i][j]) {
                bfs(i, j,rgArray)
                secondAnswer++
            }
        }
    }

    println(answer)
    println(secondAnswer)


}