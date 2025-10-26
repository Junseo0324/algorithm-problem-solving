package BOJ.graph

// https://www.acmicpc.net/problem/11724

fun main() {
    val (n,m) = readln().split(" ").map { it.toInt() }

    val graph = Array(n+1) { mutableListOf<Int>() }
    val visitedDfs = BooleanArray(n+1)
    val visitedBfs = BooleanArray(n+1)

    repeat(m) {
        val (u,v) = readln().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }

    fun dfs(node: Int) {
        visitedDfs[node] = true
        for (next in graph[node]) {
            if (!visitedDfs[next]) dfs(next)
        }
    }

    fun bfs(start: Int) {
        val queue = ArrayDeque<Int>()
        queue.addLast(start)
        visitedBfs[start] = true

        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()
            for (next in graph[curr]) {
                if (!visitedDfs[next]) {
                    visitedBfs[next] = true
                    queue.addLast(next)
                }
            }
        }
    }

    var d_count = 0
    var b_count = 0
    for (i in 1..n) {
        if (!visitedDfs[i]) {
            dfs(i)
            d_count++
        }
    }
    for (i in 1..n) {
        if (!visitedBfs[i]) {
            bfs(i)
            b_count++
        }
    }
    println(d_count)
    println(b_count)
}