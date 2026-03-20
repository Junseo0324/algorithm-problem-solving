package BOJ.trytty

fun main() {
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)
    val (m, n) = readln().split(" ").map { it.toInt() }
    val queue = ArrayDeque<Pair<Int, Int>>()
    val graph = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        val data = readln().split(" ").map { it.toInt() }

        for (j in 0 until m) {
            graph[i][j] = data[j]

            if (graph[i][j] == 1) {
                queue.addLast(i to j)
            }
        }
    }

    if (graph.all { it.all { it != 0 } }) {
        println(0)
        return
    }

    while (queue.isNotEmpty()) {
        val curr = queue.removeFirst()

        for (i in 0 until 4) {
            val nx = dx[i] + curr.first
            val ny = dy[i] + curr.second

            if (!(nx in 0 until n && ny in 0 until m)) continue

            if (graph[nx][ny] == 0) {
                graph[nx][ny] = graph[curr.first][curr.second] +1
                queue.addLast(nx to ny)
            }
        }
    }

    if (graph.any { it.any { it == 0 } }) {
        println(-1)
    } else {
        println(graph.maxOf { it.max() } - 1)
    }
}