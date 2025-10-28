package BOJ.graph

fun main() {
    val (n,k) = readln().split(" ").map { it.toInt() }
    if (n >= k) {
        println(n-k)
        println(1)
        return
    }
    val visited = IntArray(100_001) {-1}
    val answer = IntArray(100_001)

    val queue = ArrayDeque<Int>()

    queue.addLast(n)
    visited[n] = 0
    answer[n] = 1

    while (queue.isNotEmpty()) {
        val curr = queue.removeFirst()
        val currTime = visited[curr]

        for (next in listOf(curr-1,curr+1,curr *2)) {
            if (next !in 0..100_000) continue

            if (visited[next] == -1) {
                visited[next] = currTime+1
                answer[next] = answer[curr]
                queue.addLast(next)
            } else if (visited[next] == currTime + 1) {
                answer[next] += answer[curr]
            }

        }
    }

    println(visited[k])
    println(answer[k])
}