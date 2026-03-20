package BOJ.trytty

fun main() {
    val n = readln().toInt()
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)
    val graph = Array(n) { IntArray(n) }
    val visited = Array(n) { BooleanArray(n) }
    repeat(n) {
        graph[it] = readln().map { it.digitToInt() }.toIntArray()
    }

    var answer = mutableListOf<Int>()
    fun bfs(x: Int, y: Int) {
        val queue = ArrayDeque<Pair<Int, Int>>()
        var count = 1
        queue.addLast(x to y)
        visited[x][y] = true

        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()

            for (i in 0 until 4) {
                val nx = dx[i] + curr.first
                val ny = dy[i] + curr.second

                if (!(nx in 0 until n && ny in 0 until n)) continue

                if (!visited[nx][ny] && graph[nx][ny] == 1) {
                    visited[nx][ny] = true
                    queue.addLast(nx to ny)
                    count++
                }
            }
        }

        answer.add(count)
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!visited[i][j] && graph[i][j] == 1) {
                bfs(i, j)
            }
        }
    }

    println(answer.size)
    println(answer.sorted().joinToString("\n"))

}