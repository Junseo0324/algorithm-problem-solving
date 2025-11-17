package BOJ.graph

// https://www.acmicpc.net/problem/6118

/**
 * 첫 번째는 숨어야 하는 헛간 번호를(만약 거리가 같은 헛간이 여러개면 가장 작은 헛간 번호를 출력한다)
 * 두 번째는 그 헛간까지의 거리를,
 * 세 번째는 그 헛간과 같은 거리를 갖는 헛간의 개수를 출력해야한다.
 *
 *
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }

    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    val distanceArray = IntArray(n + 1) { -1 }

    fun bfs() {
        val queue = ArrayDeque<Int>()
        queue.addLast(1)
        distanceArray[1] = 0

        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()

            for (next in graph[curr]) {
                if (distanceArray[next] == -1) {
                    distanceArray[next] = distanceArray[curr] + 1
                    queue.addLast(next)
                }
            }
        }
    }
    bfs()
    var maxDistance = 0
    var node = 0
    var count = 0

    for (i in 1..n) {
        if (distanceArray[i] > maxDistance) {
            maxDistance = distanceArray[i]
            node = i
            count = 1
        } else if (distanceArray[i] == maxDistance) {
            count++
        }
    }

    println("$node $maxDistance $count")
}