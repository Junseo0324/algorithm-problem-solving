package BOJ.graph

fun main() {
    val n = readln().toInt()
    val graph = Array(n) { IntArray(n) }
    repeat(n) {
        graph[it] = readln().split(" ").map { it.toInt() }.toIntArray()
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (graph[i][k]==1 && graph[k][j] ==1) {
                    graph[i][j] = 1
                }
            }
        }
    }

    graph.forEach {
        println(it.joinToString(" "))
    }
}