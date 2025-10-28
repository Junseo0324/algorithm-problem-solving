package BOJ.graph

// https://www.acmicpc.net/problem/2583

fun main() {
    val (m, n, k) = readln().split(" ").map { it.toInt() }
    val graph = Array(m) { IntArray(n) { 0 } }
    var answer = mutableListOf<Int>()
    val dx = listOf(1,0,-1,0)
    val dy = listOf(0,1,0,-1)
    val visited = Array(m) {BooleanArray(n)}

    repeat(k) {
        val (firstX, firstY, secondX, secondY) = readln().split(" ").map { it.toInt() }
        for (i in firstX until secondX) {
            for (j in firstY until secondY) {
                graph[j][i] = 1
            }
        }

    }

    fun bfs(x: Int,y:Int) {
        var count = 1
        val queue = ArrayDeque<Pair<Int,Int>>()
        queue.addLast(Pair(x,y))
        visited[x][y] = true

        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()

            for (i in 0 until 4) {
                val nx = curr.first + dx[i]
                val ny = curr.second + dy[i]

                if (!(nx in 0 until m && ny in 0 until n)) continue

                if (!visited[nx][ny] && graph[nx][ny] == 0) {
                    queue.addLast(Pair(nx,ny))
                    visited[nx][ny] = true
                    count++
                }
            }
        }
        answer.add(count)
    }


    for (i in 0 until m) {
        for (j in 0 until n) {
            if (!visited[i][j] && graph[i][j] == 0) {
                bfs(i,j)
            }
        }
    }

    println(answer.size)
    println(answer.sorted().joinToString(" "))
}