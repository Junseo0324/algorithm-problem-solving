package programmers.practice.graph

fun main() {
    println(
        solution49191(
            n = 5,
            results = arrayOf(
                intArrayOf(4, 3),
                intArrayOf(4, 2),
                intArrayOf(3, 2),
                intArrayOf(1, 2),
                intArrayOf(2, 5),
            )
        )
    )
}

fun solution49191(n: Int, results: Array<IntArray>): Int {
    var answer = 0
    val winGraph = Array(n + 1) { mutableListOf<Int>() }
    val loseGraph = Array(n + 1) { mutableListOf<Int>() }


    for ((a, b) in results) {
        winGraph[a].add(b)
        loseGraph[b].add(a)
    }

    fun bfs(start: Int, graph: Array<MutableList<Int>>): Int {
        val visited = BooleanArray(n + 1)
        val queue = ArrayDeque<Int>()
        queue.addLast(start)

        var count = 0

        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()
            for (next in graph[curr]) {
                if (!visited[next]) {
                    queue.addLast(next)
                    visited[next] = true
                    count++
                }
            }
        }
        return count
    }

    for (i in 1..n) {
        val winCount = bfs(i, winGraph)
        val loseCount = bfs(i, loseGraph)

        if (winCount + loseCount == n - 1) {
            answer++
        }
    }

    return answer
}