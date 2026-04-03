package programmers.practice.graph

fun main() {
    println(
        solution49189(
            n = 6,
            edge = arrayOf(
                intArrayOf(3, 6),
                intArrayOf(4, 3),
                intArrayOf(3, 2),
                intArrayOf(1, 3),
                intArrayOf(1, 2),
                intArrayOf(2, 4),
                intArrayOf(5, 2),
            )
        )
    )
}


fun solution49189(n: Int, edge: Array<IntArray>): Int {
    var answer = 0
    val graph = Array(n + 1) { mutableListOf<Int>() }
    for ((one, two) in edge) {
        graph[one].add(two)
        graph[two].add(one)
    }
    val visited = IntArray(n + 1) { 0 }

    fun bfs(node: Int) {
        val queue = ArrayDeque<Int>()
        queue.addLast(node)

        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()

            for (next in graph[curr]) {
                if (visited[next] == 0) {
                    if (next != 1) {
                        visited[next] = visited[curr] + 1
                        queue.addLast(next)
                    }
                }
            }
        }
    }

    bfs(1)
    val max = visited.maxOrNull()!!
    answer = visited.count { it == max }
    return answer
}