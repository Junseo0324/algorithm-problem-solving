package programmers.practice.bruteforce

import kotlin.math.abs

// 1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]
fun main() {
    println(
        solution86971(
            n = 9,
            wires = arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 3),
                intArrayOf(3, 4),
                intArrayOf(4, 5),
                intArrayOf(4, 6),
                intArrayOf(4, 7),
                intArrayOf(7, 8),
                intArrayOf(7, 9),
            )
        )
    )
    println(
        solution86971(
            n = 4,
            wires = arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(3, 4),
            )
        )
    )
    println(
        solution86971(
            n = 7,
            wires = arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 7),
                intArrayOf(3, 7),
                intArrayOf(3, 4),
                intArrayOf(4, 5),
                intArrayOf(6, 7),
            )
        )
    )
}

fun solution86971(n: Int, wires: Array<IntArray>): Int {
    var answer: Int = Int.MAX_VALUE
    val graph = Array(n + 1) { mutableListOf<Int>() }

    var graph2 = Array(n + 1) { mutableListOf<Int>() }

    wires.forEach {
        graph[it[0]].add(it[1])
        graph[it[1]].add(it[0])

    }

    wires.forEach {
        graph[it[0]].remove(it[1])
        graph[it[1]].remove(it[0])

        answer = minOf(answer, getTreeCount(graph, n))

        graph[it[0]].add(it[1])
        graph[it[1]].add(it[0])
    }


    return answer
}


fun getTreeCount(graph: Array<MutableList<Int>>, n: Int): Int {
    var sizes = mutableListOf<Int>()
    val visited = BooleanArray(n + 1)
    var count = 0

    fun dfs(node: Int) {
        visited[node] = true
        count++
        for (next in graph[node]) {
            if (!visited[next]) {
                dfs(next)
            }
        }
    }

    for (i in 1..n) {
        if (!visited[i]) {
            count = 0
            dfs(i)
            sizes.add(count)
        }
    }
    return abs(sizes[0] - sizes[1])
}
