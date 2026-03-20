package BOJ.trytty

/**
 * 빨-초 같으 ㄴ색
 */
fun main() {
    val n = readln().toInt()
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)
    var graph = Array(n) { mutableListOf<Char>() }
    val graph2 = Array(n) { mutableListOf<Char>() }

    repeat(n) {
        graph[it] = readln().toMutableList()
    }
    for (i in graph.indices) {
        graph2[i].addAll(graph[i].map { if (it == 'R') 'G' else it })
    }
    var visited = Array(n) { BooleanArray(n+1) }
    var answer1 = 0
    var answer2 = 0
    fun bfs(x: Int, y: Int, graph: Array<MutableList<Char>>) {
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.addLast(x to y)
        visited[x][y] = true

        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()

            for (i in 0 until 4) {
                val nx = curr.first + dx[i]
                val ny = curr.second + dy[i]

                if (!(nx in 0 until n && ny in 0 until n)) continue

                if (!visited[nx][ny] && graph[nx][ny] == graph[x][y]) {
                    visited[nx][ny] = true
                    queue.addLast(nx to ny)
                }
            }
        }
    }


    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!visited[i][j]) {
                bfs(i, j, graph)
                answer1++
            }
        }
    }

    visited = Array(n) { BooleanArray(n) }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!visited[i][j]) {
                bfs(i, j, graph2)
                answer2++
            }
        }
    }

    println("$answer1 $answer2")
}