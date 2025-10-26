package BOJ.graph

// https://www.acmicpc.net/problem/2606

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val graph = Array(n+1) { mutableListOf<Int>() }
    var count = 0
    val visited = BooleanArray(n+1)

    repeat(m) {
        val (u,v) = readln().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }

    fun dfs(node: Int) {
        visited[node] = true
        for (next in graph[node]) {
            if (!visited[next]) {
                visited[next] = true
                count++
                dfs(next)
            }
        }
    }

    dfs(1)
    println(count)
}