package BOJ.graph

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[b].add(a)
    }
    val countList = IntArray(n + 1)
    var maxCount = 0
    val answer = mutableListOf<Int>()


    fun bfs(start: Int): Int {
        val visited = BooleanArray(n + 1)
        val queue = ArrayDeque<Int>()

        queue.addLast(start)
        visited[start] = true
        var count = 1
        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()

            for (next in graph[curr]) {
                if (!visited[next]) {
                    visited[next] = true
                    queue.addLast(next)
                    count++
                }
            }
        }

        return count
    }


    for (i in 1..n) {
        countList[i] = bfs(i)
        if (countList[i] > maxCount) {
            maxCount = countList[i]
        }
    }

    for (i in 1..n) {
        if (countList[i] == maxCount)
            answer.add(i)
    }
    println(answer.joinToString(" "))
}