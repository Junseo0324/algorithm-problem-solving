package BOJ.graph

// https://www.acmicpc.net/problem/1926

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n) { mutableListOf<Int>() }
    val visited = Array(n) { BooleanArray(m) }

    val dx = listOf(1,0,-1,0)
    val dy = listOf(0,1,0,-1)
    var answer = 0
    var maxArea = 0

    repeat(n) {
        graph[it] = readln().split(" ").map { it.toInt() }.toMutableList()
    }

    fun bfs(x: Int, y: Int) {
        val queue = ArrayDeque<Pair<Int,Int>>()
        var count = 1
        visited[x][y] = true
        queue.addLast(Pair(x,y))

        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()
            for (i in 0 until 4) {
                val nx = dx[i] + curr.first
                val ny = dy[i] + curr.second

                if (!(nx in 0 until n && ny in 0 until m)) continue

                if (!visited[nx][ny] && graph[nx][ny] !=0) {
                    queue.addLast(Pair(nx,ny))
                    visited[nx][ny] = true
                    count++
                }

            }
        }
        maxArea = Math.max(maxArea,count)
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (!visited[i][j] && graph[i][j] ==1) {
                answer++
                bfs(i,j)
            }
        }
    }

    println(answer)
    println(maxArea)

}