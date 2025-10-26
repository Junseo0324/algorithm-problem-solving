package BOJ.graph

// https://www.acmicpc.net/problem/5567

fun main() {
    val n = readln().toInt()
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val visited = BooleanArray(n + 1)
    var answer = 0

    repeat(readln().toInt()) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }


    fun bfs(start: Int) {
        val queue = ArrayDeque<Pair<Int,Int>>()
        queue.addLast(Pair(start,0))
        visited[start] = true
        while (queue.isNotEmpty()) {
            var (node,depth) = queue.removeFirst()

            if (depth == 2) continue

            for (next in graph[node]) {
                if (!visited[next]) {
                    visited[next] = true
                    answer++
                    queue.addLast(Pair(next,depth+1))
                }
            }
        }
    }
    bfs(1)

    println(answer)

}