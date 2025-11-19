package BOJ.graph

// https://www.acmicpc.net/problem/2644

fun main() {
    val n = readln().toInt()
    val (a, b) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val array = IntArray(n + 1)
    repeat(readln().toInt()) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        graph[x].add(y)
        graph[y].add(x)
    }
    val visited = BooleanArray(n + 1)

    array[a] = 0
    fun bfs() {
        val queue = ArrayDeque<Int>()
        queue.addLast(a)
        visited[a] = true

        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()
            for (next in graph[curr]) {
                if (!visited[next]) {
                    visited[next] = true
                    array[next] = array[curr] + 1
                    queue.addLast(next)
                }
            }
        }
    }

    bfs()
    if (array[b] != 0) {
        println(array[b])
    } else {
        println(-1)
    }
}