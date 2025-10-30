package BOJ.graph

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val queue = ArrayDeque<Pair<Int, Int>>()

    val visited = IntArray(100_001) { Int.MAX_VALUE }
    queue.addLast(Pair(n, 0))
    visited[n] = 0
    var answer = 0

    while (queue.isNotEmpty()) {
        val curr = queue.removeFirst()

        if (curr.first == k) {
            answer = curr.second
            break
        }

        if (curr.first * 2 in 0..100_000) {
            if (curr.second < visited[curr.first*2]) {
                visited[curr.first*2] = curr.second
                queue.addFirst(Pair(curr.first * 2, curr.second))

            }
        }

        if (curr.first + 1 in 0..100_000) {
            if (curr.second + 1 < visited[curr.first+1]) {
                visited[curr.first + 1] = curr.second+1
                queue.addLast(Pair(curr.first + 1, curr.second + 1))
            }
        }
        if (curr.first - 1 in 0..100_000) {
            if (curr.second + 1 < visited[curr.first-1]) {
                queue.addLast(Pair(curr.first - 1, curr.second + 1))
                visited[curr.first - 1] = curr.second+1
            }
        }

    }

    println(answer)

}