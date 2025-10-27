package BOJ.graph

// https://www.acmicpc.net/problem/1012

fun main() {
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)
    repeat(readln().toInt()) {
        //m = 가로 길이 n =세로 길이, k = 배추가 심어져 있는 위치의 개수
        val (m, n, k) = readln().split(" ").map { it.toInt() }
        val graph = Array(n) { MutableList(m) { 0 } }
        val visited = Array(n) { BooleanArray(m) }
        var answer = 0
        repeat(k) {
            val (y, x) = readln().split(" ").map { it.toInt() }
            graph[x][y] = 1
        }

        fun dfs(x: Int, y: Int) {
            visited[x][y] = true
            for (i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (!(nx in 0 until n && ny in 0 until m)) continue
                if (!visited[nx][ny] && graph[nx][ny] !=0) {
                    visited[nx][ny] = true
                    dfs(nx,ny)
                }
            }
        }

        fun bfs(x: Int, y: Int) {
            val queue = ArrayDeque<Pair<Int, Int>>()
            visited[x][y] = true
            queue.addLast(Pair(x, y))

            while (queue.isNotEmpty()) {
                val curr = queue.removeFirst()
                for (i in 0 until 4) {
                    val nx = curr.first + dx[i]
                    val ny = curr.second + dy[i]

                    if (!(nx in 0 until n && ny in 0 until m)) continue

                    if (!visited[nx][ny] && graph[nx][ny] !=0) {
                        visited[nx][ny] = true
                        queue.addLast(Pair(nx,ny))
                    }
                }
            }
        }

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    dfs(i, j)
//                    bfs(i,j)
                    answer++
                }
            }
        }
        println(answer)
    }
}