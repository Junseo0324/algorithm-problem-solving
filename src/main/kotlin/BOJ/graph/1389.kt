package BOJ.graph

// https://www.acmicpc.net/problem/1389

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val answer = IntArray(n + 1)
    var array = IntArray(n + 1) { 0 }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    var visited = BooleanArray(n + 1)

    fun bfs(node: Int) {
        val queue = ArrayDeque<Int>()
        queue.addLast(node)
        visited[node] = true
        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()
            for (next in graph[curr]) {
                if (!visited[next]) {
                    queue.addLast(next)
                    visited[next] = true
                    array[next] = array[curr] + 1
                }
            }
        }
    }

    for (i in 1..n) {
        visited = BooleanArray(n + 1)
        array = IntArray(n + 1) { 0 }
        array[i] = 0
        bfs(i)
        answer[i] = array.sum()
    }

    val result = (1..n).minBy { answer[it] }
    println(result)

}