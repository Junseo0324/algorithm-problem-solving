package BOJ.graph

fun main() {
    repeat(readln().toInt()) {
        val l = readln().toInt()
        val graph = Array(l) { IntArray(l) { 0 } }
        val (startX, startY) = readln().split(" ").map { it.toInt() }
        val (endX, endY) = readln().split(" ").map { it.toInt() }
        val dx = listOf(2, 2, 1, -1, -2, -2, -1, 1)
        val dy = listOf(1, -1, -2, -2, -1, 1, 2, 2)

        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.addLast(Pair(startX, startY))
        graph[startX][startY] = 1
        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()

            for (i in 0 until 8) {
                val nx = curr.first + dx[i]
                val ny = curr.second + dy[i]

                if (!(nx in 0 until l && ny in 0 until l)) continue

                if (graph[nx][ny] == 0) {
                    graph[nx][ny] = graph[curr.first][curr.second] + 1
                    queue.addLast(Pair(nx, ny))
                }
            }
        }

        println(graph[endX][endY] - 1)

    }
}