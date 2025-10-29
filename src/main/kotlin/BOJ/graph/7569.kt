package BOJ.graph

// https://www.acmicpc.net/problem/7569

fun main() {
    val (m, n, h) = readln().split(" ").map { it.toInt() }
    val graph = Array(h) { Array(n) { IntArray(m) } }
    val dx = listOf(1, 0, -1, 0, 0, 0)
    val dy = listOf(0, 1, 0, -1, 0, 0)
    val dz = listOf(0, 0, 0, 0, 1, -1)
    val queue = ArrayDeque<Triple<Int,Int,Int>>()
    val result = mutableListOf<Int>()

    repeat(h) { z ->
        for (i in 0 until n) {
            graph[z][i] = readln().split(" ").map { it.toInt() }.toIntArray()
            for (j in 0 until m) {
                if (graph[z][i][j] == 1) {
                    queue.addLast(Triple(i,j,z))
                }
            }
        }
    }

    while (queue.isNotEmpty()) {
        val (x,y,z) = queue.removeFirst()
        for (i in 0 until 6) {
            val nx = dx[i] + x
            val ny = dy[i] + y
            val nz = dz[i] + z

            if (!(nx in 0 until n && ny in 0 until m && nz in 0 until h)) continue

            if (graph[nz][nx][ny] == 0) {
                graph[nz][nx][ny] += graph[z][x][y] +1
                queue.addLast(Triple(nx,ny,nz))
            }
        }
    }

    repeat(h) { height ->
        result += graph[height].flatMap { it.toList() }
    }
    graph.forEach { first ->
        first.forEach {
            it.forEach {
                print("$it ")
            }
            println()
        }
        println()
    }

    if (result.contains(0)) {
        println(-1)
    } else {
        println(result.maxOrNull()!! -1)
    }

}