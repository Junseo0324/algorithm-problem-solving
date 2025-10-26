package BOJ.graph

fun main() {
    val (n,m,start) = readln().split(" ").map { it.toInt() }

    val graph = Array(n+1) { mutableListOf<Int>() }
    val visitedDfs = BooleanArray(n+1)
    val visitedBfs = BooleanArray(n+1)

    val answer = mutableListOf<Int>()
    val answerBfs = mutableListOf<Int>()
    repeat(m) {
        val (u,v) = readln().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)

    }
    graph.forEach {
        it.sort()
    }

    fun dfs(node: Int) {
        visitedDfs[node] = true
        answer.add(node)
        for (next in graph[node]) {
            if (!visitedDfs[next]) {
                dfs(next)
            }
        }
    }

    fun bfs(start: Int) {
        val queue = ArrayDeque<Int>()
        queue.addLast(start)
        visitedBfs[start] = true

        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()
            answerBfs.add(curr)
            for (next in graph[curr]) {
                if (!visitedBfs[next]) {
                    visitedBfs[next] = true
                    queue.addLast(next)
                }
            }
        }
    }

    dfs(start)
    bfs(start)
    println(answer.joinToString(" "))
    println(answerBfs.joinToString(" "))

}