package BOJ.trytty

fun main() {
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)

    val (n, m) = readln().split(" ").map { it.toInt() }

    val graph = Array(n) { IntArray(m) }

    repeat(n) {
        graph[it] = readln().map { it.digitToInt() }.toIntArray()
    }

    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.addLast(0 to 0)

    while (queue.isNotEmpty()) {
        val (x, y) = queue.removeFirst()

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (!(nx in 0 until n && ny in 0 until m)) continue

            if (graph[nx][ny] == 1) {
                graph[nx][ny] = graph[x][y] + 1
                queue.addLast(nx to ny)
            }
        }
    }

    println(graph[n - 1][m - 1])
}