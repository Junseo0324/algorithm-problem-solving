package BOJ.graph

// https://www.acmicpc.net/problem/5014

fun main() {
    val (f, s, g, u, d) = readln().split(" ").map { it.toInt() }

    val graph = IntArray(f + 1)
    val queue = ArrayDeque<Int>()
    queue.add(s)
    graph[s] = 1
    fun bfs() {
        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()

            if (current == g) {
                println(graph[current] - 1)
                return
            }

            if (current + u <= f && graph[current + u] == 0) {
                graph[current + u] = graph[current] + 1
                queue.add(current + u)
            }

            if (current - d >= 1 && graph[current - d] == 0) {
                graph[current - d] = graph[current] + 1
                queue.add(current - d)
            }
        }

        println("use the stairs")
    }
    bfs()
}