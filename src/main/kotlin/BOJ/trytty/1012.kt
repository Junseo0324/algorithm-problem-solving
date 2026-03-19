package BOJ.trytty

fun main() {
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)

    repeat(readln().toInt()) {
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

                if (!visited[nx][ny] && graph[nx][ny] != 0) {
                    visited[nx][ny] = true
                    dfs(nx, ny)
                }
            }
        }

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    dfs(i,j)
                    answer++
                }
            }
        }
        println(answer)

    }

}