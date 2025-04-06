package dfs

fun main() {
    var (n,m) = readln().split(" ").map { it.toInt() }
    var graph = Array(n+1){ArrayList<Int>()}

    var visited = BooleanArray(n+1)

    var answer= 0
    repeat(m) {
        var (start, depart) = readln().split(" ").map { it.toInt() }
        graph[start].add(depart)
        graph[depart].add(start)
    }

    fun dfs(x: Int) {
        visited[x] = true
        for (i in graph[x]) {
            if (!visited[i]) {
                dfs(i)
            }
        }
    }
    for (i in 1..n) {
        if (!visited[i]) {
            dfs(i)
            answer++
        }
    }
    println(answer)
}