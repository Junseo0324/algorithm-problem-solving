package programmers.greedy

import kotlin.math.cos

fun main() {
    println(
        solution42861(
            n = 4,
            costs = arrayOf(
                intArrayOf(0, 1, 1),
                intArrayOf(0, 2, 2),
                intArrayOf(1, 2, 5),
                intArrayOf(1, 3, 1),
                intArrayOf(2, 3, 8),
            )
        )
    )
}

fun solution42861(n: Int, costs: Array<IntArray>): Int {
    var answer = 0
    val parent = IntArray(n) { it }

    fun find(x:Int): Int {
        if (parent[x] !=x) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    fun union(a:Int,b:Int) {
        val rootA = find(a)
        val rootB = find(b)
        if (rootA != rootB) {
            parent[rootB] = rootA
        }
    }

    costs.sortBy { it[2] }

    for ((a,b,cost) in costs) {
        if (find(a) != find(b)) {
            union(a,b)
            answer += cost
        }
    }

    return answer
}