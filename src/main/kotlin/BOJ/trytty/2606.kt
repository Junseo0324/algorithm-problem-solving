package BOJ.trytty

fun main() {
    val n = readln().toInt()

    val graph = Array(n+1) { mutableListOf<Int>() }
    val visited = BooleanArray(n+1)

    repeat(readln().toInt()) {
        val (f,s) = readln().split(" ").map { it.toInt() }
        graph[f].add(s)
        graph[s].add(f)
    }

    fun dfs(node: Int) {
        visited[node] = true

        for (next in graph[node]) {
            if (!visited[next]) {
                dfs(next)
            }
        }
    }

    dfs(1)
    println(visited.count { it }-1)
}
