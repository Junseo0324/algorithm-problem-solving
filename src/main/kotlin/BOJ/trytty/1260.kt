package BOJ.trytty

fun main() {
    val (n, m, start) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    var visited = BooleanArray(n + 1)

    repeat(m) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }
    for (i in 1..n) {
        graph[i].sort()
    }

    val bfs_answer = mutableListOf<Int>()
    val dfs_answer = mutableListOf<Int>()

    fun dfs(node: Int) {
        visited[node] = true
        dfs_answer.add(node)
        for (next in graph[node]) {
            if (!visited[next]) {
                dfs(next)

            }
        }
    }

    dfs(start)

    visited = BooleanArray(n + 1)
    fun bfs(node: Int) {
        val queue = ArrayDeque<Int>()
        queue.addLast(node)
        visited[node] = true

        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()
            bfs_answer.add(curr)
            for (next in graph[curr]) {
                if (!visited[next]) {
                    queue.addLast(next)
                    visited[next] = true

                }
            }
        }
    }

    bfs(start)

    println(dfs_answer.joinToString(" "))
    println(bfs_answer.joinToString(" "))
}