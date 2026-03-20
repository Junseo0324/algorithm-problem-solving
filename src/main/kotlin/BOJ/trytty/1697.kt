package BOJ.trytty

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }

    if (n >= k) {
        println(n - k)
        return
    }

    val visited = IntArray(100001) { -1 }

    val queue = ArrayDeque<Int>()

    queue.addLast(n)
    visited[n] = 0

    while (queue.isNotEmpty()) {
        val curr = queue.removeFirst()

        if (curr == k) {
            println(visited[curr])
            return
        }

        for (next in listOf(curr - 1, curr + 1, curr * 2)) {
            if (next in 0 until 100001 && visited[next] == -1) {
                visited[next] = visited[curr] + 1
                queue.addLast(next)
            }
        }
    }

}