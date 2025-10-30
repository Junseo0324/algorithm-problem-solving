package BOJ.graph

// https://www.acmicpc.net/problem/6593

/**
 * 정육면체 -> 3차원 배열?
 * 30x 30x30 = 27000
 * L = 층, R = 행, C = 열
 * 시작 지점 = S / 탈출구 = E
 * 금 = # , 비어있는 칸 = .
 */

fun main() {
    val dx = listOf(1, 0, -1, 0, 0, 0)
    val dy = listOf(0, 1, 0, -1, 0, 0)
    val dz = listOf(0, 0, 0, 0, 1, -1)
    while (true) {
        val (l, c, r) = readln().split(" ").map { it.toInt() }
        if (l == 0 || c == 0 || r == 0) break
        val graph = Array(l) { Array(c) { IntArray(r) { -1 } } }
        val visited = Array(l) { Array(c) { BooleanArray(r) } }
        val queue = ArrayDeque<Triple<Int, Int, Int>>()
        var time = 0
        for (i in 0 until l) {
            for (j in 0 until c) {
                val line = readln().toCharArray()
                for (z in 0 until r) {
                    when (line[z]) {
                        '#' -> graph[i][j][z] = -2
                        'S' -> {
                            queue.addLast(Triple(i, j, z))
                            graph[i][j][z] = 1
                        }

                        'E' -> graph[i][j][z] = 0
                        '.' -> graph[i][j][z] = -1
                    }
                }
            }
            readln()
        }

        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()
            visited[curr.first][curr.second][curr.third] = true

            for (i in 0 until 6) {
                val nx = curr.second + dx[i]
                val ny = curr.third + dy[i]
                val nz = curr.first + dz[i]

                if (!(nx in 0 until c && ny in 0 until r && nz in 0 until l)) continue

                if (!visited[nz][nx][ny]) {
                    if (graph[nz][nx][ny] == -1) {
                        graph[nz][nx][ny] = graph[curr.first][curr.second][curr.third] + 1
                        queue.addLast(Triple(nz, nx, ny))
                    }
                    if (graph[nz][nx][ny] == 0) {
                        time = graph[curr.first][curr.second][curr.third]
                        break
                    }
                }
            }
        }

        if (time == 0) {
            println("Trapped!")
        } else {
            println("Escaped in $time minute(s).")
        }
    }
}